package hw2;

public interface Player {
	public boolean decide(int maxChipAmongPlayers, int chipsInPot);
	public int getChip();
	public void addChip(int n);
	public int getPlayerId();
	public String toString();
}
