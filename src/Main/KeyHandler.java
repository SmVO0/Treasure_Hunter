package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;

    public KeyHandler() {}




    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            this.upPressed = true;
        }
        if (code == KeyEvent.VK_DOWN) {
            this.downPressed = true;
        }

        if (code == KeyEvent.VK_LEFT) {
            this.leftPressed = true;
        }
        if (code == KeyEvent.VK_RIGHT) {
            this.rightPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == 38) {
            this.upPressed = false;
        }
        if (code == 40) {
            this.downPressed = false;
        }
        if (code == 37) {
            this.leftPressed = false;
        }
        if (code == 39) {
            this.rightPressed = false;
        }

    }
}
