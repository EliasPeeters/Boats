package com.elias.boats.tile;

import com.elias.boats.Assets;

public class RockTile extends Tile {

    public RockTile(int id) {
        super(Assets.stone, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
