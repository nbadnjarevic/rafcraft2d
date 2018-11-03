package game;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Game extends JFrame{

	public static Spritesheet sprite = new Spritesheet(6, 80);
	public static final int BLOCKSIZE = 32;
	public Game() {
		super("RAFCraft2D");
		setLayout(new BorderLayout());
		setSize(800,600);
		add(new GamePanel(), BorderLayout.CENTER);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Game();
	}

}
