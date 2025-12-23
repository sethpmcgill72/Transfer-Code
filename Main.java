package GameTest;
import javax.swing.*;

public class Main{
    public static void main(String[]args){
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closes game upon hitting x in corner.
        window.setResizable(false);
        window.setTitle("Game");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);//adds the GamePanel object to be displayed.
        window.pack();//sets window to be the size of the gamePanel

        window.setLocationRelativeTo(null);//window is not set relative to anything (right or left side, etc.)
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}