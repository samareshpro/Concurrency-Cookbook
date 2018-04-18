/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

/**
 * @author mrsamaresh
 *
 */
public class MyThreadFactoryMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThreadFactoryTask task = new MyThreadFactoryTask();
		MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
		for (int i = 0; i < 10; i++) {
			Thread thread = factory.newThread(task);
			thread.start();
		}
		System.out.println("Printing the MyThreadFactory Status");
		System.out.println(factory.getStatus());
	}

}
