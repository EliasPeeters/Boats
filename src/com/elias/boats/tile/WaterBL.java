package com.elias.boats.tile;

import com.elias.boats.Assets;

public class WaterBL extends Tile{

    public WaterBL(int id) {
        super(Assets.waterBL, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
