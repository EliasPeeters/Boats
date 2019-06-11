package com.elias.boats.tile;

import com.elias.boats.Assets;

public class Water extends Tile{

    public Water(int id) {
        super(Assets.water, id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
