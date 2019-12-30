package core.nodes;

import core.API;
import core.Areas;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.tabs.Tab;
import org.dreambot.api.script.TaskNode;

public class Bank extends TaskNode {

    @Override
    public int priority() {
        return 3;
    }

    @Override
    public boolean accept() {
        log("Bank: " + canBank());
        return canBank();
    }

    @Override
    public int execute() {
        if (API.inBankArea()) {
            if (!getBank().isOpen()) {
                API.status = "Opening bank...";
                getBank().openClosest();
                sleepUntil(() -> getBank().isOpen(), API.sleepUntil());
            }

            if (getBank().isOpen()) {
                if (!getInventory().isEmpty() && !getInventory().contains("Camelot teleport")) {
                    API.status = "Depositing items...";
                    getBank().depositAllItems();
                    sleepUntil(() -> getInventory().isEmpty(), API.sleepUntil());
                }

                if (!getInventory().contains("Camelot teleport")) {
                    API.status = "Getting teleport...";
                    getBank().withdraw("Camelot teleport", 1);
                    sleepUntil(() -> getInventory().contains("Camelot teleport"), API.sleepUntil());
                }

                if (!getInventory().contains("Lobster")) {
                    API.status = "Getting food...";
                    getBank().withdraw("Lobster", 20);
                    sleepUntil(() -> getInventory().contains("Lobster"), API.sleepUntil());
                }
            }
        }

        if (API.inDungeonArea() && !getInventory().contains("Lobster")) {
            if (getTabs().isOpen(Tab.INVENTORY)) {
                if (getInventory().contains("Camelot teleport")) {
                    API.status = "Using teleport...";
                    getInventory().get("Camelot teleport").interact("Break");
                    sleepUntil(() -> !API.inTurothArea(), API.sleepUntil());
                }
            } else {
                getTabs().openWithMouse(Tab.INVENTORY);
            }
        }

        if (!API.inBankArea() && !API.inDungeonArea()) {
            API.status = "Walking to bank...";
            if (getWalking().shouldWalk(Calculations.random(4, 7)) && !getLocalPlayer().isAnimating()) {
                getWalking().walk(Areas.bank.getCenter().getRandomizedTile(3));
                sleep(2000, 2500);
            }
        }

        return API.sleep();
    }

    private boolean canBank() {
        return !getInventory().contains("Lobster") || !getInventory().contains("Camelot teleport");
    }
}
