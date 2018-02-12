package hw1;
//import java.util.*;
public class Simulation {
	private static final int SIMULATION_TIME = 100000;
	private DiningHall diningHall;
	public static void main(String[] args){
		DiningHall diningHall = new DiningHall();
		for (int t = 0; t<SIMULATION_TIME; t++){
			diningHall.elapseOneSecond(t);
		}
		
		System.out.println(diningHall.toString());
	}
	
}
