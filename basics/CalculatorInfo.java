/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

/**
 * @author mrsamaresh
 *
 */
public class CalculatorInfo implements Runnable {

	/**
	 * 
	 */
	int number;
	public CalculatorInfo(int number) {
		this.number = number;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s : %d * %d = %d \n", Thread.currentThread().getName(), number,i, number*i);
		}
	}

}
