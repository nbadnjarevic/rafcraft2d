package game;

import java.awt.Graphics2D;

public class Entity extends GameObject {

	// Constants
	private final float GRAVITY = 0.2F;
	private final float MAX_FALLING_SPEED = 2.5F;
	private final float JUMP_START = -3.5F;

	// Movement
	protected float speed;
	protected float dx;
	protected float dy;
	protected boolean left;
	protected boolean right;
	protected boolean falling;
	protected boolean jumping;

	// Collision
	protected boolean topLeft;
	protected boolean topRight;
	protected boolean midLeft;
	protected boolean midRight;
	protected boolean botLeft;
	protected boolean botRight;

	// Animation
	protected int idle;
	protected int state;
	protected int[] frames = { 1, 1, 4, 4 };
	protected final int IDLE_LEFT = 1;
	protected final int IDLE_RIGHT = 2;
	protected final int LEFT = 1;
	protected final int RIGHT = 2;
	protected Animation animation;

	public Entity(Spritesheet sprite, float x, float y, int width, int height, float speed) {
		super(x, y, width, height);
		this.speed = speed;
		this.animation = new Animation(sprite, IDLE_RIGHT, frames[IDLE_RIGHT], 120L);
		this.idle = IDLE_RIGHT;
	}

	public void render(Graphics2D g) {
		g.drawImage(animation.getImage(), (int) x, (int) y, width, height, null);
	}

	public void update() {
		calculateMovement();
		calculateCollision();
		calculateAnimations();
		move();
	}

	private void calculateAnimations() {
		animation.update();
		if(left && animation.getState() != LEFT) {
			animation.setImages(LEFT, frames[LEFT+2]);
			idle = IDLE_LEFT;
		} else if(right && animation.getState() != RIGHT) {
			animation.setImages(RIGHT, frames[RIGHT]);
			idle = IDLE_RIGHT;
		}
		if(!left && !right) {
			animation.setImages(idle, frames[idle]);
		}
		if(jumping || falling) {
			animation.setImages(idle, frames[idle]);
		}
	}

	private void calculateCollision() {
		float tox = x + dx;
		float toy = y + dy;

		// Collision left and right
		calculateCorners(tox, y - 1);
		if (dx < 0) {
			if (topLeft || midLeft || botLeft) {
				dx = 0;
			}
		}
		if (dx > 0) {
			if (topRight || midRight || botRight) {
				dx = 0;
			}
		}
		// Collision top and bottom
		calculateCorners(x, toy);
		if (botLeft || botRight && falling) {
			falling = false;
			dy = 0;
			int playerRow = Playstate.world.getRowTile((int) toy + height);
			y = (playerRow * Game.BLOCKSIZE - height);
		}

		if (!botLeft && !botRight) {
			falling = true;
		}

		if (topLeft || topRight) {
			dy = 0;
			falling = true;
			int playerRow = Playstate.world.getRowTile((int) toy);
			y = ((playerRow + 1) * Game.BLOCKSIZE);
		}
	}

	private void calculateCorners(float x, float y) {
		World world = Playstate.world;
		int leftTile = world.getColTile((int) x + 7);
		int rightTile = world.getColTile((int) x + width - 8);
		int topTile = world.getRowTile((int) y);
		int midTile = world.getRowTile((int) y + height / 2);
		int botTile = world.getRowTile((int) y + height);
		try {
			topLeft = !world.getBlocks()[topTile][leftTile].getMaterial().isWalkable();
			topRight = !world.getBlocks()[topTile][rightTile].getMaterial().isWalkable();
			midLeft = !world.getBlocks()[midTile][leftTile].getMaterial().isWalkable();
			midRight = !world.getBlocks()[midTile][leftTile].getMaterial().isWalkable();
			botLeft = !world.getBlocks()[botTile][leftTile].getMaterial().isWalkable();
			botRight = !world.getBlocks()[botTile][rightTile].getMaterial().isWalkable();
		} catch (Exception ex) {

		}
	}

	private void calculateMovement() {
		if (left)
			dx = -speed;
		if (right)
			dx = speed;
		if (falling && !jumping) {
			dy += GRAVITY;
			if (dy > MAX_FALLING_SPEED)
				dy = MAX_FALLING_SPEED;
		}
		if (jumping && !falling) {
			dy = JUMP_START;
			jumping = false;
			falling = true;
		}
	}

	private void move() {
		x += dx;
		y += dy;
		dx = 0;
	}

}
