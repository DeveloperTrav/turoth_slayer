import core.API;
import core.nodes.*;
import org.dreambot.api.methods.walking.pathfinding.impl.web.WebFinder;
import org.dreambot.api.methods.walking.web.node.AbstractWebNode;
import org.dreambot.api.methods.walking.web.node.impl.BasicWebNode;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.impl.TaskScript;
import org.dreambot.api.utilities.Timer;

import java.awt.*;

@ScriptManifest(category = Category.COMBAT, name = "Turoth Slayer", description = "Slay turoths", author = "NotJohn", version = 1.0)
public class Main extends TaskScript {
    private final Timer timer = new Timer();

    private final API api = new API(this);
    public void onStart() {
        addNodes(new Bank());
        addNodes(new Eat());
        addNodes(new Pickup());
        addNodes(new Attack());
        addNodes(new Traverse());

        BasicWebNode bwn1 = new BasicWebNode(2805, 10001);
        BasicWebNode bwn2 = new BasicWebNode(2797, 9996);
        BasicWebNode bwn3 = new BasicWebNode(2789, 9995);
        BasicWebNode bwn4 = new BasicWebNode(2781, 9998);
        BasicWebNode bwn5 = new BasicWebNode(2776, 10004);
        BasicWebNode bwn6 = new BasicWebNode(2776, 10010);
        BasicWebNode bwn7 = new BasicWebNode(2781, 10015);
        BasicWebNode bwn8 = new BasicWebNode(2787, 10018);
        BasicWebNode bwn9 = new BasicWebNode(2793, 10018);
        BasicWebNode bwn10 = new BasicWebNode(2800, 10017);
        BasicWebNode bwn11 = new BasicWebNode(2804, 10020);
        BasicWebNode bwn12 = new BasicWebNode(2803, 10026);
        BasicWebNode bwn13 = new BasicWebNode(2800, 10031);
        BasicWebNode bwn14 = new BasicWebNode(2792, 10033);
        BasicWebNode bwn15 = new BasicWebNode(2787, 10035);
        BasicWebNode bwn16 = new BasicWebNode(2781, 10035);
        BasicWebNode bwn17 = new BasicWebNode(2774, 10030);
        BasicWebNode bwn18 = new BasicWebNode(2766, 10034);
        BasicWebNode bwn19 = new BasicWebNode(2761, 10037);
        BasicWebNode bwn20 = new BasicWebNode(2757, 10028);
        BasicWebNode bwn21 = new BasicWebNode(2762, 10021);
        BasicWebNode bwn22 = new BasicWebNode(2767, 10016);
        BasicWebNode bwn23 = new BasicWebNode(2760, 10010);
        BasicWebNode bwn24 = new BasicWebNode(2761, 10002);
        BasicWebNode bwn25 = new BasicWebNode(2760, 9995);
        BasicWebNode bwn26 = new BasicWebNode(2750, 9994);
        BasicWebNode bwn27 = new BasicWebNode(2745, 9999);
        BasicWebNode bwn28 = new BasicWebNode(2742, 10006);
        BasicWebNode bwn29 = new BasicWebNode(2745, 10017);
        BasicWebNode bwn30 = new BasicWebNode(2745, 10027);
        BasicWebNode bwn31 = new BasicWebNode(2739, 10033);
        BasicWebNode bwn32 = new BasicWebNode(2730, 10028);
        BasicWebNode bwn33 = new BasicWebNode(2728, 10019);
        BasicWebNode bwn34 = new BasicWebNode(2721, 10023);
        BasicWebNode bwn35 = new BasicWebNode(2720, 10030);
        BasicWebNode bwn36 = new BasicWebNode(2711, 10030);
        BasicWebNode bwn37 = new BasicWebNode(2706, 10022);
        BasicWebNode bwn38 = new BasicWebNode(2703, 10015);
        BasicWebNode bwn39 = new BasicWebNode(2718, 10010);
        BasicWebNode bwn40 = new BasicWebNode(2711, 10012);
        BasicWebNode bwn41 = new BasicWebNode(2723, 10005);

        bwn1.addConnections(bwn2);
        bwn2.addConnections(bwn1);
        bwn2.addConnections(bwn3);
        bwn3.addConnections(bwn2);
        bwn3.addConnections(bwn4);
        bwn4.addConnections(bwn3);
        bwn4.addConnections(bwn5);
        bwn5.addConnections(bwn4);
        bwn5.addConnections(bwn6);
        bwn6.addConnections(bwn5);
        bwn6.addConnections(bwn7);
        bwn7.addConnections(bwn6);
        bwn7.addConnections(bwn8);
        bwn8.addConnections(bwn7);
        bwn8.addConnections(bwn9);
        bwn9.addConnections(bwn8);
        bwn9.addConnections(bwn10);
        bwn10.addConnections(bwn9);
        bwn10.addConnections(bwn11);
        bwn11.addConnections(bwn10);
        bwn11.addConnections(bwn12);
        bwn12.addConnections(bwn11);
        bwn12.addConnections(bwn13);
        bwn13.addConnections(bwn12);
        bwn13.addConnections(bwn14);
        bwn14.addConnections(bwn13);
        bwn14.addConnections(bwn15);
        bwn15.addConnections(bwn14);
        bwn15.addConnections(bwn16);
        bwn16.addConnections(bwn15);
        bwn16.addConnections(bwn17);
        bwn17.addConnections(bwn16);
        bwn17.addConnections(bwn18);
        bwn18.addConnections(bwn17);
        bwn18.addConnections(bwn19);
        bwn19.addConnections(bwn18);
        bwn19.addConnections(bwn20);
        bwn20.addConnections(bwn19);
        bwn20.addConnections(bwn21);
        bwn21.addConnections(bwn20);
        bwn21.addConnections(bwn22);
        bwn22.addConnections(bwn21);
        bwn22.addConnections(bwn23);
        bwn23.addConnections(bwn22);
        bwn23.addConnections(bwn24);
        bwn24.addConnections(bwn23);
        bwn24.addConnections(bwn25);
        bwn25.addConnections(bwn24);
        bwn25.addConnections(bwn26);
        bwn26.addConnections(bwn25);
        bwn26.addConnections(bwn27);
        bwn27.addConnections(bwn26);
        bwn27.addConnections(bwn28);
        bwn28.addConnections(bwn27);
        bwn28.addConnections(bwn29);
        bwn29.addConnections(bwn28);
        bwn29.addConnections(bwn30);
        bwn30.addConnections(bwn29);
        bwn30.addConnections(bwn31);
        bwn31.addConnections(bwn30);
        bwn31.addConnections(bwn32);
        bwn32.addConnections(bwn31);
        bwn32.addConnections(bwn33);
        bwn33.addConnections(bwn32);
        bwn33.addConnections(bwn34);
        bwn34.addConnections(bwn33);
        bwn34.addConnections(bwn35);
        bwn35.addConnections(bwn34);
        bwn35.addConnections(bwn36);
        bwn36.addConnections(bwn35);
        bwn36.addConnections(bwn37);
        bwn37.addConnections(bwn36);
        bwn37.addConnections(bwn38);
        bwn38.addConnections(bwn37);
        bwn38.addConnections(bwn39);
        bwn39.addConnections(bwn38);
        bwn39.addConnections(bwn40);
        bwn40.addConnections(bwn39);
        bwn40.addConnections(bwn41);
        bwn41.addConnections(bwn40);

        WebFinder webFinder = getWalking().getWebPathFinder();
        AbstractWebNode[] webNodes = { bwn1, bwn2, bwn3, bwn4, bwn5, bwn6, bwn7, bwn8, bwn9, bwn10, bwn11, bwn12, bwn13, bwn14, bwn15, bwn16, bwn17, bwn18, bwn19, bwn20,
                bwn21, bwn22, bwn23, bwn24, bwn25, bwn26, bwn27, bwn28, bwn29, bwn30, bwn31, bwn32, bwn33, bwn34, bwn35, bwn36, bwn37, bwn38, bwn39, bwn40, bwn41 };
        for (AbstractWebNode webNode : webNodes) {
            webFinder.addWebNode(webNode);
        }
    }

    public void onPaint(Graphics2D g) {
        g.drawString("Status: " + API.status, 10, 30);
        g.drawString("RunTime: " + Timer.formatTime(this.timer.elapsed()), 10, 45);
    }
}
