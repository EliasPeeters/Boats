package com.elias.boats.State;

import com.elias.boats.Assets;
import com.elias.boats.Game;
import com.elias.boats.Handler;

import java.awt.*;

public class MenuState extends State {

    public MenuState(Handler handler) {
        super(handler);

    }

    @Override
    public void render(Graphics g) {
        if (handler.getMouseManager().isLeftPressed() || handler.getMouseManager().isRightPressed()) {
            State.setState(handler.getGame().getGamestate());
        }
    }

    @Override
    public void tick() {
        //System.out.println(handler.getMouseManager().getMouseX() + "  " + handler.getMouseManager().getMouseY());
    }
}
