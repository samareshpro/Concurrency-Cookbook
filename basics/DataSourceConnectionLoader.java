package com.samsoft.cookbook.concurrency.basics;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourceConnectionLoader implements Runnable {

	@Override
	public void run() {
		System.out.printf("The DataSourceConnectionLoader has been started on %s\n",new Date());
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			System.out.printf("%s has been interrupted\n", Thread.currentThread().getName());
		}
		System.out.printf("The DataSourceConnectionLoader has finished the execution at %s \n",new Date());
	}

}
