package com.elias.boats.tile;

import com.elias.boats.Assets;

public class WaterT extends Tile{

    public WaterT(int id) {
        super(Assets.waterT, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
