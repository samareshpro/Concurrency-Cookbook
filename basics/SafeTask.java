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
public class SafeTask implements Runnable {
	private ThreadLocal<Date> time = new ThreadLocal<>() {
		@Override
		protected Date initialValue() {
			return new Date();
		}
	};
			

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.printf("The %s has been started at %s \n", Thread.currentThread().getName(),time.get());
		try {
			TimeUnit.SECONDS.sleep((long) Math.rint(Math.random()));
		} catch (InterruptedException e) {
			System.out.printf("The %s has been interrupted because of %s : %s \n", Thread.currentThread().getName(),e.getClass(),e.getMessage());
		}
		System.out.printf("The %s started at %s has finished it's execution \n", Thread.currentThread().getName(),time.get());
	}

}
