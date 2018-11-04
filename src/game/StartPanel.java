package game;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StartPanel extends JPanel {

	public static int width;
	public static int height;
	private JButton btnPlay;
	private JButton btnQuit;
	Image backdrop = Toolkit.getDefaultToolkit().createImage("img/backdrop.png");

	public StartPanel() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		width = getPreferredSize().width;
		height = getPreferredSize().height;
		initButtons();
		setFocusable(true);
		requestFocus();
		
	}

	public void initButtons(){
		this.add(Box.createRigidArea(new Dimension(0, 150)));
		
		ImageIcon imgPlay = new ImageIcon("img/btnPlay.png");
		btnPlay = new JButton(imgPlay);
		btnPlay.setBackground(new Color(255,255,255,0));
		btnPlay.setMargin(new Insets(0, 0, 0, 0));
		btnPlay.setBorder(null);
		btnPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(btnPlay);
		
		this.add(Box.createRigidArea(new Dimension(0, 35)));
		
		ImageIcon imgQuit = new ImageIcon("img/btnQuit.png");
		btnQuit = new JButton(imgQuit);
		btnQuit.setBackground(new Color(255,255,255,0));
		btnQuit.setMargin(new Insets(0, 0, 0, 0));
		btnQuit.setBorder(null);
		btnQuit.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(btnQuit);
		
		btnPlay.addActionListener(e -> {
			JPanel cards = Game.getCards();
			CardLayout cl = (CardLayout) cards.getLayout();
			cl.next(cards);
		});
		btnQuit.addActionListener(e->{
			System.exit(0);;
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backdrop, 0, 0, this.getWidth(), this.getHeight(),this);
	}

}
