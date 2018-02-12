package hw3;

import java.util.*;

public class HW3PlayerStats {
	static GameConnection conn = new GameConnection("YounDiceGame16");
	static Map<String, Player> playerMap = conn.getMap();
	
	static List<Player> playerL = new ArrayList<Player> (playerMap.values());
	
	public static void main(String[] args){
		Collections.sort(playerL);
		System.out.println("After Sorted");
		
		// print 
		for (Player p: playerL){
			System.out.println(p);
		}
	}
	

	
	
}
