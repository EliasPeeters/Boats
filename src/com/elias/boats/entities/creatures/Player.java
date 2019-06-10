package com.elias.boats.entities.creatures;

import com.elias.boats.Animation;
import com.elias.boats.Assets;
import com.elias.boats.Game;
import com.elias.boats.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature{


    //Animations
    private Animation aniDown, animLeft, animRight,animUp;

    public Player(Handler handler, float x, float y) {

        super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);

        bounds.x = 16;
        bounds.y = 15;
        bounds.width = 32;
        bounds.height = 45;

        //Animations
        aniDown = new Animation(150, Assets.player_down);
        animUp = new Animation(150, Assets.player_down);
        animLeft = new Animation(150, Assets.player_down);
        animRight = new Animation(150, Assets.player_down);
    }

    @Override
    public void tick() {
        //Animations
        aniDown.tick();

        //Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
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
            return aniDown.getCurrentFrame();
        } else if (xMove > 0) {

        } else if  (yMove < 0) {

        } else if (yMove > 0) {

        }
        return aniDown.getCurrentFrame();
    }


}
