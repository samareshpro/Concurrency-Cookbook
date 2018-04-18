/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

import java.util.concurrent.TimeUnit;

/**
 * @author mrsamaresh
 *
 */
public class PrimeChecker implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		int num=1;
		int count = 0;
		while(true) {
			for (int i = 1; i <= num/2; i++) {
				if(num%i == 0) {
					count++;
				}
			}
			if (count <=1) {
				System.out.printf("%d is a prime number\n",num);
			}
			num++;
			count=0;
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				System.out.printf("%s has been interrupted\n",Thread.currentThread().getName());
				e.printStackTrace();
				return;
			}
		}
	}

}
