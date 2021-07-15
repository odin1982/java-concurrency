package org.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

//APUNTES - The thread never stop CASE 1
public class ExecutorServiceExample2 {
	private static final Logger log = Logger.getLogger(ExecutorServiceExample2.class.getName());
	
	//Case 2:
		
		public static void main(String[] args){
			ExecutorService executor = Executors.newSingleThreadExecutor();
			executor.submit(()->{
				String threadName = Thread.currentThread().getName();
				log.info("Hello " + threadName);
				for(int i=0; i<= 1000000000;i++) {
					try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
			
			
			try {
				log.info("attempt to shutdown executor");
				executor.shutdown();
				// The method waits the specified time to complete all task
				// The executor shuts down softly by waiting a certain amount of time for termination of currently running tasks
				executor.awaitTermination(1, TimeUnit.SECONDS);
			}catch(InterruptedException e) {
				log.warning("task interrupted");
			}finally {
				if(!executor.isTerminated()) {
					log.warning("cancel non-finished tasks");
				}
				executor.shutdownNow();
				log.info("shutdown finished");
			}
		}
}
