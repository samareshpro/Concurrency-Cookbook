/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author mrsamaresh
 *
 */
public class WriterCleanerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Deque<Event> queue = new ArrayDeque<Event>();
		WriterTask writerTask = new WriterTask(queue);
		CleanerTask cleanerTask = new CleanerTask(queue);
		for (int i = 0; i < 3; i++) {
			Thread writer = new Thread(writerTask);
			writer.start();
		}
		Thread cleaner = new Thread(cleanerTask);
		cleaner.start();
	}

}
