package hw4;

public class Uniform implements ItemDistribution {
	private int howmanyItems;
	public Uniform(int n){
		howmanyItems = 1 + (int)(Math.random() * n);
//		num = n;
	}
	public int getNumItems(){
		return howmanyItems;
	}
}
