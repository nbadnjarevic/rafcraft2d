package game;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class World {

	private int blocksX;
	private int blocksY;
	private int blocksize;
	private int chunksize;
	private String filepath;
	private Block[][] blocks;
	private Chunk[][] chunks;

	public World(String filepath, int blocksize, int chunksize) {
		this.blocksize = blocksize;
		this.filepath = filepath;
		this.chunksize = chunksize;
		loadWorld();
		setChunks();
	}

	public void render(Graphics2D g) {
		for (int row = 0; row < chunks.length; row++) {
			for (int col = 0; col < chunks[0].length; col++) {
				chunks[row][col].render(g);
			}
		}
	}

	public void setChunks() {
		int chunksX = blocksX / chunksize;
		int chunksY = blocksY / chunksize;
		chunks = new Chunk[chunksY][chunksX];
		for (int row = 0; row < chunksY; row++) {
			for (int col = 0; col < chunksX; col++) {
				chunks[row][col] = new Chunk(blocks, col * chunksize, row * chunksize, chunksize);
			}
		}
	}

	public void loadWorld() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(filepath)));
			blocksX = Integer.parseInt(reader.readLine());
			blocksY = Integer.parseInt(reader.readLine());
			blocks = new Block[blocksY][blocksX];

			for (int row = 0; row < blocksY; row++) {
				String line = reader.readLine();
				String tokens[] = line.split(" ");
				for (int col = 0; col < blocksX; col++) {
					int id = Integer.parseInt(tokens[col]);
					blocks[row][col] = new Block(Material.values()[id], col * blocksize, row * blocksize, blocksize,
							blocksize);
				}
			}

			reader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public int getRowTile(int y) {
		return y / Game.BLOCKSIZE;
	}
	
	public int getColTile(int x) {
		return x / Game.BLOCKSIZE;
	}
	
	public Block getBlock(int x, int y) {
		return blocks[getRowTile(y)][getColTile(x)];
	}
	
	public Block[][] getBlocks() {
		return blocks;
	}

	public Chunk[][] getChunks() {
		return chunks;
	}
}
