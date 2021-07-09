package org.concurrency.callables;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class CallableExample {
	private static final Logger log = Logger.getLogger(CallableExample.class.getName());
	public static void main(String[] args) {
		Callable<Integer> task = () -> {
			try {
				TimeUnit.SECONDS.sleep(10);
				return 123;
			}catch(InterruptedException e) {
				throw new IllegalStateException("task interrupted",e);
			}
		};
		
	}
}
