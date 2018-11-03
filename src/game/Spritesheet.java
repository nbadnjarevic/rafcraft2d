package game;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	private int blocksize;
	private int col;
	private BufferedImage sprite;
	
	public Spritesheet(int col, int blocksize) {
		this.blocksize = blocksize;
		this.col = col;
		loadSpritesheet();
	}
	
	public BufferedImage getTexture(int id) {
		int y = (id/col) * blocksize;
		int x = (id%col) * blocksize;
		return sprite.getSubimage(x, y, blocksize, blocksize);
	}

	private void loadSpritesheet() {
		try {
			sprite = ImageIO.read(new File("img/spritesheet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
