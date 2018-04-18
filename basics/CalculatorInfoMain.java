/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

/**
 * @author mrsamaresh
 *
 */
public class CalculatorInfoMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread.State status[] =  new Thread.State[10];
		Thread arrThread[] = new Thread[10];
		for (int i = 0; i < 10; i++) {
			CalculatorInfo info = new CalculatorInfo(i);
			Thread thread = new Thread(info);
			thread.setName("Thread - "+i);
			if (i%2 == 0) {
				thread.setPriority(Thread.MAX_PRIORITY);
			}else {
				thread.setPriority(Thread.MIN_PRIORITY);
			}
			arrThread[i]= thread;
		}
		for (int i = 0; i < arrThread.length; i++) {
			status[i] = arrThread[i].getState();
		}
		try(FileWriter file = new FileWriter(".\\data\\log.txt");
			PrintWriter pw = new PrintWriter(file);	){
			for (int i = 0; i < arrThread.length; i++) {
				arrThread[i].start();
			}
			boolean flag = false;
			while(!flag) {
				for (int i = 0; i < status.length; i++) {
					if (arrThread[i].getState() != status[i]) {
						writeThreadInfo(pw, arrThread[i], status[i]);
						status[i] = arrThread[i].getState();
						
					}
				}
				flag = true;
				for (int i = 0; i < 10; i++) {
					flag = flag && (arrThread[i].getState() == State.TERMINATED);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writeThreadInfo(PrintWriter pw, Thread thread, State state) {
		pw.printf("Main : Name - Id :  %s - %d\n", thread.getName(), thread.getId());
		pw.printf("Main: Priority : %d \n", thread.getPriority());
		pw.printf("Main: Old State - New State : %s - %s\n", state,thread.getState());
		pw.printf("Main: ************************************************\n");
	}

}
