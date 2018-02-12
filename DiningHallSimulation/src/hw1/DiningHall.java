package hw1;
//import java.util.*;

public class DiningHall {
	private static final int NUM_REGISTERS = 4;
	private static final int CUST_ARRIVAL_PCT = 15;
	private CashRegister[] cashRegisters;
	
	public DiningHall(){
		cashRegisters = new CashRegister[NUM_REGISTERS];
		for (int i = 0; i<NUM_REGISTERS; i++){
			cashRegisters[i] = new CashRegister();
		}
	}
	
	private static boolean aCustomerArrives(){
		int n = (int) (Math.random() * 100);
		return n < CUST_ARRIVAL_PCT;
	}
	
	public void elapseOneSecond(int currentTime){
		if (aCustomerArrives()){
			int chosenRegister = smallestRegister();
			cashRegisters[chosenRegister].newCustomer(currentTime);
		}
		for (int r = 0; r<NUM_REGISTERS; r++){
			cashRegisters[r].elapseOneSecond(currentTime);
		}
	}
	
	private int smallestRegister(){
		int currentSmallest = 0;
		for (int r = 1; r<NUM_REGISTERS; r++){
			if (cashRegisters[r].getSize() < cashRegisters[currentSmallest].getSize() ){
				currentSmallest = r;
			}
		}
		return currentSmallest;
	}
	public String toString(){
		String result = "";
		for (int r = 0; r<NUM_REGISTERS; r++){
			result += "Register " + r;
			result += "\n" + cashRegisters[r].toString() + "\n";
		}
		return result;
		
	}
}
