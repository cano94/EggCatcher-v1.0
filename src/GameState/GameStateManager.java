package GameState;

import java.awt.Graphics2D;
import java.util.*;
import java.util.logging.Level;


public class GameStateManager {

	private ArrayList<GameState>  gameStates;
	private int currentState;
	public static final int MENUSTATE = 0; 
	public static final int LEVEL1STATE = 1;
	public static final int LEVEL2STATE = 2;
	public static final int HELPSTATE = 3;


	public GameStateManager(){

		gameStates = new ArrayList<GameState>();

		currentState = MENUSTATE;
		gameStates.add(new MenuState(this));


		gameStates.add(new Level1State(this));

		gameStates.add(new Level2State(this));

		gameStates.add(new HelpState(this));

	}

	public void setState(int state){
		currentState = state;
		gameStates.get(currentState).init();
	}

	public void update(){
		gameStates.get(currentState).update();

	}

	public void draw(java.awt.Graphics2D g){
		gameStates.get(currentState).draw(g);
	}

	public void keyPressed(int k){
		gameStates.get(currentState).keyPressed(k);

	}

	public void keyReleased(int k){
		gameStates.get(currentState).keyReleased(k);	

	}


	public int getCurrentState() {
		return currentState;
	}

	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}



}
