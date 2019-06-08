package com.elias.boats;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 233, height = 283;

    public static BufferedImage playerStanding;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/player.png"));

        playerStanding = sheet.crop(0,0, width, height);

    }
}
