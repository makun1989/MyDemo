package com.makun.chapter21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalVariableHolder {
	static ThreadLocal<Integer> value=new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return new Random().nextInt(10);
		};
	};
	public static void increment(){
		value.set(value.get()+1);
	}
	public static Integer get(){
		return value.get();
	}
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=0;i<3;i++){
			exec.submit(new Accessors(i));
		}
		Thread.sleep(4);
		exec.shutdownNow();
	}

}

class Accessors implements Runnable{
	private final int id;
	public Accessors(int id){
		this.id=id;
	}
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()){
			ThreadLocalVariableHolder.increment();
			System.out.println(Thread.currentThread().getName()+" : "+ThreadLocalVariableHolder.get());
			Thread.yield();
		}
	}
	
	
}


