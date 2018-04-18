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
public class FileClock implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s \n", new Date());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				System.out.printf("%s : has been interrupted", Thread.currentThread().getName());
//				return;
			}
		}
	}

}

/* The scheduler will decide the wheather to stop or not the thread after getting a InterruptedException if we do not mention the return statment or throw any exception*/