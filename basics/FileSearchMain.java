package com.samsoft.cookbook.concurrency.basics;

import java.util.concurrent.TimeUnit;

public class FileSearchMain {

	public static void main(String[] args) {
		String fileName ="api-ms-win-core-console-l1-1-0.dll";
		String filePath = "C:\\Program Files\\";
		
		FileSearch fileSearcher = new FileSearch(fileName, filePath);
		Thread thread = new Thread(fileSearcher);
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}

}


//String fileName ="Collabera Contact Details";
//String filePath = "C:\\Program Files\\Java\\jre1.8.0_151\\bin";