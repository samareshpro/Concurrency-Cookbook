/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * @author mrsamaresh
 *
 */
public class CustomUncaughtExceptionHandler implements UncaughtExceptionHandler {

	/* (non-Javadoc)
	 * @see java.lang.Thread.UncaughtExceptionHandler#uncaughtException(java.lang.Thread, java.lang.Throwable)
	 */
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		System.out.println("===================================================================");
		System.out.printf("An Exception has occured by %s \n",thread.getName());
		System.out.printf("Exception name : %s and reason : %s \n",ex.getMessage(),ex.getClass());
		System.out.printf("Status of the Thread : %s \n",thread.getState());
		System.out.println("Printing Exception Stack");
		ex.printStackTrace(System.out);
		System.out.println("===================================================================");
	}

}
