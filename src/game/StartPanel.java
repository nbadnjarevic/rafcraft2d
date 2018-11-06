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

	public void initButtons() {
		this.add(Box.createRigidArea(new Dimension(0, 150)));

		ImageIcon imgPlay = new ImageIcon("img/btnPlay.png");
		btnPlay = new JButton(imgPlay);
		btnPlay.setBackground(new Color(255, 255, 255, 0));
		btnPlay.setMargin(new Insets(0, 0, 0, 0));
		btnPlay.setBorder(null);
		btnPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(btnPlay);

		this.add(Box.createRigidArea(new Dimension(0, 35)));

		ImageIcon imgQuit = new ImageIcon("img/btnQuit.png");
		btnQuit = new JButton(imgQuit);
		btnQuit.setBackground(new Color(255, 255, 255, 0));
		btnQuit.setMargin(new Insets(0, 0, 0, 0));
		btnQuit.setBorder(null);
		btnQuit.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(btnQuit);

		btnPlay.addActionListener(e -> {
			JPanel cards = Game.getCards();
			CardLayout cl = (CardLayout) cards.getLayout();
			drawTransition();
			cl.next(cards);
		});
		btnQuit.addActionListener(e -> {
			System.exit(0);
			;
		});
	}

	private void drawTransition() {
		Graphics g = this.getGraphics();
		int n = GamePanel.height;
		int m = GamePanel.width;
		Color color = Color.BLACK;
		int blocksize = Game.BLOCKSIZE;
		int i, k = 0, l = 0; 
		int s = 1;
        /*  k - starting row index 
        m - ending row index 
        l - starting column index 
        n - ending column index 
        i - iterator 
        */
           
        while (k < m && l < n) 
        { 
            // Print the first row from the remaining rows 
            for (i = l; i < n; i+=blocksize) 
            { 
            	g.setColor(color);
				g.fillRect(k, i, blocksize, blocksize);
				try {
					Thread.sleep(s);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } 
            k+=blocksize; 
   
            // Print the last column from the remaining columns  
            for (i = k; i < m; i+=blocksize) 
            { 
            	g.setColor(color);
				g.fillRect(i, n-1, blocksize, blocksize);
				try {
					Thread.sleep(s);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } 
            n-=blocksize; 
   
            // Print the last row from the remaining rows */ 
            if ( k < m) 
            { 
                for (i = n-1; i >= l;i-=blocksize) 
                { 
                	g.setColor(color);
    				g.fillRect(m-1, i, blocksize, blocksize);
    				try {
    					Thread.sleep(s);
    				} catch (InterruptedException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
                } 
                m-=blocksize; 
            } 
   
            // Print the first column from the remaining columns */ 
            if (l < n) 
            { 
                for (i = m-1; i >= k; i-=blocksize) 
                { 
                	g.setColor(color);
    				g.fillRect(i, l, blocksize, blocksize);
    				try {
    					Thread.sleep(s);
    				} catch (InterruptedException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
                } 
                l+=blocksize;     
            }       
        }
	}

	private void drawTransition2() {
		Graphics g = this.getGraphics();
		Color color = Color.BLACK;
		int blocksize = Game.BLOCKSIZE;
		for (int i = 0; i < GamePanel.height; i += blocksize) {
			for (int j = 0; j < GamePanel.width; j += blocksize) {
				g.setColor(color);
				g.fillRect(j, i, blocksize, blocksize);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backdrop, 0, 0, this.getWidth(), this.getHeight(), this);
	}

}
