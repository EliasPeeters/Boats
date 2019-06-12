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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.stream.Collectors;

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

        //entityManager.addEntity(new Harbour(handler, 200, 200));
        //entityManager.addEntity(new Harbour(handler, 100, 100));

        loadWorld(path);
        generateEntities(10, handler);
        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
        this.handler = handler;
    }

    public void generateEntities(int amount, Handler handler) {
        Random rand = new Random();
        int number = 0;
        for (int i = 0; i < amount; i++) {
            int xPos = rand.nextInt(40*64) + 20;
            int yPos = rand.nextInt(40*64) + 20;


            if (!canBeSetHere(xPos / 64, yPos / 64)) {
                amount++;
                //System.out.println("Ging nicht");
            } else {
                entityManager.addEntity(new Harbour(handler, xPos, yPos));
                number++;
            }

        }
        //System.out.println(number);
    }


    public Player getPlayer() {
        return player;
    }

    private void loadWorld(String path) {
        String file = (new BufferedReader(new InputStreamReader(World.class.getResourceAsStream(path)))).lines().collect(Collectors.joining("\n"));
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

    public boolean canBeSetHere(int x, int y) {
        if (
                Tile.tiles[tiles[x][y]] == Tile.rockTile ||
                        Tile.tiles[tiles[x][y]] == Tile.waterTLTile ||
                        Tile.tiles[tiles[x][y]] == Tile.waterTTile ||
                        Tile.tiles[tiles[x][y]] == Tile.waterTRTile ||
                        Tile.tiles[tiles[x][y]] == Tile.waterLTile ||
                        Tile.tiles[tiles[x][y]] == Tile.waterTile ||
                        Tile.tiles[tiles[x][y]] == Tile.waterRTile ||
                        Tile.tiles[tiles[x][y]] == Tile.waterBLTile ||
                        Tile.tiles[tiles[x][y]] == Tile.waterBTile ||
                        Tile.tiles[tiles[x][y]] == Tile.waterBRTile ||
                        Tile.tiles[tiles[x][y]] == Tile.waterCTLTile ||
                        Tile.tiles[tiles[x][y]] == Tile.waterCTRTile ||
                        Tile.tiles[tiles[x][y]] == Tile.waterCBRTile ||
                        Tile.tiles[tiles[x][y]] == Tile.waterCBLTile

        ) {
            return true;
        } else {
            return false;
        }
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
        renderEntities(g);
        entityManager.render(g);
        renderUI(g);

    }

    public void renderEntities(Graphics g) {
        //HauseHoch
        g.drawImage(Assets.hauseBig,  + cordsToPixelX(35), cordsToPixelY(29), null);
        g.drawImage(Assets.hauseBig,  + cordsToPixelX(5), cordsToPixelY(16), null);
        g.drawImage(Assets.hauseBig,  + cordsToPixelX(30), cordsToPixelY(15), null);

        //HausBreit
        g.drawImage(Assets.hauseGrey,  + cordsToPixelX(38), cordsToPixelY(2), null);
        g.drawImage(Assets.hauseGrey,  + cordsToPixelX(28), cordsToPixelY(29), null);
        g.drawImage(Assets.hauseGrey,  + cordsToPixelX(29), cordsToPixelY(39), null);
        g.drawImage(Assets.hauseGrey,  + cordsToPixelX(41), cordsToPixelY(9), null);

        //Bäume
        g.drawImage(Assets.treeGreen, + cordsToPixelX(10), cordsToPixelY(3), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(12), cordsToPixelY(3), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(14), cordsToPixelY(3), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(16), cordsToPixelY(3), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(18), cordsToPixelY(3), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(20), cordsToPixelY(3), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(22), cordsToPixelY(3), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(24), cordsToPixelY(3), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(26), cordsToPixelY(3), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(28), cordsToPixelY(3), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(30), cordsToPixelY(3), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(32), cordsToPixelY(3), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(34), cordsToPixelY(3), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(26), cordsToPixelY(7), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(28), cordsToPixelY(7), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(30), cordsToPixelY(7), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(32), cordsToPixelY(7), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(34), cordsToPixelY(7), null);

        g.drawImage(Assets.treeGreen, + cordsToPixelX(28), cordsToPixelY(35), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(33), cordsToPixelY(35), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(26), cordsToPixelY(32), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(31), cordsToPixelY(24), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(32), cordsToPixelY(23), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(33), cordsToPixelY(24), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(33), cordsToPixelY(22), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(34), cordsToPixelY(23), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(34), cordsToPixelY(25), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(26), cordsToPixelY(39), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(10), cordsToPixelY(32), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(7), cordsToPixelY(34), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(8), cordsToPixelY(31), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(9), cordsToPixelY(33), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(6), cordsToPixelY(31), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(3), cordsToPixelY(31), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(3), cordsToPixelY(36), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(6), cordsToPixelY(36), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(3), cordsToPixelY(40), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(6), cordsToPixelY(40), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(17), cordsToPixelY(31), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(18), cordsToPixelY(30), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(19), cordsToPixelY(29), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(20), cordsToPixelY(30), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(1), cordsToPixelY(2), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(2), cordsToPixelY(7), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(3), cordsToPixelY(6), null);
        g.drawImage(Assets.treeGreen, + cordsToPixelX(6), cordsToPixelY(2), null);

        g.drawImage(Assets.treeGreen, + cordsToPixelX(22), cordsToPixelY(45), null);
    }

    public int cordsToPixelX(int cord) {
        return (int) (cord*64 - handler.getGameCamera().getxOffset());
    }

    public int cordsToPixelY(int cord) {
        return (int) (cord*64 - handler.getGameCamera().getyOffset());
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
        Text.drawString(g, " " + handler.getWorld().getPlayer().getPoints() + "/5", displayCenter + 150, handler.getHeight() - 37, true, Color.black, Assets.font28);

        Text.drawString(g, "" + handler.getGame().getFramesPerSecond() , handler.getWidth() - 32, 43, true, Color.black, Assets.font28);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
