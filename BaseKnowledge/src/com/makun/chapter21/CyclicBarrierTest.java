package com.makun.chapter21;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	private static final int THREAD_COUNT=3;
	private final static CyclicBarrier BARRIER =new CyclicBarrier(THREAD_COUNT, new Runnable(){
		public void run() {
			System.out.println("All is right,let's go next......");
		};
	});
	
	public static void main(String[] args) {
		for(int i=0;i<THREAD_COUNT+4;i++){
			new Thread(String.valueOf(i)){
				public void run() {
					System.out.println("我是线程:"+this.getName()+",到达地点");
					try {
						BARRIER.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
					System.out.println("我是线程:"+this.getName()+",到家");
				};
			}.start();
		}
	}
}
