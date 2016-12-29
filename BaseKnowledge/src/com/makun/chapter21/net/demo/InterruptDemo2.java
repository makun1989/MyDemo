package com.makun.chapter21.net.demo;

import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class InterruptDemo2 extends Thread{
	volatile boolean stop;

	public static void main(String[] args) throws Exception {
		System.out.println("create a thread...");
		InterruptDemo2 thread = new InterruptDemo2();
		System.out.println("create thread is begin to run.");
		thread.start();
		TimeUnit.SECONDS.sleep(3);
		thread.stop = true;
		TimeUnit.SECONDS.sleep(2);
		InputStreamReader is;
	}

	@Override
	public void run() {
		while (!stop) {
			long now = System.currentTimeMillis();
			while ((System.currentTimeMillis() < now + 1000) && (!stop)) {

			}
			System.out.println("thread created is running");
		}
		System.out.println("Thread created is stopped.");
	}
	
}
