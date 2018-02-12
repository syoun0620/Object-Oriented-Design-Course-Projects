package hw3;

@SuppressWarnings("serial")
public class TimidPlayer extends Player {
	public TimidPlayer(String name){
		super(name);
	}
	public String getType(){
		return "Timid Bot";
	}
	public boolean decide(int maxChipAmongPlayers, int chipsInPot){
		// TRUE - if keep going. FALSE - if stop and take the pot. 
		
		return false; // always return false for TimidPlayer. 
	}
}
