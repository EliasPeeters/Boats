package com.elias.boats;

import javax.swing.*;
import java.awt.*;

public class Launcher {
    public static void main(String[] args) {
        Game game = new Game("Rush Hour", 1000, 600);
        game.start();
    }
}
