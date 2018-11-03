package game;

import java.awt.event.KeyEvent;

public class Player extends Entity {

	public Player(float x, float y, int width, int height, float speed) {
		super(x, y, width, height, speed);
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
