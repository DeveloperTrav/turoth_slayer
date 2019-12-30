package core.nodes;

import core.API;
import core.Areas;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.wrappers.interactive.NPC;

import java.util.Objects;

public class Attack extends TaskNode {

    @Override
    public int priority() {
        return 2;
    }

    @Override
    public boolean accept() {
        log("Attack: " + canAttack());
        log("ReAttack: " + canReAttack());
        return canAttack() || canReAttack();
    }

    @Override
    public int execute() {
        if (!getWalking().isRunEnabled()) {
            API.status = "Turning on run...";
            getWalking().toggleRun();
            sleepUntil(() -> getWalking().isRunEnabled(), API.sleepUntil());
        }

        if (!canReAttack()) {
            NPC target = getNpcs().closest(npc -> Objects.nonNull(npc) && !npc.isInCombat() && npc.getName().equals("Turoth") && Areas.turoth.contains(npc) && npc.getLevel() == 83);

            if (getMap().canReach(target.getTile())) {
                if (target != null) {
                    API.status = "Attacking Turoth...";
                    getCamera().rotateToEntity(target);
                    target.interact("Attack");
                    sleepUntil(() -> getLocalPlayer().isInCombat(), API.sleepUntil());
                }
            } else {
                API.status = "Walking to turoth's...";
                getWalking().walk(target);
                sleepUntil(() -> getLocalPlayer().getTile().equals(target.getTile()), API.sleepUntil());
            }
        } else {
            API.status = "Reattacking turoth...";
            getLocalPlayer().getCharacterInteractingWithMe().interact("Attack");
            sleepUntil(() -> getLocalPlayer().isInCombat(), API.sleepUntil());
        }

        return API.sleep();
    }

    private boolean canAttack() {
        return !getLocalPlayer().isInCombat() && API.inTurothArea() && getSkills().getBoostedLevels(Skill.HITPOINTS) >= 50 && getLocalPlayer().getCharacterInteractingWithMe() == null;
    }

    private boolean canReAttack() {
        return !getLocalPlayer().isInCombat() && API.inDungeonArea() && getLocalPlayer().getCharacterInteractingWithMe() != null && Areas.turoth.contains(getLocalPlayer().getCharacterInteractingWithMe())
                && getLocalPlayer().getCharacterInteractingWithMe().getName().equals("Turoth");
    }
}
