package com.elias.boats.entities.creatures;

import com.elias.boats.Assets;

import java.awt.*;

public class Player extends Creature{

    public Player(float x, float y) {
        super(x, y);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.playerStanding, (int) x, (int) y, null);
    }
}
