package com.elias.boats.tile;

import com.elias.boats.Assets;

public class WaterB extends Tile{

    public WaterB(int id) {
        super(Assets.waterB, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
