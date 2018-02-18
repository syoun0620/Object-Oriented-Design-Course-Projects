package hw4;

import java.util.Comparator;

public class CompareByWaitTime implements Comparator<CashRegister> {

	public int compare(CashRegister c1, CashRegister c2) {
		int waitTime1 = c1.avgWaitTime();
		int waitTime2 = c2.avgWaitTime();
//		return waitTime2 - waitTime1;
		return waitTime1 - waitTime2;

	}

}
