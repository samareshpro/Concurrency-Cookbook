package com.samsoft.cookbook.concurrency.basics;

public class BasicCalculator implements Runnable {
	public BasicCalculator(int num) {
		this.num = num;
	}
	int num;
	@Override
	public void run() {
		System.out.println("run() : Started");
		for (int i = 0; i <= 10; i++) {
			System.out.printf("%s : %d * %d = %d\n",Thread.currentThread().getName(),num,i, num*i);
		}
		System.out.println("run() : Ended");
	}

}
