package com.samsoft.cookbook.concurrency.basics;

public class BasicCalculatorMain {

	public static void main(String[] args) {
		System.out.println("main() started");
		new Thread(new BasicCalculator(2)).start();
		new Thread(new BasicCalculator(3)).start();
		System.out.println("main() ended");
	}

}
