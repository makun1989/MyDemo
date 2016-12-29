package com.makun.chapter21;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class AutomicTest {
	public static void main(String[] args) {
		final int loopcount = 10000;
		int threadcount = 10;

		final NonSafeSeq seq1 = new NonSafeSeq();
		final SafeSeq seq2 = new SafeSeq();

		final CountDownLatch l = new CountDownLatch(threadcount);

		for (int i = 0; i < threadcount; ++i) {
			final int index = i;
			new Thread(new Runnable() {

				@Override
				public void run() {
					for (int j = 0; j < loopcount; ++j) {

						seq1.inc();
						seq2.inc();
					}

					System.out.println("finished : " + index);
					l.countDown();

				}
			}).start();
		}

		try {
			l.await();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("both have finished....");

		System.out.println("NonSafeSeq:" + seq1.get());
		System.out.println("SafeSeq with atomic: " + seq2.get());
	}
}

class NonSafeSeq {
	private long count = 0;

	public void inc() {
		count++;
	}

	public long get() {
		return count;
	}
}

class SafeSeq {
	private AtomicLong count = new AtomicLong(0);

	public void inc() {
		count.incrementAndGet();
	}

	public long get() {
		return count.longValue();
	}
}