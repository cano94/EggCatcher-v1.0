


import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;








public class Level1State extends GameState{
	private Random r= new  Random();
	private Background bg;
	private BasketEntity basket;
	private ChickenEntity chicken1;
	private ChickenEntity chicken2;
	private ChickenEntity chicken3;
	private ArrayList<GiftEntity> gifts = new ArrayList<GiftEntity>();
	private ArrayList<EggEntity> eggs = new ArrayList<EggEntity>();
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	private int score=0;
	private int lives=5;
	private int currentChoice = 0;
	private AudioPlayer sfx;
	private AudioPlayer sfx1;
	private AudioPlayer win;
	private AudioPlayer over;
	private boolean running = true;
	private boolean giftCollide = false;
	private int rGift;







	public Level1State(GameStateManager gsm){
		this.gsm = gsm;



		try{
			bg = new Background("/Backgrounds/level1back.jpg", 1);
			basket = new BasketEntity("Sprites/Basket/basket.gif",130,200);
			chicken1 = new ChickenEntity("Sprites/Chicken/1.gif", 30, 20);
			chicken2 = new ChickenEntity("Sprites/Chicken/1.gif", 130, 20);
			chicken3 = new ChickenEntity("Sprites/Chicken/1.gif", 230, 20);

			entities.add(basket);
			entities.add(chicken1);
			entities.add(chicken2);
			entities.add(chicken3);
			sfx = new AudioPlayer("/SFX/sfx1.mp3");
			sfx1 = new AudioPlayer("/SFX/sfx2.mp3");
			win = new AudioPlayer("/SFX/win.mp3");
			over = new AudioPlayer("/SFX/over.mp3");
		}

		catch(Exception e){
			e.printStackTrace();
		}
	}


	@Override
	public void init() {




	}


	@Override
	public void update() {
		if(running){

			int n = r.nextInt(220);
			int n2 = r.nextInt(800);
			int pos = r.nextInt(3);


			double min = 1;
			double max = 2;
			double randomValue = min + (max - min) * r.nextDouble();



			bg.update();
			basket.update();

			if(n<1){


				EggEntity egg = new EggEntity("Sprites/Egg/blue_egg.gif", 33, 35);
				sfx1.play();
				entities.add(egg);
				egg.setVerticalMovement(randomValue);
				eggs.add(egg);



				if(pos==0){
					egg.setX(33);
					egg.setY(35);

				}
				if(pos==1){
					egg.setX(133);
					egg.setY(35);
				}
				if(pos==2){

					egg.setX(233);
					egg.setY(35);
				}
			}
			for(int i =0; i<eggs.size(); i++){

				eggs.get(i).update();

			}

			for(int i=0; i<eggs.size();i++){
				if(eggs.get(i).getY()>480){
					eggs.remove(i);

				}

			}
			for (int i=0;i<entities.size();i++) {
				if(entities.get(i) instanceof EggEntity){
					EggEntity egg = (EggEntity) entities.get(i);


					if (basket.collidesWith(egg)) {
						basket.collidedWith(egg);
						egg.collidedWith(basket);
						score++;

					} else{
						if(egg.getY()>245){

							if(entities.get(i) instanceof EggEntity && entities.get(i).collidesWith(basket)==false){
								entities.remove(entities.get(i));
								lives--;
							}

							if(lives==0){
								currentChoice=1;

							}

						}
					}
				}
			}
			for(int j=0; j<entities.size();j++){
				if(entities.get(j) instanceof EggEntity && entities.get(j).collidesWith(basket)){
					entities.remove(entities.get(j));
				}
			}
			if(n2<1){

				GiftEntity gift = new GiftEntity("Sprites/Egg/gift.gif", 33, 35);

				sfx1.play();
				gift.setVerticalMovement(randomValue);
				entities.add(gift);
				gifts.add(gift);

				if(pos==0){
					gift.setX(33);
					gift.setY(35);

				}
				if(pos==1){
					gift.setX(133);
					gift.setY(35);
				}
				if(pos==2){

					gift.setX(233);
					gift.setY(35);
				}


			}

			for(int i =0; i<gifts.size(); i++){

				gifts.get(i).update();

			}

			for(int i=0; i<gifts.size();i++){
				if(gifts.get(i).getY()>480){
					gifts.remove(i);

				}

			}
			for (int i=0;i<gifts.size();i++) {
				GiftEntity gift = (GiftEntity) gifts.get(i);

				if (basket.collidesWith(gift)) {
					basket.collidedWith(gift);
					gift.collidedWith(basket);
					rGift = r.nextInt(6);
					System.out.println("çarpýþma");

					if(rGift==0){
						lives--;
						System.out.println("can azaldý");
					}
					else if(rGift==1){
						giftCollide=true;
						System.out.println("hýz arttý");
					}
					else if(rGift==2){
						giftCollide=true;
						System.out.println("hýz azaldý");
					}
					else if(rGift==3){
						lives++;
						System.out.println("can arttý");
					}
					else if(rGift==4){
						score--;
						System.out.println("skor azaldý");
					}
					else if(rGift==5){
						score++;
						System.out.println("skor arttý");
					}



				}

			}
			for (int i=0;i<entities.size();i++) {
				if(entities.get(i) instanceof GiftEntity){
					GiftEntity gift = (GiftEntity) entities.get(i);

					if(gift.getY()>245){

						if(entities.get(i) instanceof GiftEntity && entities.get(i).collidesWith(basket)==false){
							entities.remove(entities.get(i));

						}

					}

				}
			}

			for(int j=0; j<entities.size();j++){
				if(entities.get(j) instanceof GiftEntity && entities.get(j).collidesWith(basket)){
					entities.remove(entities.get(j));
				}
			}


		}
		chicken1.update();
		chicken2.update();
		chicken3.update();
	}



	@Override
	public void draw(Graphics2D g){


		bg.draw(g);
		basket.draw(g);
		chicken1.draw(g);
		chicken2.draw(g);
		chicken3.draw(g);
		g.drawString("Lives: " + lives, 5, 20);
		g.drawString("Score: " + score, 5, 40);


		for(int j=0 ; j<eggs.size(); j++){
			eggs.get(j).draw(g);
			if(eggs.get(j).collidesWith(basket)){
				eggs.remove(j);


			}
		}
		for(int j=0 ; j<gifts.size(); j++){
			gifts.get(j).draw(g);
			if(gifts.get(j).collidesWith(basket)){
				gifts.remove(j);


			}
		}

		if(score==10){

			basket.setHorizontalMovement(0);
			if(running){
				sfx1.stop();
				win.play();
			}
			this.running = false;
			for(int i=0; i< eggs.size(); i++){
				entities.get(i).setVerticalMovement(0);
				eggs.clear();
				entities.clear();
				gifts.clear();



			}

			g.drawString("Level 1 completed !!", 90,100);
			g.drawString("Press enter for next level!!", 90, 120);



		}

		if(lives==0){

			basket.setHorizontalMovement(0);
			if(running){
				sfx1.stop();
				over.play();
			}
			this.running=false;
			for(int i=0; i< eggs.size(); i++){
				eggs.get(i).setVerticalMovement(0);
				eggs.clear();
				entities.clear();
				gifts.clear();


			}
			g.drawString("Level 1 failed !!", 100,100);
			g.drawString("Press press R for play again!!", 100, 120);

		}
	}



	public void restartLevel(){
		eggs.clear();
		gifts.clear();
		entities.clear();
		score=0;
		lives=5;
		gsm.setState(1);

		this.running=true;


	}



	@Override
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_RIGHT && basket instanceof BasketEntity){
			basket.setHorizontalMovement(2);
			if(giftCollide && rGift==1){
				basket.setHorizontalMovement(3);
				System.out.println(basket.getHorizontalMovement());
			}
			if(giftCollide && rGift==2){
				basket.setHorizontalMovement(1);
				System.out.println(basket.getHorizontalMovement());
			}
		}

		if(k == KeyEvent.VK_LEFT && basket instanceof BasketEntity){
			basket.setHorizontalMovement(-2);
			if(giftCollide && rGift==1){
				basket.setHorizontalMovement(-3);
				System.out.println(basket.getHorizontalMovement());
			}
			if(giftCollide && rGift==2){
				basket.setHorizontalMovement(-1);
				System.out.println(basket.getHorizontalMovement());
			}
		}


		if(basket.getHorizontalMovement() < 0 && basket.getX() < 0) {
			basket.setHorizontalMovement(0);
		}
		if(basket.getHorizontalMovement() > 0 && basket.getX() > 280){
			basket.setHorizontalMovement(0);
		}


		if(score==10 && k == KeyEvent.VK_ENTER){
			gsm.setCurrentState(2);

		}
		if(lives==0 &&  k == KeyEvent.VK_R){
			restartLevel();


		}

	}
	@Override
	public void keyReleased(int k) {

		if(k == KeyEvent.VK_RIGHT && basket instanceof BasketEntity){
			basket.setHorizontalMovement(0);
		}


		if(k == KeyEvent.VK_LEFT && basket instanceof BasketEntity){
			basket.setHorizontalMovement(0);

		}

		if(basket.getHorizontalMovement() < 0 && basket.getX() < 0) {
			basket.setHorizontalMovement(0);
		}
		if(basket.getHorizontalMovement() > 0 && basket.getX() > 280){
			basket.setHorizontalMovement(0);

		}

	}
}



