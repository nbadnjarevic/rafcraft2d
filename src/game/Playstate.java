package game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Playstate extends State {
	
	public static World world;
	public static Player player;

	public Playstate(GameStateManager gsm) {
		super(gsm);
		world = new World("worlds/world2.txt", 32, 10);
		player = new Player(40, 5, 32, 48, 1F);
	}

	@Override
	public void update() {
		player.update();
	}

	@Override
	public void render(Graphics2D g) {
		g.clearRect(0, 0, 800, 600);
		world.render(g);
		player.render(g);
	}

	@Override
	public void keyPressed(KeyEvent e, int k) {
		player.keyPressed(e, k);
	}

	@Override
	public void keyReleased(KeyEvent e, int k) {
		player.keyReleased(e, k);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
