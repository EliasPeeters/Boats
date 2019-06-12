package com.elias.boats.State;

import com.elias.boats.Game;
import com.elias.boats.Handler;

import java.awt.*;

public abstract class State {

    private static State currentState = null;

    public static void setState(State state) {
        currentState = state;

    }

    public static State getState() {
        return currentState;
    }

    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }

    public State getEndState() {
        return handler.getGame().getEndState();
    }


    public abstract void tick();

    public abstract void render(Graphics g);

}
