/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

/**
 * @author mrsamaresh
 *
 */
public class PrimeCheckerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread obj = new Thread(new PrimeChecker());
		obj.start();
		try {
			Thread.sleep(5000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		obj.interrupt();
	}

}
