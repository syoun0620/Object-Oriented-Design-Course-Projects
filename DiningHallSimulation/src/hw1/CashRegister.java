package hw1;
import java.util.*;
public class CashRegister {
	int customerServed;
	int totalWaitTimes;
	private List<Customer> customers;
	
	public CashRegister(){
		customerServed = 0;
		totalWaitTimes = 0;
		customers = new LinkedList<Customer>();
	}
	
	public void newCustomer(int t){
		customers.add(new Customer(t));
	}
	
	public void elapseOneSecond(int currentTime){
		if (customers.size() == 0)
			return;
					
		if (customers.get(0).getServiceTime() -1 > 0){
			customers.get(0).elapseOneSecond();
		}
		else{ //we are done with the customer
			customerServed++;
			totalWaitTimes += currentTime - customers.get(0).getArrivalTime();
			customers.remove(0);
		}
	}
	public int getSize() {
		return customers.size();
	}
	
	public String toString() {
		String result = "";
		result += "\tNumber of arrivals = " + customerServed +"\n";
		result += "\tAverage wait time = " + totalWaitTimes/customerServed;
		return result;
	}



}
