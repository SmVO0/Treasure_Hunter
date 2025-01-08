package Main;

import Entity.Player;
import Tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
//    final int originalTileSize = 16;
//    final int scale = 3;
      public final int tileSize = 48;
//    final int maxScreenCol = 16;
//    final int maxScreenRow = 12;
    final int screenWidth = 768;
    final int screenHeight = 576;
    final int FPS = 60;
    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();
    Player player;
    TileManager tileManager = new TileManager(this);

    public GamePanel() {
        this.player = new Player(this, this.keyHandler);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void StartThread() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        long timer = 0;
        int drawCount = 0;
        while(this.gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        this.player.update();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);

        tileManager.draw(g2d); // draw Tile before player!!
        player.draw(g2d);

        g2d.dispose();
    }
}
