package com.makun.chapter21;

public class MoreBasicThreads {
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			new Thread(new LiftOff()).start();
//			System.out.println();
		}
		System.out.println("waiting for liftOff.");
	}
}
