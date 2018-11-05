package game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet extends GameObject{

    private float speed = 0;
    private Spritesheet sprite = new Spritesheet(ImageLoader.load("img/orbs.png"), 4, 32, 32);
    private BufferedImage img = ImageLoader.load("img/bullet.png");
    private boolean strana;
    protected Animation animation;
    

    public Bullet(float x, float y, int width, int height, boolean strana) {
        super(x, y, width, height);
        this.strana = strana;
        this.animation = new Animation(sprite, 2, 4, 120L);
        this.x = GamePanel.width / 2 / GamePanel.SCALE - width / 2;
        this.y = GamePanel.height / 2 / GamePanel.SCALE - height / 2;
    }

    public void render(Graphics g){
        g.drawImage(animation.getImage(), (int)x, (int)y , width, height, null);
    }

    public void update() {
    	animation.update();
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
