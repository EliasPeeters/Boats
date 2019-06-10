package com.elias.boats.entities.creatures;

import com.elias.boats.Assets;
import com.elias.boats.Game;
import com.elias.boats.Handler;

import java.awt.*;

public class Player extends Creature{

    public Player(Handler handler, float x, float y) {

        super(handler, x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);

        bounds.x = 13 ;
        bounds.y = 32;
        bounds.width = 32;
        bounds.height = 28;
    }

    @Override
    public void tick() {
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
        g.drawImage(Assets.playerStanding, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        g.setColor(Color.blue);
        //g.fillRect( (int) (x + bounds.x - handler.getGameCamera().getxOffset()),(int) (y + bounds.y - handler.getGameCamera().getyOffset()),bounds.width, bounds.height);
    }
}
