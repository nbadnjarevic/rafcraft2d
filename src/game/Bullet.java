package game;

public class Bullet extends Entity {

	private float speed = 0;
	private static Spritesheet sprite = new Spritesheet(ImageLoader.load("img/orbs.png"), 4, 32, 32);
	private boolean strana;
	private Player player;
	protected Animation animation;

	public Bullet(float x, float y, int width, int height, boolean strana, Player player) {
		super(sprite, x, y, width, height, 120F);
		this.player = player;
		this.strana = strana;
		this.animation = new Animation(sprite, 0, 4, 120L);
		this.x = GamePanel.width / 2 / GamePanel.SCALE - width / 2;
		this.y = GamePanel.height / 2 / GamePanel.SCALE - height / 2;
	}

	public void update() {
		calculateCollision();
		calculateMovement();
		move();
	}

	private void calculateCollision() {
		float tox = x + speed;
		World world = Playstate.world;
		int midTile = world.getRowTile((int) y - 1);
		int leftTile = world.getColTile((int) tox - 1);
		int rightTile = world.getColTile((int) tox + width);
		Block onBlock = Playstate.world.getBlock((int)tox, (int)y);
		if (this.getBox().intersects(onBlock.getBox())) {
			if (!onBlock.getMaterial().isWalkable()) {
				System.out.println("unisti desno");
				//player.getBlts().remove(this);
			}
		}
		onBlock = Playstate.world.getBlocks()[midTile][leftTile];
		if (this.getBox().intersects(onBlock.getBox())) {
			if (!onBlock.getMaterial().isWalkable()) {
				System.out.println("unisti levo");
				//player.getBlts().remove(this);
			}
		}
	}

	private void calculateMovement() {
		animation.update();
		if (strana) {
			speed = -6;
		} else {
			speed = 6;
		}
		;
	}

	public void move() {
		x += speed;
		y -= player.getDy();
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getSpeed() {
		return speed;
	}
}
