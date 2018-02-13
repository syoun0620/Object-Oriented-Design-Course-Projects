package hw3;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Player implements Serializable, Comparable<Player> {
	protected String pname;
	protected int numChip;
	protected int win;
	protected int loss;
	
	protected Player(String pname){
		this.pname = pname;
		this.numChip = 0;
		this.win = 0;
		this.loss = 0;
	}
	
	public void setChipZero(){
		this.numChip = 0;
	}
	public int getChip(){
		return this.numChip;
	}
	public void addChip(int n){
		this.numChip += n;
	}

	public String getPlayerName(){
		return this.pname;
	}
	public String toString(){
		return "Type: " + getType() +", name: " + this.pname + ", numChip: " + this.numChip + ", numWin " + this.win + ", numLoss: " +this.loss + ", win percentage: " +getWinningPercentage() + ". ";
	}
	public void addWin(){
		this.win++;
	}
	public void addLoss(){
		this.loss++;
	}
	public int getWinningPercentage(){
		return (int) (((double)this.win/(this.win + this.loss)) *100);
	}
	public int compareTo(Player p){
		int wp1 = this.getWinningPercentage();
		int wp2 = p.getWinningPercentage();
		if (wp1 == wp2)
			return getPlayerName().compareTo(p.getPlayerName());
		else
			return wp2-wp1;
	}
	
	protected abstract String getType();
	protected abstract boolean decide(int maxChipAmongPlayers, int chipsInPot);
}
