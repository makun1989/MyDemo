package com.makun.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable{
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool(new MyThreadFactory());
		for(int i=0;i<10;i++){
			executorService.execute(new DaemonFromFactory());
		}
		TimeUnit.MILLISECONDS.sleep(1000);
	}
	
	@Override
	public void run() {
		while(true){
			System.out.println(Thread.currentThread()+"  , "+this);
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("interrupted........");
			}
		}
	}

	
}
class MyThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		Thread t=new Thread(r);
		t.setDaemon(true);
		return t;
	}
	
}