package core;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.MethodContext;

public class API {
    public static String status = "Script starting...";
    public static int profit = 0;
    private static MethodContext context;

    public API(MethodContext context) { API.context = context; }

    public static int sleepUntil() { return (int)Calculations.nextGaussianRandom(4000, 2000); }
    public static int sleep() { return (int)Calculations.nextGaussianRandom(400, 150); }

    public static boolean inBankArea() { return Areas.bank.contains(context.getLocalPlayer()); }
    public static boolean inTurothArea() { return Areas.turoth.contains(context.getLocalPlayer()); }
    public static boolean inDungeonArea() { return Areas.dungeon.contains(context.getLocalPlayer()); }
    public static boolean inDungeonEntranceArea() { return Areas.dungeonEntrance.contains(context.getLocalPlayer()); }

    public static String[] getPickupItems() {
        return new String[] {"Adamant full helm", "Mithril kiteshield", "Rune dagger", "Mystic robe bottom (light)", "Nature rune", "Grimy ranarr weed", "Grimy avantoe",
                "Grimy kwuarm", "Grimy cadantine", "Grimy lantadyme", "Coins", "Adamantite ore", "Uncut ruby", "Uncut emerald", "Uncut diamond", "Loop half of key",
                "Tooth half of key", "Rune javelin", "Rune spear", "Shield left half", "Dragon spear", "Grimy harralander", "Mithril spear", "Grimy irit leaf", "Grimy dwarf weed",
                "Leaf-bladed sword", "Toadflax seed", "Avantoe seed", "Snapdragon seed", "Cadantine seed", "Lantadyme seed", "Snape grass seed", "Torstol seed", "Limpwurt root"};
    }
}
