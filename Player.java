package GameTest;
import java.awt.*;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    private boolean touchingEnemy = false;

    public Player(GamePanel gp, KeyHandler keyH){
        super(gp);
        this.keyH = keyH;
        setDefaultValues();
    }//allows usage of the gamePanel and keyHandler (movement, threads, etc).

    public void setDefaultValues(){
        super.setDefaultValues();
    }

    public void update(){//multiple update methods so that things that need to be updated aren't all in the same method (would take 100s of lines of code)
        if(touchingEnemy){
            health -= 0.5;
        }

        if(isDead()){
            health = 0;
            System.out.println(getHealth());

            gp.stop(); //TODO: This is null. Fix.
        }

        if(keyH.upPressed){//THE UPPER LEFT CORNER IS (0,0), NOT THE CENTER OF THE SCREEN!
            //direction = "up"; Not using buffered images.
            y -= speed;//y increases as it goes down.
        }
        else if(keyH.downPressed){
            y += speed;
        }
        else if(keyH.leftPressed){
            x -= speed;//x acts normally.
        }
        else if(keyH.rightPressed){
            x += speed;
        }

        putInBounds(this);
    }

    public void touchingEnemy(Enemy enemy){
        touchingEnemy = this.x >= enemy.leftX && this.x <= enemy.rightX && this.y >= enemy.lowerY && this.y <= enemy.upperY;
    }

    public String getPosition(){
        return "x: " + this.x + " y: " + this.y;
    }

    public String getHealth(){
        return "Health: " + health;
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.red);
        g2.fillRect(x, y, 48, 48);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);//gp is a GamePanel object from the constructor

        Graphics2D g1 = (Graphics2D)g2;//cast to create a new object, since g1 = g2 would make objects the same in memory.
        g1.setColor(Color.white);
        g1.fillRect(x + 12, y + 12, 24, 24);
        //g1.fillRect(x + 12, y + 12, gp.tileSize / 2, gp.tileSize / 2);
    }
}
