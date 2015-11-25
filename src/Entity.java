


import java.awt.Graphics2D;
import java.awt.Rectangle;






public abstract class Entity extends GameState {
	/** The current x location of this entity */ 
	protected double x;
	/** The current y location of this entity */
	protected double y; 
	/** The sprite that represents this entity */
	protected Sprites sprite;
	/** The current speed of this entity horizontally (pixels/sec) */
	protected double dx;
	/** The current speed of this entity vertically (pixels/sec) */
	protected double dy;
	/** The rectangle used for this entity during collisions  resolution */
	private Rectangle me = new Rectangle();
	/** The rectangle used for other entities during collision resolution */
	private Rectangle him = new Rectangle();

	/**
	 * Construct a entity based on a sprite image and a location.
	 * 
	 * @param ref The reference to the image to be displayed for this entity
	 * @param x The initial x location of this entity
	 * @param y The initial y location of this entity
	 */
	public Entity(String ref,int x,int y) {
		this.sprite = SpritesStore.get().getSprite(ref);
		this.x = x;
		this.y = y;
	}

	/**
	 * Request that this entity move itself based on a certain ammount
	 * of time passing.
	 * 
	 * @param delta The amount of time that has passed in milliseconds
	 */


	/**
	 * Set the horizontal speed of this entity
	 * 
	 * @param dx The horizontal speed of this entity (pixels/sec)
	 */
	public void setHorizontalMovement(double dx) {
		this.dx = dx;
	}

	/**
	 * Set the vertical speed of this entity
	 * 
	 * @param dx The vertical speed of this entity (pixels/sec)
	 */
	public void setVerticalMovement(double dy) {
		this.dy = dy;
	}

	/**
	 * Get the horizontal speed of this entity
	 * 
	 * @return The horizontal speed of this entity (pixels/sec)
	 */
	public double getHorizontalMovement() {
		return dx;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Get the vertical speed of this entity
	 * 
	 * @return The vertical speed of this entity (pixels/sec)
	 */
	public double getVerticalMovement() {
		return dy;
	}


	/**
	 * Do the logic associated with this entity. This method
	 * will be called periodically based on game events
	 */
	public void doLogic() {
	}

	/**
	 * Get the x location of this entity
	 * 
	 * @return The x location of this entity
	 */
	public int getX() {
		return (int) x;
	}

	/**
	 * Get the y location of this entity
	 * 
	 * @return The y location of this entity
	 */
	public int getY() {
		return (int) y;
	}

	/**
	 * Check if this entity collised with another.
	 * 
	 * @param other The other entity to check collision against
	 * @return True if the entities collide with each other
	 */
	public boolean collidesWith(Entity other) {
		me.setBounds((int) x,(int) y,sprite.getWidth(),sprite.getHeight());
		him.setBounds((int) other.x,(int) other.y,other.sprite.getWidth(),other.sprite.getHeight());

		return me.intersects(him);
	}

	public abstract void collidedWith(Entity other);


	@Override
	public void init() {


	}

	@Override
	public void update() {
		long lastLoopTime = System.currentTimeMillis();
		long delta = System.currentTimeMillis() - lastLoopTime;
		lastLoopTime = System.currentTimeMillis();	
		x += (delta *dx) / 1000;
		y += (delta *dy) / 1000;


	}

	@Override
	public void draw(Graphics2D g) {


	}

	@Override
	public void keyPressed(int k) {


	}

	@Override
	public void keyReleased(int k) {

	}
}