package org.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

//APUNTES - The thread never stop CASE 1
public class ExecutorServiceExample {
	private static final Logger log = Logger.getLogger(ExecutorServiceExample.class.getName());
	
	//Case 1: The thread never stop you can see it in the Console
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(()->{
			String threadName = Thread.currentThread().getName();
			log.info("Hello " + threadName);
		});
		//Espera a que terminen todas las tareas y da de baja el executor
		//shutdownNow = Interrumpe las tareas y da de baja el executor
		executor.shutdown();
		
	}
	
	
	
	
}
