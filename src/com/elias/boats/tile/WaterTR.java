package com.elias.boats.tile;

import com.elias.boats.Assets;

public class WaterTR extends Tile{

    public WaterTR(int id) {
        super(Assets.waterTR, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}

