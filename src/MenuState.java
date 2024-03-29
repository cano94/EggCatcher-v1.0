

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import javax.sound.sampled.AudioFormat;

public class MenuState extends GameState {

	private Background bg;
	private AudioPlayer sfx;

	private int currentChoice = 0;
	private String[] options = {
			"Start",
			"Help",
			"Quit"

	}; 

	private Color titleColor;
	private Font titleFont;

	private Font font;



	public MenuState(GameStateManager gsm){
		this.gsm = gsm;

		try{
			bg = new Background("/Backgrounds/menubg.gif", 1);

			bg.setVector(-0.2, 0);


			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 28);


			font = new Font("Arial", Font.PLAIN, 12);

			sfx = new AudioPlayer("/SFX/sfx1.mp3");

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
		bg.update();

	}

	@Override
	public void draw(Graphics2D g) {

		// draw bg
		bg.draw(g);

		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Crazy Eggs", 80, 70);

		// draw menu options
		g.setFont(font);
		for(int i = 0; i< options.length; i++){
			if(i==currentChoice){
				g.setColor(Color.black);
			}else{
				g.setColor(Color.red);	
			}
			g.drawString(options[i], 145, 140 + i * 15);

		}
	}
	private void select(){
		if(currentChoice == 0){
			// start
			gsm.setState(GameStateManager.LEVEL1STATE);
			sfx.play();
		}
		if(currentChoice == 1){
			// help
			gsm.setState(GameStateManager.HELPSTATE);
		}
		if(currentChoice == 2){
			// quit
			System.exit(0);
		}
	}

	@Override
	public void keyPressed(int k) {

		if(k == KeyEvent.VK_ENTER){
			select();
		}
		if(k == KeyEvent.VK_UP){
			currentChoice --;	
			if(currentChoice == -1){
				currentChoice = options.length - 1;
			}
		}

		if(k == KeyEvent.VK_DOWN){
			currentChoice ++;
			if(currentChoice == options.length){
				currentChoice = 0;
			}

		}
	}

	@Override
	public void keyReleased(int k) {
	}

}
