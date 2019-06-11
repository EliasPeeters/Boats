package com.elias.boats;

import com.elias.boats.State.GameState;
import com.elias.boats.State.MenuState;
import com.elias.boats.State.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private Display display;

    private boolean running = false;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;

    private int width, height;
    public String title;
    public int fps = 60;

    private Handler handler;

    //States
    private State gamestate;
    private State menuState;

    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    //Camera
    private GameCamera gameCamera;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();

    }

    public void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        Assets.init();

        handler = new Handler(this);
        gameCamera = new GameCamera(handler,0,0);

        gamestate = new GameState(handler);
        menuState = new MenuState(handler);
        State.setState(menuState);
    }

    public void tick() {
        keyManager.tick();

        if (State.getState() != null) {
            State.getState().tick();
        }
    }

    public void run() {
        init();

        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;


        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now-lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                delta--;
                ticks++;
            }

            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }

    public void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        //clear Screen
        g.clearRect(0,0, width, height);

        //call the render function of the active state

        if (State.getState() != null) {
            State.getState().render(g);
        }

        //final
        bs.show();
        g.dispose();


    }



    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public State getGamestate() {
        return gamestate;
    }

    public State getMenuState() {
        return menuState;
    }

    public GameCamera getGameCamera() {
        return gameCamera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running)
            return;
        running = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
