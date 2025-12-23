package GameTest;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{//Handles display and graphics, as well as screen settings.
    final int originalTileSize = 16;//16x16 tile, size of things.
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12; //4:3 ratio.
    final int screenWidth = tileSize * maxScreenCol; //768 px.
    final int screenHeight = tileSize * maxScreenRow; //576 px. Can always change if needed.

    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player;
    Enemy enemy;
    Enemy enemy2;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //set the size of this class, (width, length)
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);//does things in the background to improve performance.
        this.addKeyListener(keyH);
        this.setFocusable(true);
        player = new Player(this,keyH);
        enemy = new Enemy(this);
        enemy2 = new Enemy(this);
    }

    public void startGameThread(){
        gameThread = new Thread(this);//this simply passes in this class' constructor. how to instantiate a thread.
        gameThread.start();//calls run.
    }

    @Override
    public void run(){//completed = to FPS
        double drawInterval = 1000000000.0 / FPS; //draw every .016 seconds (60/sec)
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null){//as long as it exists...
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1){
                update();//1 update: update info such as char position.
                repaint();//2 draw: draw the screen with updated info. calls paintComponent method for some reason.
                delta--;
                drawCount++;
            }

            if (timer >= 1_000_000_000){
                System.out.println("FPS " + drawCount);
                System.out.println(player.getPosition());
                System.out.println(player.getHealth());
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update(){
        player.update();//invokes update method on player object
        player.touchingEnemy(enemy);
        player.touchingEnemy(enemy2);
        enemy.update();
        enemy2.update();
    }

    public void paintComponent(Graphics g){//overrides JPanel paint method.
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        player.draw(g2);//NOT NULL
        enemy.draw(g2);
        enemy2.draw(g2);

        g2.dispose();//when drawing is done, release memory used.
    }

    public void stop(){//condition gameThread != null is not met. stop all updates, movement, etc.
        gameThread = null;
    }
}