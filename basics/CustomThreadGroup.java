/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

/**
 * @author mrsamaresh
 *
 */
public class CustomThreadGroup extends ThreadGroup {

	public CustomThreadGroup(String arg0) {
		super(arg0);
	}

	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		super.uncaughtException(thread, ex);
		System.out.printf("%s has raised the excepiton %s - %s\n", thread.getName(),ex.getClass(),ex.getMessage());
		System.out.printf("Status of %s : %s \n", thread.getName(),thread.getState());
		ex.printStackTrace(System.out);
		System.out.println("Terminating the Rest of Threads");
		interrupt();
	}

}
