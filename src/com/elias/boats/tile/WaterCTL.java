package com.elias.boats.tile;

import com.elias.boats.Assets;

public class WaterCTL extends Tile{

    public WaterCTL(int id) {
        super(Assets.waterCTL, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
