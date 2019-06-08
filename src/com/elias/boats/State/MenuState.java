package com.elias.boats.State;

import com.elias.boats.Assets;

import java.awt.*;

public class MenuState extends State {

    public MenuState() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.playerStanding, 100, 100, null);

    }

    @Override
    public void tick() {

    }
}
