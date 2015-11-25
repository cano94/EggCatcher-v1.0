package GameEntities;



import java.awt.Graphics2D;




public class BasketEntity extends Entity {



	public BasketEntity(String ref,int x,int y) {
		super(ref,x,y);



	}


	@Override
	public void init() {


	}

	@Override
	public void update() {
		x += dx;
		y += dy;


	}


	@Override
	public void draw(Graphics2D g) {
		sprite.draw(g,(int) x,(int) y);


	}

	@Override
	public void keyPressed(int k) {



	}



	@Override
	public void keyReleased(int k) {


	}


	@Override
	public void collidedWith(Entity other) {

		if (other instanceof EggEntity) {

		}
		else if(other instanceof GiftEntity){

		}

	}



}
