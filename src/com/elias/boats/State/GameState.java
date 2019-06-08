package com.elias.boats.State;


import com.elias.boats.Assets;

import java.awt.*;

public class GameState extends State{

    public GameState() {

    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.drawImage(Assets.playerStanding, 0, 0, null);
    }
}
