package com.elias.boats;

import com.elias.boats.graphics.FontLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URISyntaxException;

public class Assets {
    private static final int width = 16, height = 16;
    private static final int width_world_textures = 64, height_world_textures = 64;
    private static final int width_player = 64, height_player = 64;

    public static BufferedImage sand, playerStanding, uiDisplay, uiDisplaySmall, menuBackground, endScreen;
    public static BufferedImage[] player_down;
    public static BufferedImage[] player_up;

    public static Font font28;

    public static BufferedImage[] button, restartButton;

    public static BufferedImage stone, dirt, grass, waterTL, waterTR, waterBL, waterBR, water, waterR, waterL, harbour, waterT, waterB, waterCTL, waterCTR, waterCBL, waterCBR, dirtTL, dirtTR, dirtBL, dirtBR, dirtR, dirtL, dirtT, dirtB;


    public static void init() {

        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/textures.png"));
        SpriteSheet ui = new SpriteSheet(ImageLoader.loadImage("/textures/UI.png"));

        SpriteSheet playersheet = new SpriteSheet(ImageLoader.loadImage("/textures/player_sheet.png"));
        SpriteSheet world_textures = new SpriteSheet(ImageLoader.loadImage("/textures/world_textures.png"));

        font28 = FontLoader.loadFont("/fonts/AXTON.otf", 28);

        sand = sheet.crop(width,0, width, height);

        stone = world_textures.crop(1 * width_world_textures, 3 * height_world_textures, width_world_textures, height_world_textures);
        grass = world_textures.crop(0,0, width_world_textures, height_world_textures);
        waterTL = world_textures.crop(width_world_textures,0, width_world_textures, height_world_textures);
        waterT = world_textures.crop(2 * width_world_textures,0, width_world_textures, height_world_textures);
        waterTR = world_textures.crop(3 * width_world_textures, 0, width_world_textures, height_world_textures);

        harbour = world_textures.crop(2 * width_world_textures, 3 * height_world_textures, width_world_textures, height_world_textures);

        waterL = world_textures.crop(width_world_textures, height_world_textures, width_world_textures, height_world_textures);
        water = world_textures.crop(2 * width_world_textures, height_world_textures, width_world_textures, height_world_textures);
        waterR = world_textures.crop(3 * width_world_textures, height_world_textures, width_world_textures, height_world_textures);
        waterBL = world_textures.crop( width_world_textures, 2*height_world_textures, width_world_textures, height_world_textures);
        waterB = world_textures.crop(2 * width_world_textures, 2 * height_world_textures, width_world_textures, height_world_textures);
        waterBR = world_textures.crop(3 * width_world_textures, 2 * height_world_textures, width_world_textures, height_world_textures);
        dirtTL = world_textures.crop(4 * width_world_textures, 0, width_world_textures, height_world_textures);
        dirtT = world_textures.crop(5 * width_world_textures, 0, width_world_textures, height_world_textures);
        dirtTR = world_textures.crop(6 * width_world_textures, 0, width_world_textures, height_world_textures);
        dirtL = world_textures.crop(4 * width_world_textures,height_world_textures, width_world_textures, height_world_textures);
        dirt = world_textures.crop(5 * width_world_textures,height_world_textures, width_world_textures, height_world_textures);
        dirtR = world_textures.crop(6 * width_world_textures,height_world_textures, width_world_textures, height_world_textures);
        dirtBL = world_textures.crop(4 * width_world_textures,2 * height_world_textures, width_world_textures, height_world_textures);
        dirtB = world_textures.crop(5 * width_world_textures,2 * height_world_textures, width_world_textures, height_world_textures);
        dirtBR = world_textures.crop(6 * width_world_textures,2 * height_world_textures, width_world_textures, height_world_textures);
        waterCTL = world_textures.crop(7 * width_world_textures,0, width_world_textures, height_world_textures);
        waterCTR = world_textures.crop(8 * width_world_textures,0, width_world_textures, height_world_textures);
        waterCBL = world_textures.crop(7 * width_world_textures,height_world_textures, width_world_textures, height_world_textures);
        waterCBR = world_textures.crop(8 * width_world_textures,height_world_textures, width_world_textures, height_world_textures);

        player_down = new BufferedImage[2];

        player_down[0] = playersheet.crop(0,0, width_player, height_player);
        player_down[1] = playersheet.crop(width_player,0, width_player, height_player);
        playerStanding = playersheet.crop(4 * width_player,0, width_player, height_player);

        player_up = new BufferedImage[2];

        player_up[0] = playersheet.crop(2 * width_player,0, width_player, height_player);
        player_up[1] = playersheet.crop(3 * width_player,0, width_player, height_player);

        button = new BufferedImage[3];
        button[2] = ui.crop(0,0, 190, 49);
        button[1] = ui.crop(190,0, 190, 49);
        button[0] = ui.crop(380,0, 190, 49);

        restartButton = new BufferedImage[3];
        restartButton[2] = ui.crop(0,98, 190, 49);
        restartButton[0] = ui.crop(380,98, 190, 49);

        uiDisplay = ui.crop(0,49, 190, 49);
        uiDisplaySmall = ui.crop(190, 49, 45, 49);

        menuBackground = ImageLoader.loadImage("/textures/menu.png");
        endScreen = ImageLoader.loadImage("/textures/end.png");
    }
}
