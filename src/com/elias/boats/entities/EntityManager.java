package com.elias.boats.entities;

import com.elias.boats.Handler;
import com.elias.boats.entities.creatures.Player;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {

    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler,Player player) {
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
    }

    public void tick() {
        for (int i = 0; i < entities.size(); i++)
    }

    public void render(Graphics g) {

    }

    public void addEntity(Entity e) {
        entities.add(e);
    }


    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
