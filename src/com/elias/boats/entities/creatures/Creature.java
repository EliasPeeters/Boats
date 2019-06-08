package com.elias.boats.entities.creatures;

import com.elias.boats.entities.Entity;

import java.awt.*;

public abstract class Creature extends Entity {

    protected int health;

    public Creature(float x, float y) {
        super(x, y);
        health = 10;
    }


}
