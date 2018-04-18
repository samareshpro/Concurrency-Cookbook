/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author mrsamaresh
 *
 */
public class UnsafeTask implements Runnable {
	private Date time;

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		time = new Date();
		System.out.printf("The %s has been started %s \n", Thread.currentThread().getName(),time);
		try {
			TimeUnit.SECONDS.sleep((long) Math.rint(Math.random()));
		} catch (InterruptedException e) {
			System.out.printf("The %s has been interrupted because of %s : %s\n",Thread.currentThread().getName(),e.getClass(),e.getMessage());
		}
		System.out.printf("The %s started at %s has finished the execution \n", Thread.currentThread().getName(), time);
	}

}
