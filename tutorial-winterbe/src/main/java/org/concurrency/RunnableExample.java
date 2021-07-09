package org.concurrency;

import java.util.logging.Logger;

public class RunnableExample {
	private final static Logger log = Logger.getLogger(RunnableExample.class.getName());
	public static void main(String[] args) {
		Runnable task = () ->{
			String threadName = Thread.currentThread().getName();
			log.info("Hello " +  threadName);
		};
		
		task.run();
		
		Thread thread = new Thread(task);
		thread.start();
		log.info("Done!");
		
	}
}
