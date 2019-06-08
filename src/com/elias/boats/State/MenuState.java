package com.elias.boats.State;

import com.elias.boats.Assets;
import com.elias.boats.Game;

import java.awt.*;

public class MenuState extends State {

    public MenuState(Game game) {
        super(game);

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.playerStanding, 100, 100, null);

    }

    @Override
    public void tick() {

    }
}
