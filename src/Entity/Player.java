package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Player extends BaseEntity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";

    }

    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/back_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/back_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/front_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/front_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/Sprites/right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/Sprites/right_2.png"));

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

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        int x = this.x;
        int y = this.y;
        g.fillRect(x, y, 48, 48);
    }
}
