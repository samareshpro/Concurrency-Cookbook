/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

import java.util.concurrent.TimeUnit;

/**
 * @author mrsamaresh
 *
 */
public class ThreadLocalMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		UnsafeTask task = new UnsafeTask();
		SafeTask task = new SafeTask();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(task);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
