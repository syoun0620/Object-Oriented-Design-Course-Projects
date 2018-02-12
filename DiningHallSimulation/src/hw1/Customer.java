package hw1;
//import java.util.*;

public class Customer {
	private int serviceTime;
	private int arrivalTime;
	
	public Customer(int t){
		arrivalTime = t;
		serviceTime = 2*howManyItems() + 10;
	}
	
	private int howManyItems(){
		int n = (int) (Math.random() * 10);
		return n+1;
	}
	
	public int getArrivalTime(){
		return arrivalTime;
	}
	public int getServiceTime(){
		return serviceTime;
	}
	public void elapseOneSecond(){
		serviceTime--;
	}
	
	
}
