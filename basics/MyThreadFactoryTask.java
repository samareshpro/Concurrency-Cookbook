/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

import java.util.concurrent.TimeUnit;

/**
 * @author mrsamaresh
 *
 */
public class MyThreadFactoryTask implements Runnable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			System.out.printf("%s has been interrupted because %s : %s",Thread.currentThread().getName(),e.getClass(),e.getMessage());
		}
	}

}
