package game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Entity {

	private ArrayList<Bullet> blts = new ArrayList<>();
	private boolean strana = false; 	// left true, right false


	public Player(float x, float y, int width, int height, float speed) {
		super(new Spritesheet(ImageLoader.load("img/player.png"), 4, 32, 48), x, y, width, height, speed);
	}

	public void render(Graphics2D g) {
		g.drawImage(animation.getImage(),GamePanel.width / 2 / GamePanel.SCALE - width / 2,
				GamePanel.height / 2 / GamePanel.SCALE - height / 2,
				width, height, null);
	}

	public void keyPressed(KeyEvent e, int k) {
		if (k == KeyEvent.VK_A){
			left = true;
			strana = true;
		}
		else if (k == KeyEvent.VK_D){
			right = true;
			strana = false;
		}
		if (k == KeyEvent.VK_SPACE) {
			if (!falling && !jumping) {
				jumping = true;
			}
		}
		if(k == KeyEvent.VK_K){
			Bullet blt = new Bullet(x, y + height/2, 8, 8, strana);
			blts.add(blt);
		}

	}

	public void keyReleased(KeyEvent e, int k) {
		if (k == KeyEvent.VK_A)
			left = false;
		if (k == KeyEvent.VK_D)
			right = false;
	}

	public ArrayList<Bullet> getBlts() {
		return blts;
	}
}
