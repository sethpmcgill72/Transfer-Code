package GameTest;

public class Entity {//superclass for all entities
    GamePanel gp;
    public int x, y;

    public int speed;
    public double health;

    public int width;
    public int height;

    public int leftX;
    public int rightX;
    public int lowerY;
    public int upperY;

    public Entity(GamePanel gp){
        this.gp = gp;
        setDefaultValues();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        health = 100;
        width = gp.tileSize;
        height = gp.tileSize;
        leftX = x - width;
        rightX = x + width;
        lowerY = y - height;
        upperY = y + height;
    }

    public void putInBounds(Entity entity){
        if(entity.x < 0){
            entity.x = 0;
        }

        if(entity.y < 0){
            entity.y = 0;
        }

        if(entity.x > 768 - width){
            entity.x = 768 - width;
        }

        if(entity.y > 576 - height){
            entity.y = 576 - height;
        }
    }

    public boolean inBounds(){
        return x < 0 || y < 0 || x > this.gp.screenWidth || y > this.gp.screenHeight;
    }

    public boolean isDead(){
        return health <= 0;
    }
}
