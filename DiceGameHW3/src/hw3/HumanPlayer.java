package hw3;

import java.util.Scanner;

@SuppressWarnings("serial")
public class HumanPlayer extends Player {
	transient private Scanner sc;
	
	public HumanPlayer(String name, Scanner sc){
		super(name);
		this.sc = sc;
	}
	
	public void setScanner(Scanner sc){
		this.sc = sc;
	}
	public String getType(){
		return "Human";
	}
	public boolean decide(int maxChipAmongPlayers, int chipsInPot){
		// TRUE - if keep going. FALSE - if stop and take the pot. 
		System.out.print("Choose an option. 1) Keep going    2) Stop and take the pot.");
		int input = sc.nextInt();
		if (input == 1)
			return true;
		else
			return false;
	}
}
