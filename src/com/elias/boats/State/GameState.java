package com.elias.boats.State;


import com.elias.boats.Assets;
import com.elias.boats.Game;
import com.elias.boats.Handler;
import com.elias.boats.entities.creatures.Player;
import com.elias.boats.entities.statics.Harbour;
import com.elias.boats.tile.Tile;
import com.elias.boats.worlds.World;

import java.awt.*;

public class GameState extends State{


    private World world;


    public GameState(Handler handler) {
        super(handler);
        world =  new World(handler, "/worlds/world1.world");
        handler.setWorld(world);

    }

    public void tick() {
        world.tick();


    }

    public void render(Graphics g) {
        world.render(g);
        //g.drawImage(Assets.sand, 0, 0, 64, 64, null);



    }
}
