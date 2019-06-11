package com.elias.boats.tile;

import com.elias.boats.Assets;

public class WaterCBL extends Tile {

    public WaterCBL(int id) {
        super(Assets.waterCBL, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }

}