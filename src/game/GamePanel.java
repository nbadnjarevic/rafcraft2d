package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener{

	private Timer timer;
	private GameStateManager gsm;
	private BufferedImage image;
	
	public GamePanel() {
		super();
		addMouseListener(this);
		addKeyListener(this);
		setBackground(new Color(100,100,255));
		setFocusable(true);
		requestFocus();
		
		image = new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);
		gsm = new GameStateManager(GameStateManager.PLAYSTATE);
		timer = new Timer(30, this);
		timer.start();
	}

	
	public void update() {
		gsm.update();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) image.getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		gsm.render(g2d);
		g.drawImage(image.getScaledInstance(800, 600, image.SCALE_DEFAULT), 0, 0, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		gsm.mousePressed(arg0);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		gsm.mouseReleased(arg0);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		gsm.keyPressed(arg0, arg0.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		gsm.keyReleased(arg0, arg0.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
