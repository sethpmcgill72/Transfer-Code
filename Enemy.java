package GameTest;
import java.awt.*;

public class Enemy extends Entity {
    GamePanel gp;

    public Enemy(GamePanel gp){//no keyHandler cause enemy is not controlled by player.
        super(gp);
        setDefaultValues();
    }

   public void setDefaultValues(){
        super.setDefaultValues();
        x = (int)(Math.random() * 768);
        y = (int)(Math.random() * 576);
        this.leftX = x - width;
        this.rightX = x + width;
        this.lowerY = y - height;
        this.upperY = y + height;
   }

    public void update(){
        putInBounds(this);

        switch((int)(Math.random() * 4)){
            case 0:
                x += 15;break;
            case 1:
                x -= 15;break;
            case 2:
                y += 15;break;
            case 3:
                y -= 15;break;
        }
        leftX = x - width;
        rightX = x + width;
        lowerY = y - height;
        upperY = y + height;
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.blue);
        g2.fillRect(x, y, 48, 48);

        Graphics2D g1 = (Graphics2D)g2;
        g1.setColor(Color.white);
        g1.fillRect(x + 12, y + 12, 24, 24);
    }
}
