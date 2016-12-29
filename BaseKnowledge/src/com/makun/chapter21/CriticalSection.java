package com.makun.chapter21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CriticalSection {

	public static void main(String[] args) {
		PairManager pman1 = new PairManager1();
		PairManager pman2 = new PairManager2();
		testApproches(pman1, pman2);
	}

	static void testApproches(PairManager pman1, PairManager pman2) {
		ExecutorService exec = Executors.newCachedThreadPool();
		PairManipulator pm1 = new PairManipulator(pman1);
		PairManipulator pm2 = new PairManipulator(pman2);
		PairChecker pchecker1 = new PairChecker(pman1);
		PairChecker pchecker2 = new PairChecker(pman2);
		exec.execute(pm1);
		exec.execute(pm2);
		exec.execute(pchecker1);
		exec.execute(pchecker2);
		try {
			TimeUnit.MICROSECONDS.sleep(500);
		} catch (InterruptedException e) {
			System.out.println("sleep interrupted.");
		}
		System.out.println("pm1:" + pm1 + ",pm2:" + pm2);
		System.exit(0);
	}

}

class Pair {
	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pair() {
		this(0, 0);
	}

	public void incrementX() {
		x++;
	}

	public void incrementY() {
		y++;
	}

	@Override
	public String toString() {
		return "x=" + x + ",y=" + y;
	}

	public class PairValuesNotEqualException extends RuntimeException {
		public PairValuesNotEqualException() {
			super("Pair values not equal:" + Pair.this);
		}
	}

	public void checkState() {
		if (x != y)
			throw new PairValuesNotEqualException();
	}
}

abstract class PairManager {
	AtomicInteger checkCounter = new AtomicInteger(0);
	protected Pair p = new Pair();
	private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

	public synchronized Pair getPair() {
		return new Pair(p.getX(), p.getY());
	}

	public void store(Pair p) {
		storage.add(p);
		try {
			TimeUnit.MILLISECONDS.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public abstract void increment();
}

class PairManager1 extends PairManager {

	@Override
	public synchronized void increment() {
		p.incrementX();
		p.incrementY();
		store(p);
	}

}

class PairManager2 extends PairManager {

	@Override
	public synchronized void increment() {
		Pair temp = null;
		synchronized (this) {
			p.incrementX();
			p.incrementY();
			temp = getPair();
		}
		store(temp);
	}

}

class PairManipulator implements Runnable {
	PairManager pm;

	public PairManipulator(PairManager pm) {
		this.pm = pm;
	}

	@Override
	public void run() {
		while (true) {
			pm.increment();
		}
	}

	@Override
	public String toString() {
		return "pair:" + pm + ",checkCount:" + pm.checkCounter;
	}

}

class PairChecker implements Runnable {
	PairManager pm;

	public PairChecker(PairManager pm) {
		this.pm = pm;
	}

	@Override
	public void run() {
		pm.checkCounter.incrementAndGet();
		pm.getPair().checkState();
	}

}
