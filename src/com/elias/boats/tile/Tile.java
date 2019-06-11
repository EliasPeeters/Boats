package com.elias.boats.tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new grassTile(0);
    public static Tile rockTile = new RockTile(1);
    public static Tile waterTLTile = new WaterTL(2);
    public static Tile waterTTile = new WaterT(3);
    public static Tile waterTRTile = new WaterTR(4);
    public static Tile waterLTile = new WaterL(5);
    public static Tile waterTile = new Water(6);
    public static Tile waterRTile = new WaterR(7);
    public static Tile waterBLTile = new WaterBL(8);
    public static Tile waterBTile = new WaterB(9);
    public static Tile waterBRTile = new WaterBR(10);
    public static Tile waterCTLTile = new WaterCTL(11);
    public static Tile waterCTRTile = new WaterCTR(12);
    public static Tile waterCBLTile = new WaterCBL(13);
    public static Tile waterCBRTile = new WaterCBR(14);
    public static Tile dirtTLTile = new DirtTL(15);
    public static Tile dirtTTile = new DirtT(16);
    public static Tile dirtTRTile = new DirtTR(17);
    public static Tile dirtLTile = new DirtL(18);
    public static Tile dirtTile = new DirtTile(19);
    public static Tile dirtRTile = new DirtR(20);
    public static Tile dirtBLTile = new DirtBL(21);
    public static Tile dirtBTile = new DirtB(22);
    public static Tile dirtBRTile = new DirtBR(23);





    public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public boolean isSolid() {
        return false;
    }

    public int getId() {
        return id;
    }


}

