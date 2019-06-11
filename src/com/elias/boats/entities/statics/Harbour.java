package com.elias.boats.entities.statics;

import com.elias.boats.Assets;
import com.elias.boats.Handler;
import com.elias.boats.tile.Tile;

import java.awt.*;

public class Harbour extends StaticEntity{

    public Harbour(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.harbour , (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
    }
}
