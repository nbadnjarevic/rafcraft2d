package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet extends GameObject{

    private float speed = 0;
    private BufferedImage img = ImageLoader.load("img/bullet.png");
    private boolean strana;

    public Bullet(float x, float y, int width, int height, boolean strana) {
        super(x, y, width, height);
        this.strana = strana;
        this.x = GamePanel.width / 2 / GamePanel.SCALE - width / 2;
        this.y = GamePanel.height / 2 / GamePanel.SCALE - height / 2;
    }

    public void render(Graphics g){
        g.drawImage(img, (int)x, (int)y , width, height, null);
    }

    public void update() {
        if (strana) {
            speed = -2;
        } else{
            speed = 2;
        }


        x += speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }
}
