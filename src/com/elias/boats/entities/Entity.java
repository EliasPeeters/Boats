package com.elias.boats.entities;

import com.elias.boats.Game;
import com.elias.boats.Handler;

import java.awt.*;
import java.util.Collections;

public abstract class Entity {

    protected float x, y;
    protected int width, height;
    protected Handler handler;
    protected Rectangle bounds;


    public Entity(Handler handler, float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.handler = handler;
        bounds = new Rectangle(0, 0, width, height);
    }

    public boolean checkEntityCollections (float xOffset, float yOffset) {
        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this)) {
                continue;
            }
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))) {
                handler.getWorld().getPlayer().incrementPoints();
                handler.getWorld().getEntityManager().removeEntity(e);
                System.out.println(handler.getWorld().getPlayer().getPoints());
                return true;
            }
        }
        return false;
    }


    public Rectangle getCollisionBounds(float xOffset, float yOffset) {
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}
