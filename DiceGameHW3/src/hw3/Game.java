package hw3;

public class Game {
	private Player[] players;
	private int numPlayer;
	private int turnIndex;
	private int chipsInPot;
	private int numConsecutiveWinning;

	public Game(Player[] playerL){
		this.players = playerL;
		this.turnIndex = 0;
		this.numPlayer = playerL.length;
		this.chipsInPot = 0;
		this.numConsecutiveWinning = 1;
	}
	
	
	public boolean isDone(){
		return getTopPlayer().getChip() >= 30;
	}
	
	private int rollDice(){
		return (int) ((Math.random() * 4) +1);
	}
	
	public void elapseOneTurn(){
		Player currentTurnPlayer = this.players[this.turnIndex++];
		this.chipsInPot++;
		
		for (int i = 0; i<this.numConsecutiveWinning; i++){
			if (rollDice() == 1){
				System.out.println(currentTurnPlayer.getPlayerName() + " aced out after " + this.numConsecutiveWinning + " rolls.");
				this.numConsecutiveWinning = 1;
				break;
			}
			else if (i == this.numConsecutiveWinning-1){
				// win. never got dice 1. 
				if (currentTurnPlayer.decide(getTopPlayer().getChip(), this.chipsInPot)){ //if this player decide to keep going
					this.numConsecutiveWinning++;
					this.chipsInPot += this.numConsecutiveWinning;
				}
				else{ // if thisPlayerTurn.decide() == false. which means take the pot. 
					currentTurnPlayer.addChip(this.chipsInPot);
					
					System.out.println(currentTurnPlayer.getPlayerName() + " stopped after " + this.numConsecutiveWinning + " rolls and won " + this.chipsInPot + " chips.");
					this.chipsInPot = 0;
					this.numConsecutiveWinning=1;
				}
			}
		}
		
		// print status
		System.out.println("Current Status: " + toString() );
		System.out.println("The pot contains " + this.chipsInPot + " chips. \n");
		
		this.turnIndex = this.turnIndex%numPlayer;
	}
	public String toString(){
		String res = "";
		for (Player p: this.players){
			res += " " + p.toString();
		}
		return res;
	}
	public Player getTopPlayer(){
		int maxChip = 0;
		Player topPlayer = this.players[0]; // to initialize. 
		for (Player p: this.players){
			if (p.getChip() > maxChip){
				maxChip = p.getChip();
				topPlayer = p;
			}	
		}
		return topPlayer;
	}

	public void updateWinLoss(){
		Player winnerP = getTopPlayer();		
		for (Player p: players){
			if (p.getPlayerName() == winnerP.getPlayerName()){
				p.addWin();
			}
			else{
				p.addLoss();
			}
		}
	}
}
