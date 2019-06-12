package com.elias.boats.State;

import com.elias.boats.Assets;
import com.elias.boats.ClickListener;
import com.elias.boats.Game;
import com.elias.boats.Handler;
import com.elias.boats.ui.UIImageButton;
import com.elias.boats.ui.UIManager;

import java.awt.*;

public class MenuState extends State {

    private UIManager uiManager;
    private UIImageButton button;

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(70, 350, 350, 90, Assets.button, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setState(handler.getGame().getGamestate());
                handler.getWorld().getPlayer().setTimerRunning(true);
            }
        }));
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.menuBackground, 0, 0, handler.getWidth(), handler.getHeight(), null);
        uiManager.render(g);
    }

    @Override
    public void tick() {
        uiManager.tick();
        if (handler.getMouseManager().isRightPressed() || handler.getMouseManager().isLeftPressed()) {
            State.setState(handler.getGame().getGamestate());
            handler.getMouseManager().setUiManager(null);
            handler.getWorld().getPlayer().setTimerRunning(true);
        }
        //System.out.println(handler.getMouseManager().getMouseX() + "  " + handler.getMouseManager().getMouseY());
    }
}
