package com.makun.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenGenerator extends IntGenerator{
	private int currentEvenValue=0;
	@Override
	public synchronized int next() {
		++currentEvenValue;
		++currentEvenValue;
		return currentEvenValue;
	}
	
	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator());
	}

}

abstract class IntGenerator {
	private volatile boolean canceled = false;

	public abstract int next();

	public void cancel() {
		canceled = true;
	}

	public boolean isCanceled() {
		return canceled;
	}
}

class EvenChecker implements Runnable {
	private IntGenerator generator;
	private final int id;

	public EvenChecker(IntGenerator generator, int id) {
		this.generator = generator;
		this.id = id;

	}

	@Override
	public void run() {
		while (!generator.isCanceled()) {
			int val = generator.next();
			if (val % 2 != 0) {
				System.out.println(val + " is not even.");
				generator.cancel();
			}
		}
	}

	public static void test(IntGenerator generator, int count) {
		System.out.println("Press ctrl c to stop.");
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++) {
			executor.execute(new EvenChecker(generator, count));
		}
		executor.shutdown();
	}

	public static void test(IntGenerator generator) {
		test(generator, 10);
	}

}