package game;

import java.awt.Graphics2D;

public class Chunk {

	private int chunksize;
	private Block[][] blocks;

	public Chunk(Block[][] world, int startX, int startY, int chunksize) {
		this.chunksize = chunksize;
		blocks = new Block[chunksize][chunksize];

		for (int row = 0; row < chunksize; row++) {
			for (int col = 0; col < chunksize; col++) {
				blocks[row][col] = world[startY + row][startX + col];
			}
		}
	}

	public void update() {
		for (int row = 0; row < chunksize; row++) {
			for (int col = 0; col < chunksize; col++) {
				blocks[row][col].update();
			}
		}
	}

	public void render(Graphics2D g) {
		for (int row = 0; row < chunksize; row++) {
			for (int col = 0; col < chunksize; col++) {
				blocks[row][col].render(g);
			}
		}
	}

}
