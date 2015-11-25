package GameState;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import GameEntities.EggEntity;
import GameEntities.GiftEntity;
import TileMap.Background;

public class HelpState extends GameState {

	private Background bg;
	private EggEntity egg;
	private GiftEntity gift;

	public HelpState(GameStateManager gsm){
		this.gsm = gsm;

		try{
			bg = new Background("/Backgrounds/level1back.jpg", 1);
			egg = new EggEntity("Sprites/Egg/blue_egg.gif", 10, 30);
			gift = new GiftEntity("Sprites/Egg/gift.gif",10 , 85);




		}
		catch(Exception e){

		}

	}

	@Override
	public void init() {


	}

	@Override
	public void update() {


	}

	@Override
	public void draw(Graphics2D g) {
		bg.draw(g);
		egg.draw(g);
		gift.draw(g);
		g.drawString("The logic behind the game is pretty simple,", 40,35);
		g.drawString("you should just catch eggs that are falling from" , 40,55);
		g.drawString("the top of the screen.When you are collecting eggs,", 40, 75);
		g.drawString("you should think twice to collect red boxes since,", 40, 95);
		g.drawString("they can help you to pass level by increasing your", 40, 115);
		g.drawString("lives,score and speed, but also they can be a treat for you",5,135);
		g.drawString("because,as well as they can increase, they can decrease" , 5, 155);
		g.drawString("your lives,score and speed too.So, you should be real ", 5 , 175);
		g.drawString("quick to decide.", 5, 195);
		g.drawString("Please press enter to back menu.", 120, 220);
	}

	@Override
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			
			gsm.setState(GameStateManager.MENUSTATE);


		}

	}

	@Override
	public void keyReleased(int k) {


	}

}
