/**
 * 
 */
package com.samsoft.cookbook.concurrency.basics;

import java.io.File;

/**
 * @author mrsamaresh
 *
 */
public class FileSearch implements Runnable {
	String fileName, filePath;
	File file;
	public FileSearch(String fileName, String filePath) {
		this.fileName = fileName;
		this.filePath = filePath;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		file = new File(filePath);
		if (file.isDirectory()) {
			try {
				processDirectory(file);
			} catch (InterruptedException e) {
				System.out.printf("%s has been interrrupted \n", Thread.currentThread().getName());
			}
		}
	}

	private void processDirectory(File file)throws InterruptedException {
		File[] lstFile = file.listFiles();
		if(null != lstFile) {
			for (int i = 0; i < lstFile.length; i++) {
				File tempFile = lstFile[i];
				if (tempFile.isDirectory()) {
					processDirectory(tempFile);
				}else {
					processFile(tempFile);
				}
			}
		}
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}

	private void processFile(File tempFile) throws InterruptedException {
		if (tempFile.getName().equalsIgnoreCase(this.fileName)) {
			System.out.printf("%s : found the file %s on path %s \n", Thread.currentThread().getName(),tempFile.getName(),tempFile.getAbsolutePath());
		}
		if (Thread.interrupted()) {
			throw new InterruptedException();
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	

}
