package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends BaseEntity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        this.setDefaultValues();
        this.getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";

    }

    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/back_1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/back_2.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/front_1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/front_2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/left_1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/left_2.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/right_1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/right_2.png"));

        } catch (IOException e){ e.printStackTrace(); }
    }

    public void update() {
        if(this.keyH.upPressed){
            direction = "up";
            this.y -= this.speed;
        }

        if(this.keyH.downPressed){
            direction = "down";
            this.y += this.speed;
        }

        if(this.keyH.leftPressed){
            direction = "left";
            this.x -= this.speed;
        }

        if(this.keyH.rightPressed){
            direction = "right";
            this.x += this.speed;
        }
    }

    public void draw(Graphics2D g2) {
        /*g.setColor(Color.WHITE);
        int x = this.x;
        int y = this.y;
        g.fillRect(x, y, 48, 48);*/

        BufferedImage img = null;

        switch(direction){
            case "up":
                img = up1;
                break;
            case "down":
                img = down1;
                break;
            case "left":
                img = left1;
                break;
            case "right":
                img = right1;
                break;
        }
        g2.drawImage(img, x, y, gp.tileSize, gp.tileSize, null);
    }
}
