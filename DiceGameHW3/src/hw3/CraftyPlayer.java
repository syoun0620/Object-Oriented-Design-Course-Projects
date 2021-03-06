package hw3;

@SuppressWarnings("serial")
public class CraftyPlayer extends Player {
	public CraftyPlayer(String name){
		super(name);
	}
	public String getType(){
		return "Crafty Bot";
	}
	public boolean decide(int maxChipAmongPlayers, int chipsInPot){
		// TRUE - if keep going. FALSE - if stop and take the pot. 
		if (this.numChip + chipsInPot > maxChipAmongPlayers){
			return false;
		}
		return true;
	}
}
