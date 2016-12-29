package com.makun.chapter21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalVariableHolder {
	private static ThreadLocal<Integer> value=new ThreadLocal<Integer>(){
		Random rand=new Random();
		protected synchronized Integer initialValue() {
			return rand.nextInt(500);
		};
	};
	

	public static void increment() {
		value.set(value.get()+1);
	}
	
	public static int get(){
		return value.get();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=0;i<6;i++){
			exec.execute(new Accessors(i));
		}
		TimeUnit.SECONDS.sleep(3);
		
		exec.shutdownNow();
	}

}

class Accessors implements Runnable{
	private final int id;
	public Accessors(int ids){
		id=ids;
	}
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()){
			ThreadLocalVariableHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}
	
	@Override
	public String toString() {
		return "#"+id+";"+ThreadLocalVariableHolder.get();
	}
	
	
}


