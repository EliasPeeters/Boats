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

    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(200, 200, 190, 49, Assets.button, new ClickListener() {
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
        uiManager.render(g);
    }

    @Override
    public void tick() {
        uiManager.tick();
        //System.out.println(handler.getMouseManager().getMouseX() + "  " + handler.getMouseManager().getMouseY());
    }
}
