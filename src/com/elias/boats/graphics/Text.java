package com.elias.boats.graphics;

import java.awt.*;

public class Text {

    public static void drawString(Graphics g, String text, int xPos, int yPos, boolean center, Color c, Font font) {
        g.setColor(c);
        g.setFont(font);
        int x = xPos;
        int y = yPos;

        if (center) {
            FontMetrics fm = g.getFontMetrics(font);
            x = xPos - fm.stringWidth(text) / 2;
            //y = (xPos - fm.getHeight() / 2) + fm.getAscent();
        }

        g.drawString(text, x, y);
    }

}
