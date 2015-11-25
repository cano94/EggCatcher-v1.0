package Main;

import javax.swing.*;

import GameState.GameStateManager;
import GameState.Level1State;
import GameState.Level2State;


public class Game {
	
	
	
	public static void main(String [] args){

		JFrame window = new JFrame("Crazy Eggs");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		
		
	







	}

}
