package org.concurrency.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class FutureExample {
	private static final Logger log = Logger.getLogger(FutureExample.class.getName());
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<Integer> task = () -> {
			try {
				TimeUnit.SECONDS.sleep(10);
				return 123;
			}catch(InterruptedException e) {
				throw new IllegalStateException("task interrupted",e);
			}
		};
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task);
		
		log.info("future done? " + future.isDone());
		executor.shutdown();
		Integer result = future.get();
		
		log.info("future done? " + future.isDone());
		log.info("result: " + result );
	}
}
