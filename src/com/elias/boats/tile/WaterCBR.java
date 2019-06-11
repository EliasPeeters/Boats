package com.elias.boats.tile;

import com.elias.boats.Assets;

public class WaterCBR extends Tile {

    public WaterCBR(int id) {
        super(Assets.waterCBR, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }

}
