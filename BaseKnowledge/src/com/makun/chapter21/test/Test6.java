package com.makun.chapter21.test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import com.makun.chapter21.LiftOff;

public class Test6 {
	@Test
	public void testCache() {
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			executor.execute(new LiftOff());
		}
		System.out.println("end");
	}

	@Test
	public void testFixedThreadPool() {
		ExecutorService pool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 5; i++) {
			pool.execute(new LiftOff());
		}
		System.out.println("end");
	}

	@Test
	public void testSinglePool() {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			executor.execute(new LiftOff());
		}
		System.out.println("\nthe end");
	}
	
	@Test
	public void testSleepRandom()throws Exception{
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i=0;i<40;i++){
			executor.execute(new Thread(new MyRunnable()));
		}
		Thread.sleep(10000);
		System.out.println("the end-------------------------");
	}

}

class MyRunnable implements Runnable
{

	@Override
	public void run() {
		try {
			int k=new Random().nextInt(10);
			Thread.sleep(k*1000);
			System.out.println("the thread "+Thread.currentThread().getName()+" has slept :"+k);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
