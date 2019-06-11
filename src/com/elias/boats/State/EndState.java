package com.elias.boats.State;

import com.elias.boats.Assets;
import com.elias.boats.ClickListener;
import com.elias.boats.Game;
import com.elias.boats.Handler;
import com.elias.boats.graphics.Text;
import com.elias.boats.ui.UIImageButton;
import com.elias.boats.ui.UIManager;

import java.awt.*;

public class EndState extends State {
    private UIManager uiManager1;

    public EndState(Handler handler) {
        super(handler);
        uiManager1 = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager1);

        uiManager1.addObject(new UIImageButton(190, 420, 285, 70, Assets.restartButton, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().getMenuState());
                //handler.getWorld().getPlayer().setTimerRunning(true);
            }
        }));
    }

    @Override
    public void render(Graphics g) {
        //System.out.println("test");
        g.drawImage(Assets.endScreen, 0, 0, handler.getWidth(), handler.getHeight(), null);
        Text.drawString(g, "Time: " + handler.getWorld().getPlayer().getTimeNeeded() , 210, 300, false, Color.black, Assets.font28);
        Text.drawString(g, "Points: " + handler.getWorld().getPlayer().getPoints() , 210, 385, false, Color.black, Assets.font28);
        uiManager1.render(g);
    }

    @Override
    public void tick() {
        uiManager1.tick();
        if (handler.getMouseManager().isRightPressed() || handler.getMouseManager().isLeftPressed()) {
            handler.getWorld().getPlayer().setPoints(0);
            handler.getWorld().getPlayer().setTimeNeeded(0);
            State.setState(handler.getGame().getMenuState());

        }
        //System.out.println(handler.getMouseManager().getMouseX() + "  " + handler.getMouseManager().getMouseY());
    }
}
