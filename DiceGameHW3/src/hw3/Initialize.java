package hw3;

import java.util.Map;
import java.util.Scanner;

public class Initialize {
	final int PLAYER_KIND = 3;
	private Game game;
	private Scanner sc;
	GameConnection conn = new GameConnection("YounDiceGame16");
	Map<String, Player> playerMap = conn.getMap();
	Player[] players;
	
	public void setUp(){
		System.out.println("!!!!!!");
		System.out.println(playerMap);
		sc = new Scanner(System.in);
		System.out.print("How many players do you want in this game?: ");
		int numPlayer = sc.nextInt();
		while (numPlayer <2){
			System.out.println("At least 2 players are required.");
			numPlayer = sc.nextInt();
		}
		String pname;
		int ptype;
		
		players = new Player[numPlayer];
		for (int i = 0; i<numPlayer; i++){
			System.out.print("Enter player name: ");
			pname = sc.next();
			if (playerMap.get(pname) != null){ // if the username exists in Map.
				// if the existing player is Human, I have to start Scanner because Scanner was not saved in Map. 
				if (playerMap.get(pname) instanceof HumanPlayer){ 
					((HumanPlayer)playerMap.get(pname)).setScanner(sc);
				}
				players[i] = playerMap.get(pname);
			}
			else{  // if the username does NOT exists in Map. 
				System.out.print("Choose the type of " + pname + " (1 = human player, 2 = timid player, 3 = crafty player): ");
				ptype = sc.nextInt();
				if (ptype < PLAYER_KIND+1){
					if (ptype == 1){
						players[i] = new HumanPlayer(pname, this.sc);
					}
					else if (ptype == 2){
						players[i] = new TimidPlayer(pname);
					}
					else if (ptype == 3){
						players[i] = new CraftyPlayer(pname);
					}
					playerMap.put(pname, players[i]); 
	
				}
				else{
					System.out.println("Please choose a correct input.");
					i--;
				}
			}
		}
		System.out.println(""); // to have empty line. 
		
		game = new Game(players);	
	}
	public void begin(){
		while (!game.isDone()){
			game.elapseOneTurn();
		}
		// when game is done, update win and loss of players.
		game.updateWinLoss();
//		sc.close();
	}
	public void savePlayer(){
		conn.saveMap(playerMap);
		sc.close();
	}
	
	public void elapseOneTurn(){
		game.elapseOneTurn();
	}

	public void printWinner(){
		System.out.println("Congratulations! The winner is " + game.getWinnerName() + ".");
	}
	
	public void resetPlayerChip(){
		for (Player p: players){
			p.setChipZero();
		}
	}
}
