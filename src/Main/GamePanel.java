package Main;

import Entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
//    final int originalTileSize = 16;
//    final int scale = 3;
//    public final int tileSize = 48;
//    final int maxScreenCol = 16;
//    final int maxScreenRow = 12;
//    final int screenWidth = 768;
//    final int screenHeight = 576;
//    final int FPS = 60;
    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();
    Player player;

    public GamePanel() {
        this.player = new Player(this, this.keyHandler);
        this.setPreferredSize(new Dimension(768, 576));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(this.keyHandler);
        this.setFocusable(true);
    }

    public void StartThread() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }
 // TODO - FIX THE FPS
    @Override
    public void run() {
        double drawInterval = 1.6666666666666666E7;
        double delta = 0.0;
        long lastTime = System.nanoTime();
        long timer = 0L;
        int drawCount = 0;

        while(this.gameThread != null){
            long currentTime = System.nanoTime();
            delta += (double)(currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            if (delta >= 1) {
                this.Update();
                this.repaint();
                --delta;
                ++drawCount;
            }

            if(timer > 1000000000L){
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0L;
            }
        }
    }

    public void Update() {
        this.player.update();
    }
    //TODO - Player not showing
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.dispose();
    }
}
