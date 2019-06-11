package com.elias.boats;

import javax.swing.*;
import java.awt.*;

public class Display {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, heigth;

    public Display(String title, int width, int heigth) {
        this.title = title;
        this.width = width;
        this.heigth = heigth;

        createDisplay();
    }

    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, heigth);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, heigth));
        canvas.setMaximumSize(new Dimension(width, heigth));
        canvas.setMinimumSize(new Dimension(width, heigth));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();

        frame.getRootPane().setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                ImageLoader.loadImage("/textures/cursor.png"),
                new Point(0,0),"custom cursor"));
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }

}
