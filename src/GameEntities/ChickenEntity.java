package GameEntities;

import java.awt.Graphics2D;





public class ChickenEntity extends Entity
{

	private Sprites[] frames = new Sprites[7];
	private Animation a;




	public ChickenEntity(String ref,int x,int y) {
		super("Sprites/Chicken/1.gif",x,y);

		try {

			frames = new Sprites[8];
			frames[0]=sprite;
			frames[1] = SpritesStore.get().getSprite("Sprites/Chicken/2.gif");
			frames[2] = SpritesStore.get().getSprite("Sprites/Chicken/3.gif");
			frames[3] = SpritesStore.get().getSprite("Sprites/Chicken/4.gif");
			frames[4] = SpritesStore.get().getSprite("Sprites/Chicken/5.gif");
			frames[5] = SpritesStore.get().getSprite("Sprites/Chicken/6.gif");
			frames[6] = SpritesStore.get().getSprite("Sprites/Chicken/7.gif");
			frames[7] = SpritesStore.get().getSprite("Sprites/Chicken/8.gif");
		}

		catch(Exception e) {
			e.printStackTrace();
		}

		a = new Animation();
		a.setFrames(frames);
		a.setDelay(200);




	}




	@Override
	public void init() {


	}

	@Override
	public void update() {
		x += dx;
		y += dy;
		a.update();






	}

	@Override
	public void draw(Graphics2D g) {
		

		g.drawImage(a.getImage().getImage(),(int) x,(int) y,null);


	}




@Override
public void keyPressed(int k) {



}



@Override
public void keyReleased(int k) {


}


@Override
public void collidedWith(Entity other) {
	

}

}

