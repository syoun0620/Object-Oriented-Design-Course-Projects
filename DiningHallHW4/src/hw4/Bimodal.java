package hw4;

import java.util.*;

public class Bimodal implements ItemDistribution {
	private int howmanyItems;
	public Bimodal(int n){
		ArrayList<Integer> randomList = new ArrayList<Integer>();
		randomList.add(1);
		randomList.add(n/2);
		randomList.add(n);
		
		howmanyItems = randomList.get((int) (Math.random()*randomList.size()));

	}
	public int getNumItems(){
		return howmanyItems;
	}
}
