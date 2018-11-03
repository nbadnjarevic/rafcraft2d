package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Player extends Entity {

	public Player(float x, float y, int width, int height, float speed) {
		super(x, y, width, height, speed);
	}

	public void render(Graphics2D g) {
		g.setColor(new Color(255, 100, 100));
		g.fillRect(GamePanel.width / 2 / GamePanel.SCALE - width / 2, 
				GamePanel.height / 2 / GamePanel.SCALE - height / 2,
				width, height);
	}

	public void keyPressed(KeyEvent e, int k) {
		if (k == KeyEvent.VK_A)
			left = true;
		if (k == KeyEvent.VK_D)
			right = true;
		if (k == KeyEvent.VK_SPACE) {
			if (!falling && !jumping) {
				jumping = true;
			}
		}

	}

	public void keyReleased(KeyEvent e, int k) {
		if (k == KeyEvent.VK_A)
			left = false;
		if (k == KeyEvent.VK_D)
			right = false;
	}

}
