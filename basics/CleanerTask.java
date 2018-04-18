/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

import java.util.Date;
import java.util.Deque;

/**
 * @author mrsamaresh
 *
 */
public class CleanerTask extends Thread {
	private Deque<Event> queue;

	public CleanerTask(Deque<Event> queue) {
		super();
		this.queue = queue;
		setDaemon(true);
	}

	@Override
	public void run() {
		super.run();
		while (true) {
			Date date = new Date();
			clean(date);
		}
	}

	private void clean(Date date) {
		if (queue.size() ==0) {
			return;
		}
		boolean delete = false;
		long timeDifference=0;
		do {
			if (queue.size()>0) {
				timeDifference = date.getTime() - queue.getLast().getDate().getTime();
				if (timeDifference > 10000) {
					System.out.printf("Cleaner : %s \n",queue.getLast().getState());
					queue.removeLast();
					delete = true;
				}
			}
		}while(timeDifference>10000);
		if (delete) {
			System.out.printf("Cleaner : Size of the Queue - %s \n",queue.size());
		}
		
	}
	
	
}
