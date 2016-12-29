package com.makun.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicityTest implements Runnable{

	private AtomicInteger i=new AtomicInteger(0);
	public int getValue(){
		return i.get();
	}
	
	public synchronized void increment(){
		i.incrementAndGet();
		i.incrementAndGet();
	}
	
	@Override
	public void run() {
		while(true){
			increment();
		}
	}
	
	public static void main(String[] args) {
		AtomicInteger i=new AtomicInteger (10);
		int k=i.addAndGet(3);
		System.out.println(k);
		
		
		ExecutorService executor = Executors.newCachedThreadPool();
		AtomicityTest at=new AtomicityTest();
		executor.execute(at);
		while(true){
			int val=at.getValue();
			if(val%2!=0){
				System.out.println(val);
				System.exit(0);
			}
		}
	}

}
