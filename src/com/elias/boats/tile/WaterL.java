package com.elias.boats.tile;

import com.elias.boats.Assets;

public class WaterL extends Tile{

    public WaterL(int id) {
        super(Assets.waterL, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
