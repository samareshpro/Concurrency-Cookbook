/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

import java.util.Date;

/**
 * @author mrsamaresh
 *
 */
public class LoaderMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataSourceConnectionLoader dsLoader = new DataSourceConnectionLoader();
		NetworkConnectionLoader nwLoader = new NetworkConnectionLoader();
		Thread thread = new Thread(dsLoader,"DataSourceConnectionLoader");
		Thread thread2 = new Thread(nwLoader,"NetworkConnectionLoader");
		thread.start();
		thread2.start();
		try {
			thread.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Main configuration has been loader : %s \n", new Date());
	}

}
