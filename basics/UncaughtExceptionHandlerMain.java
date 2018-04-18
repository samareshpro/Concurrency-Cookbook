/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

/**
 * @author mrsamaresh
 *
 */
public class UncaughtExceptionHandlerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CustomUncaughtExceptionHandler handler = new CustomUncaughtExceptionHandler();
		UncaughtExceptionThread uncaughtExceptionThread = new UncaughtExceptionThread();
		Thread thread = new Thread(uncaughtExceptionThread);
		thread.setUncaughtExceptionHandler(handler);
		thread.start();
	}

}
