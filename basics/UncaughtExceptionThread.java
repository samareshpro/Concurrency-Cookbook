/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

/**
 * @author mrsamaresh
 *
 */
public class UncaughtExceptionThread implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Integer.parseInt("TT");
	}

}
