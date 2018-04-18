/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

/**
 * @author mrsamaresh
 *
 */
public class CustomThreadGroupTask implements Runnable {

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		/*int result;
		while (true) {
			result = (int) (100/Math.rint(new Random().nextDouble()));
			System.out.printf("%s with result %d \n ",Thread.currentThread().getName(),result);
			boolean interrupted = Thread.currentThread().isInterrupted();
			if (interrupted) {
				System.out.printf("%s has been interrupted \n", Thread.currentThread().getName());
				return;
			}
		}*/
		int result ;
		for (int i = 10; i >=0; i--) {
			result = 100/i;
			System.out.printf("%s with result %d \n ",Thread.currentThread().getName(),result);
			if (Thread.currentThread().isInterrupted()) {
				System.out.printf("%s has been interrupted \n", Thread.currentThread().getName());
				return;
			}
		}
	}

}
