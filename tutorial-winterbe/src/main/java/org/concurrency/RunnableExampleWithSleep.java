package org.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class RunnableExampleWithSleep {
	private final static Logger log = Logger.getLogger(RunnableExampleWithSleep.class.getName());
	public static void main(String[] args) {
		Runnable task = () -> {
			try {
				String threadName = Thread.currentThread().getName();
				log.info("Thread name: " + threadName);
				TimeUnit.SECONDS.sleep(3);
				log.info("Bar " + threadName);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		
		Thread thread = new Thread(task);
		thread.start();
	}
}
