package game;

import java.awt.*;

public class Bullet extends Entity{

    private float speed = 0;
    private static Spritesheet sprite = new Spritesheet(ImageLoader.load("img/orbs.png"), 4, 32, 32);
    private boolean strana;
    private Player player;
    protected Animation animation;
    

    public Bullet(float x, float y, int width, int height, boolean strana, Player player) {
        super(sprite, x, y, width, height, 120F);
        this.player = player;
        this.strana = strana;
        this.animation = new Animation(sprite, 0, 4, 120L);
        this.x = GamePanel.width / 2 / GamePanel.SCALE - width / 2;
        this.y = GamePanel.height / 2 / GamePanel.SCALE - height / 2;
    }

    public void render(Graphics g){
        g.drawImage(animation.getImage(), (int) x, (int) y , width, height, null);
    }
    
    public void update() {
		calculateMovement();
		move();
	}
    
    private void calculateMovement() {
    	animation.update();
        if (strana) {
            speed = -6;
        } else{
            speed = 6;
        };
	}
   
    public void move() {
        x += speed;
        y += player.getDy() * -1 ;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }
}
