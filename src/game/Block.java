package game;

import java.awt.Graphics2D;

public class Block extends GameObject{
	
	private Material material;

	public Block(Material material, float x, float y, int width, int height) {
		super(x, y, width, height);
		this.material = material;
	}
	
	public void update() {
		
	}
	
	public void render(Graphics2D g) {
		g.drawImage(material.getTexture(), (int) x, (int) y, width, height, null);
	}
	
	public Material  getMaterial() {
		return material;
	}

}
