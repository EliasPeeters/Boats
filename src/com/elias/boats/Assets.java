package com.elias.boats;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 16, height = 16;
    private static final int width_world_textures = 64, height_world_textures = 64;
    private static final int width_player = 64, height_player = 64;

    public static BufferedImage sand, playerStanding;
    public static BufferedImage[] player_down;

    public static BufferedImage stone, dirt, grass, waterTL, waterTR, waterBL, waterBR, water, waterR, waterL, waterT, waterB;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/textures.png"));

        SpriteSheet playersheet = new SpriteSheet(ImageLoader.loadImage("/textures/player_sheet.png"));
        SpriteSheet world_textures = new SpriteSheet(ImageLoader.loadImage("/textures/world_textures.png"));


        sand = sheet.crop(width,0, width, height);

        stone = world_textures.crop(1 * width_world_textures, 3 * height_world_textures, width_world_textures, height_world_textures);
        dirt = world_textures.crop(5 * width_world_textures,height_world_textures, width_world_textures, height_world_textures);
        grass = world_textures.crop(0,0, width_world_textures, height_world_textures);
        waterTL = world_textures.crop(width_world_textures,0, width_world_textures, height_world_textures);
        waterT = world_textures.crop(2 * width_world_textures,0, width_world_textures, height_world_textures);
        water = world_textures.crop(2 * width_world_textures, height_world_textures, width_world_textures, height_world_textures);

        player_down = new BufferedImage[2];

        player_down[0] = playersheet.crop(0,0, width_player, height_player);
        player_down[0] = playersheet.crop(width_player,0, width_player, height_player);
        playerStanding = playersheet.crop(2 * width_player,0, width_player, height_player);
    }
}
