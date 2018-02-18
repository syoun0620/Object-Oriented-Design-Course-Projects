package hw4;

import java.util.Comparator;

public class CompareByCustsServed implements Comparator<CashRegister> {
	public int compare(CashRegister c1, CashRegister c2) {
		int numCust1 = c1.getNumCustsServed();
		int numCust2 = c2.getNumCustsServed();
//		return numCust2 - numCust1;   // in descending order. 
		return numCust1 - numCust2;   // in ascending order.

	}
}
