/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

import java.util.concurrent.TimeUnit;

/**
 * @author mrsamaresh
 *
 */
public class SearchTaskMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Result result = new Result();
		ThreadGroup group = new ThreadGroup("SearchTaskGroup");
		SearchTask searchTask = new SearchTask(result);
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(group,searchTask);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Active Thread count : %s \n",group.activeCount());
		System.out.println("Information about Thread Group : ");
		group.list();
		Thread[] threads = new Thread[group.activeCount()];
		group.enumerate(threads);
		for (int i = 0; i < threads.length; i++) {
			System.out.printf("%s - %s\n ", threads[i].getName(),threads[i].getState());
		}
		waitFinish(group);
		group.interrupt();
	}

	private static void waitFinish(ThreadGroup group) {
		while (group.activeCount()>9) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
