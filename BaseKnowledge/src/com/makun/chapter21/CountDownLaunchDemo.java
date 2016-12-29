package com.makun.chapter21;

import java.util.concurrent.CountDownLatch;

public class CountDownLaunchDemo {
	public static void main(String[] args) {
		
		 int count=10;
		final CountDownLatch countDown=new CountDownLatch(count);

		for(int i=0;i<count ;++i){
			final int index = i;  
			new Thread(){
				public void run() {
					try {
						Thread.currentThread().sleep(2000);
					} catch (InterruptedException e) {
						System.out.println("Some thing happened in thread :"+Thread.currentThread().getName());
					}
					System.out.println("Thread  finished:"+index+Thread.currentThread().getName());
					countDown.countDown();
				};
			}.start();
		}

		try{
			countDown.await();//是await不是wait.
		}catch(Exception e){
			System.out.println("some error happened in countDown.");
		}

		System.out.println("All the thread has terminated.");
	}
}

