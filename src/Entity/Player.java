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
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/back_1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/back_2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/front_1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/front_2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/left_1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/left_2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/right_1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/right_2.png")));

        } catch (IOException e){ e.printStackTrace(); }
    }

    public void update() {

        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed
        || keyH.rightPressed){
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
            spriteCounter++;

            if(spriteCounter > 10){
                if (spriteNumber == 1){
                    spriteNumber = 2;
                } else if (spriteNumber == 2){
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
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
                if (spriteNumber == 1){
                    img = up1;
                } else if (spriteNumber == 2){
                    img = up2;
                }

                break;
            case "down":
                if (spriteNumber == 1){
                    img = down1;
                } else if (spriteNumber == 2){
                    img = down2;
                }
                break;
            case "left":
                if (spriteNumber == 1){
                    img = left1;
                } else if (spriteNumber == 2){
                    img = left2;
                }
                break;
            case "right":
                if (spriteNumber == 1) {
                    img = right1;
                } else if (spriteNumber == 2) {
                    img = right2;
                }
                break;
        }
        g2.drawImage(img, x, y, gp.tileSize, gp.tileSize, null);
    }
}
