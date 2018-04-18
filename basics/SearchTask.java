/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author mrsamaresh
 *
 */
public class SearchTask implements Runnable {
	private Result result;
	public SearchTask(Result result) {
		super();
		this.result = result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		result.setName(name);
		System.out.printf("%s started at %s \n",name, new Date());
		doTask();
		System.out.printf("%s ended at %s \n", name, new Date());
	}
	private void doTask() {
		Random number = new Random(new Date().getTime());
		try {
			int value = (int) (number.nextDouble()*100);
			System.out.printf("%s : value - %d\n", Thread.currentThread().getName(), value);
			TimeUnit.SECONDS.sleep(value);
		} catch (InterruptedException e) {
			System.out.printf("%s has been interrupted because %s : %s \n",Thread.currentThread().getName(),e.getClass(),e.getMessage());
		}
	}

}
