package org.concurrency.callables;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class CallableExample {
	private static final Logger log = Logger.getLogger(CallableExample.class.getName());
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<Integer> task = () -> {
			try {
				TimeUnit.SECONDS.sleep(5);
				return 123;
			}catch(InterruptedException e) {
				throw new IllegalStateException("task interrupted",e);
			}
		};
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task);

		System.out.println("future done? " + future.isDone());

		Integer result = future.get();

		System.out.println("future done? " + future.isDone());
		System.out.print("result: " + result);
	}
}
