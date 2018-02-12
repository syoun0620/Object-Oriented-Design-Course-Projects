package hw2;

public class TimidPlayer implements Player {
	private int numChip;
	private int playerId;
	
	public TimidPlayer(int i){
		this.playerId = i;
		this.numChip = 0;
	}
	public boolean decide(int maxChipAmongPlayers, int chipsInPot){
		// true - if keep going. false - if stop and take the pot. 
		
		return false; // always return false for TimidPlayer. 
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
