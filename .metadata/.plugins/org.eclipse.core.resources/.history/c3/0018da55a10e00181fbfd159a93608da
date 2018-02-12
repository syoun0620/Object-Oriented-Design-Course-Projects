package hw2;

import java.util.Scanner;

public class Initialize {
	final int PLAYER_KIND = 3;
	private Game game;
	private Scanner sc;
	
	public void setUp(){
		sc = new Scanner(System.in);
		System.out.print("How many players do you want in this game?: ");
		int numPlayer = sc.nextInt();
		while (numPlayer <2){
			System.out.println("At least 2 players are required.");
			numPlayer = sc.nextInt();
		}
		int input;
		
		int[] playerInput = new int[numPlayer];
		for (int i = 0; i<numPlayer; i++){
			System.out.print("Choose the type of player" + (i+1) + " (1 = human player, 2 = timid player, 3 = crafty player) : ");
			input = sc.nextInt();
			if (input < PLAYER_KIND+1){
				playerInput[i] = input; 
			}
			else{
				System.out.println("Please choose a correct input.");
				i--;
			}
		}
		System.out.println(""); // to have empty line. 
		
		game = new Game(playerInput, sc);
		game.generatePlayers(playerInput);
		
	}
	public void begin(){
		while (!game.isDone()){
			game.elapseOneTurn();
		}
		sc.close();
	}
	
	public void elapseOneTurn(){
		game.elapseOneTurn();
	}

	public void printWinner(){
		System.out.println("Congratulations! The winner is player" + game.getWinnerId() + ".");
	}
}
