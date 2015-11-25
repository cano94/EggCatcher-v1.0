


import java.awt.Graphics2D;


public class EggEntity extends Entity{

	
	



	public EggEntity(String sprite,int x,int y) {
		super(sprite,x,y);


	}
	public void init() {


	}



	public void update() {
		x += dx;
		y += dy;


	}




	@Override
	public void draw(Graphics2D g) {
		sprite.draw(g,(int) x,(int) y);
	}

	public void keyPressed(int k) {



	}



	@Override
	public void keyReleased(int k) {


	}
	@Override
	public void collidedWith(Entity other) {
		
		
	}

}










