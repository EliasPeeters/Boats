package com.elias.boats;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 16, height = 16;

    public static BufferedImage grass, stone, water, sand, dirt, playerStanding;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/textures.png"));

        SpriteSheet playersheet = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));

        dirt = sheet.crop(0,0, width, height);
        sand = sheet.crop(width,0, width, height);
        stone = sheet.crop(2* width,0, width, height);
        grass = sheet.crop(3 * width,0, width, height);
        water = sheet.crop(4 * width,0, width, height);

        playerStanding = playersheet.crop(0,0, 233, 283);
    }
}
