package com.elias.boats.State;

import com.elias.boats.Assets;
import com.elias.boats.ClickListener;
import com.elias.boats.Game;
import com.elias.boats.Handler;
import com.elias.boats.ui.UIImageButton;
import com.elias.boats.ui.UIManager;

import java.awt.*;

public class EndState extends State {
    private UIManager uiManager;

    public EndState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
    }

    @Override
    public void render(Graphics g) {
        System.out.println("test");
    }

    @Override
    public void tick() {
        uiManager.tick();
        //System.out.println(handler.getMouseManager().getMouseX() + "  " + handler.getMouseManager().getMouseY());
    }
}
