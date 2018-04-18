/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * @author mrsamaresh
 *
 */
public class MyThreadFactory implements ThreadFactory {
	String name;
	List<String> status;
	int counter;

	public String getStatus() {
		Iterator<String> itr = this.status.iterator();
		StringBuffer buf = new StringBuffer();
		while (itr.hasNext()) {
			buf.append(itr.next());
			buf.append("\n");
		}
		return buf.toString();
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}

	public MyThreadFactory(String name) {
		super();
		this.name = name;
		this.status = new ArrayList<String>();
		this.counter = 0;
	}

	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
	 */
	@Override
	public Thread newThread(Runnable obj) {
		Thread thread = new Thread(name+" _ Thread - "+counter);
		counter++;
		StringBuffer buf = new StringBuffer();
		buf.append("Created Thread with name : ");
		buf.append(thread.getName());
		buf.append(" With Id ").append(thread.getId());
		buf.append(" At ").append(new Date());
		status.add(buf.toString());
		return thread;
	}

}
