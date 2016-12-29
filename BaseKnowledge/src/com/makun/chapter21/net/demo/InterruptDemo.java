package com.makun.chapter21.net.demo;

public class InterruptDemo extends Thread {
	boolean stop = false;

	public static void main(String args[]) throws Exception {
		InterruptDemo thread = new InterruptDemo();
		System.out.println("Starting thread...");
		thread.start();
		Thread.sleep(3000);
		System.out.println("Interrupting thread...");
		thread.interrupt();
		Thread.sleep(3000);
		System.out.println("Stopping application...");
		System.exit(0);
	}

	public void run() {
		while (!stop) {
			System.out.println("Thread is running...");
			long time = System.currentTimeMillis();
			while ((System.currentTimeMillis() - time < 1000)) {
			}
		}
		System.out.println("Thread exiting under request...");
	}
}
