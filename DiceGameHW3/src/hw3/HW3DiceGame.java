package hw3;

public class HW3DiceGame {
	
	public static void main(String[] args){
		
		DiceGameHandler diceGameHandler = new DiceGameHandler();
		diceGameHandler.setUp();
		diceGameHandler.run();
		diceGameHandler.updateWinLoss();
		diceGameHandler.printWinner();
		diceGameHandler.resetPlayerChip();
		diceGameHandler.savePlayers(); //save Map to file. 
		
	}	
}
