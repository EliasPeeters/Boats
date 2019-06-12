package com.elias.boats.entities.creatures;

import com.elias.boats.Animation;
import com.elias.boats.Assets;
import com.elias.boats.Game;
import com.elias.boats.Handler;
import com.elias.boats.State.State;
import com.elias.boats.tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{


    //Animations
    private Animation aniDown,animUp;
    private int points = 0;
    private int timeNeeded = 0;
    private boolean timerRunning = false;

    public Player(Handler handler, float x, float y) {

        super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);

        bounds.x = 16;
        bounds.y = 15;
        bounds.width = 32;
        bounds.height = 45;

        //Animations
        aniDown = new Animation(150, Assets.player_down);
        animUp = new Animation(150, Assets.player_up);
    }



    @Override
    public void tick() {
        if (timerRunning) {
            timeNeeded++;
        }

        //System.out.println(timeNeeded / 60);

        if (
                handler.getWorld().getTile((int) ((x)/64), (int) ((y)/64)) == Tile.dirtTile ||
                        handler.getWorld().getTile((int) (x/64), (int) (y/64)) == Tile.dirtBLTile ||
                        handler.getWorld().getTile((int) (x/64), (int) (y/64)) == Tile.dirtBRTile ||
                        handler.getWorld().getTile((int) (x/64), (int) (y/64)) == Tile.dirtBTile ||
                        handler.getWorld().getTile((int) (x/64), (int) (y/64)) == Tile.dirtCBLTile ||
                        handler.getWorld().getTile((int) (x/64), (int) (y/64)) == Tile.dirtCBRTile ||
                        handler.getWorld().getTile((int) (x/64), (int) (y/64)) == Tile.dirtCTLTile ||
                        handler.getWorld().getTile((int) (x/64), (int) (y/64)) == Tile.dirtCTRTile ||
                        handler.getWorld().getTile((int) (x/64), (int) (y/64)) == Tile.dirtLTile ||
                        handler.getWorld().getTile((int) (x/64), (int) (y/64)) == Tile.dirtRTile ||
                        handler.getWorld().getTile((int) (x/64), (int) (y/64)) == Tile.dirtTLTile ||
                        handler.getWorld().getTile((int) (x/64), (int) (y/64)) == Tile.dirtTRTile ||
                        handler.getWorld().getTile((int) (x/64), (int) (y/64)) == Tile.dirtTTile

        ) {
            speed = 5;
        } else {
            speed = 1;
        }


        //Animations
        aniDown.tick();
        animUp.tick();

        //Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
        //System.out.println(points);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up)
            yMove = -speed;
        if (handler.getKeyManager().down)
            yMove = speed;
        if (handler.getKeyManager().left)
            xMove = -speed;
        if (handler.getKeyManager().right)
            xMove = speed;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        g.setColor(Color.blue);
        //g.fillRect( (int) (x + bounds.x - handler.getGameCamera().getxOffset()),(int) (y + bounds.y - handler.getGameCamera().getyOffset()),bounds.width, bounds.height);
    }

    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
            return animUp.getCurrentFrame();
        } else if (xMove > 0) {
            return aniDown.getCurrentFrame();
        } else if  (yMove < 0) {
            //return aniUpgetCurrentFrame();
        } else if (yMove > 0) {

        }
        return Assets.playerStanding;
    }

    public int getPoints() {
        return points;
    }

    public void setXPos(int x) {
        setX(x);
    }

    public void setYPos(int y) {
        setY(y);
    }

    public int getTimeNeeded() {
        return timeNeeded / 60;
    }

    public void setTimerRunning(boolean timerRunning) {
        this.timerRunning = timerRunning;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setTimeNeeded(int timeNeeded) {
        this.timeNeeded = timeNeeded;
    }

    public void incrementPoints() {
        points++;
        if (points >= 5) {
            timerRunning = false;
            State.setState(handler.getGame().getEndState());
        }
    }
}
