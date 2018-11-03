package game;

import java.awt.image.BufferedImage;

public enum Material {
	
	// MATERIAL LIST
	GRASS(0, false),
	DIRT(1, false),
	STONE(2, false),
	ROCK(3, true),
	AIR(15, true);
	

	private int id;
	private boolean walkable;
	private BufferedImage image;
	
	private Material(int id, boolean walkable) {
		this.id = id;
		this.walkable = walkable;
		this.image = Game.sprite.getTexture(id);
	}
	
	public int getID() {
		return id;
	}
	
	public boolean isWalkable() {
		return walkable;
	}

	public BufferedImage getTexture() {
		return image;
	}
}
