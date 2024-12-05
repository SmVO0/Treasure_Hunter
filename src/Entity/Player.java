package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import java.awt.*;

public class Player extends BaseEntity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        this.setDefaultValues();
    }

    public void setDefaultValues() {
        this.x = 100;
        this.y = 100;
        this.speed = 4;
    }

    public void update() {
        if(this.keyH.upPressed){
            this.y -= this.speed;
        }

        if(this.keyH.downPressed){
            this.y += this.speed;
        }

        if(this.keyH.leftPressed){
            this.x -= this.speed;
        }

        if(this.keyH.rightPressed){
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
