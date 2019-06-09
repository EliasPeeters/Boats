package com.elias.boats.entities.creatures;

import com.elias.boats.Game;
import com.elias.boats.Handler;
import com.elias.boats.entities.Entity;
import com.elias.boats.tile.Tile;

import java.awt.*;

public abstract class Creature extends Entity {

    protected int health;
    protected float speed;
    protected float xMove, yMove;

    public static final int DEFAULT_HEALTH = 10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH = 64,
                            DEFAULT_CREATURE_HEIGHT = 64;

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move() {
        moveY();
        moveX();
    }


    public void moveX() {
        if (xMove > 0) {
            //Moving right

            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;
            if (    !collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                x += xMove;
            }

        } else if (xMove < 0) {
            //Moving left
            x += xMove;

        }
    }

    public void moveY() {
        y += yMove;
    }

    protected boolean collisionWithTile(int x, int y) {
        return handler.getWorld().getTile(x, y).isSolid();
    }

    //Getter and Setter
    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
