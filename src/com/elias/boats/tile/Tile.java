package com.elias.boats.tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile = new grassTile(10);
    public static Tile rockTile = new RockTile(11);
    public static Tile waterTLTile = new WaterTL(12);
    public static Tile waterTTile = new WaterT(13);
    public static Tile waterTRTile = new WaterTR(14);
    public static Tile waterLTile = new WaterL(15);
    public static Tile waterTile = new Water(16);
    public static Tile waterRTile = new WaterR(17);
    public static Tile waterBLTile = new WaterBL(18);
    public static Tile waterBTile = new WaterB(19);
    public static Tile waterBRTile = new WaterBR(20);
    public static Tile waterCTLTile = new WaterCTL(21);
    public static Tile waterCTRTile = new WaterCTR(22);
    public static Tile waterCBLTile = new WaterCBL(23);
    public static Tile waterCBRTile = new WaterCBR(24);
    public static Tile dirtTLTile = new DirtTL(25);
    public static Tile dirtTTile = new DirtT(26);
    public static Tile dirtTRTile = new DirtTR(27);
    public static Tile dirtLTile = new DirtL(28);
    public static Tile dirtTile = new DirtTile(29);
    public static Tile dirtRTile = new DirtR(30);
    public static Tile dirtBLTile = new DirtBL(31);
    public static Tile dirtBTile = new DirtB(32);
    public static Tile dirtBRTile = new DirtBR(33);





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

