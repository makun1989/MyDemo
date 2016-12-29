package com.makun.chapter21;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author makun
 * 模拟进行异常捕获.(在多线程中)
 *
 */
public class CaptureUncaughtException {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool(new HandlerThreadFactory(new MyUncaughtExceptionHandler()));
		executor.execute(new ExceptionThread());
		
	}
}

class ExceptionThread2 implements Runnable{

	@Override
	public void run() {
		Thread t=Thread.currentThread();
		System.out.println("run() by"+t.getName());
		System.out.println("eh="+t.getUncaughtExceptionHandler());
		throw new RuntimeException();
	}
	
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("caught:"+e);
		
	}
	
}

class HandlerThreadFactory implements ThreadFactory{
	UncaughtExceptionHandler e;
	public HandlerThreadFactory(UncaughtExceptionHandler e){
		this.e=e;
	}

	@Override
	public Thread newThread(Runnable r) {
		System.out.println(this+" creating new thread.");
		Thread t=new Thread(r);
		System.out.println("created"+t);
		t.setUncaughtExceptionHandler(e);
		System.out.println("eh-="+t.getUncaughtExceptionHandler());
		return t;
	}
	
}