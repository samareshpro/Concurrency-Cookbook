/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

/**
 * @author mrsamaresh
 *
 */
public class CustomThreadGroupMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CustomThreadGroup group = new CustomThreadGroup("CustomThreadTaskGroup");
		CustomThreadGroupTask task = new CustomThreadGroupTask();
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(group, task);
			thread.start();
		}
	}

}
