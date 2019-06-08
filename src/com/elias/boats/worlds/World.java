package com.elias.boats.worlds;

import com.elias.boats.tile.Tile;

import java.awt.*;

public class World {

    private int width, height;
    private int[][] tiles;

    public World(String path) {
        loadWorld(path);
    }

    private void loadWorld(String path) {
        width = 20;
        height = 5;
        tiles = new int[width][height];



    }

    public Tile getTile(int x, int y) {
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) {
            return Tile.dirtTile;
        }
        return t;
    }

    public void tick() {

    }

    public void render(Graphics g) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTile(x, y).render(g, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
            }
        }

    }

}
