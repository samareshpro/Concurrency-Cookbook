/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * @author mrsamaresh
 *
 */
public class WriterTask implements Runnable {
	private Deque<Event> queue;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			Event event = new Event(new Date(),
					Thread.currentThread().getName() + "" + Thread.currentThread().getState());
			queue.addFirst(event);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				System.out.printf("%s has been interrupted.", Thread.currentThread().getName());
			}
		}
	}

	public WriterTask(Deque<Event> queue) {
		super();
		this.queue = queue;
	}

}
