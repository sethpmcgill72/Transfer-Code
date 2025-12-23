package GameTest;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{//Handles inputs
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    @Override public void keyTyped(KeyEvent e){}//unused, but needed here because it is from an interface.

    @Override
    public void keyPressed(KeyEvent e) { //if input is being held, set input to true
        int code = e.getKeyCode();//returns an int value associated with a key (ASCII values).

        switch (code){
            case(KeyEvent.VK_W):
                upPressed = true;break;
            case(KeyEvent.VK_S):
                downPressed = true;break;
            case(KeyEvent.VK_A):
                leftPressed = true;break;
            case(KeyEvent.VK_D):
                rightPressed = true;break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        switch (code) {
            case (KeyEvent.VK_W):
                upPressed = false;break;
            case (KeyEvent.VK_S):
                downPressed = false;break;
            case (KeyEvent.VK_A):
                leftPressed = false;break;
            case (KeyEvent.VK_D):
                rightPressed = false;break;
        }
    }
}