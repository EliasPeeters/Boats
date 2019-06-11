package com.elias.boats.worlds;

import com.elias.boats.Assets;
import com.elias.boats.Game;
import com.elias.boats.Handler;
import com.elias.boats.ImageLoader;
import com.elias.boats.Utils.Utils;
import com.elias.boats.entities.EntityManager;
import com.elias.boats.entities.creatures.Player;
import com.elias.boats.entities.statics.Harbour;
import com.elias.boats.graphics.Text;
import com.elias.boats.tile.Tile;

import java.awt.*;

public class World {

    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;
    private Player player;

    private EntityManager entityManager;

    public World(Handler handler, String path) {

        player = new Player(handler, 100, 100);
        entityManager = new EntityManager(handler, player);

        entityManager.addEntity(new Harbour(handler, 100, 100));

        loadWorld(path);
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    private void loadWorld(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.grassTile;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) {
            return Tile.dirtTile;
        }
        return t;
    }

    public void tick() {
        entityManager.tick();
    }

    public void render(Graphics g) {

        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH );
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT );
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), (int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
            }
        }
        entityManager.render(g);
        renderUI(g);

    }

    public void renderUI(Graphics g) {
        int displayCenter = handler.getWidth() / 2;
        g.drawImage(Assets.uiDisplay, displayCenter - 220, handler.getHeight() - 70, 190, 50, null);
        g.drawImage(Assets.uiDisplay, displayCenter + 30, handler.getHeight() - 70, 190, 50, null);
        g.drawImage(Assets.uiDisplaySmall, handler.getWidth() - 55, 10, 45, 50, null);

        //Print Time
        Text.drawString(g, "Time: " , displayCenter - 170, handler.getHeight() - 37, true, Color.black, Assets.font28);
        Text.drawString(g, " " + handler.getWorld().getPlayer().getTimeNeeded() + "s", displayCenter - 100, handler.getHeight() - 37, false, Color.black, Assets.font28);

        //Print Points
        Text.drawString(g, "Points: " , displayCenter + 90, handler.getHeight() - 37, true, Color.black, Assets.font28);
        Text.drawString(g, " " + handler.getWorld().getPlayer().getPoints(), displayCenter + 150, handler.getHeight() - 37, true, Color.black, Assets.font28);

        Text.drawString(g, "" + handler.getGame().getFramesPerSecond() , handler.getWidth() - 32, 43, true, Color.black, Assets.font28);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
