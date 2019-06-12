package com.elias.boats.tile;

import com.elias.boats.Assets;

public class WaterCTR extends Tile {

    public WaterCTR(int id) {
        super(Assets.waterCTR, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }

}