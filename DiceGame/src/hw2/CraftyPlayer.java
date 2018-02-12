package hw2;

public class CraftyPlayer implements Player {
	private int numChip;
	private int playerId;
	
	public CraftyPlayer(int n){
		this.playerId = n;
		this.numChip = 0;
	}
	public boolean decide(int maxChipAmongPlayers, int chipsInPot){
		// true - if keep going. false - if stop and take the pot. 
		if (this.numChip + chipsInPot > maxChipAmongPlayers){
			return false;
		}
		return true;
	}
	public int getChip(){
		return this.numChip;
	}
	public void addChip(int n){
		this.numChip += n;
	}
	public int getPlayerId(){
		return this.playerId;
	}
	public String toString(){
		return this.playerId + ":" + this.numChip + " ";
	}
}
