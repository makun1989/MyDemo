package com.makun.chapter21;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Daemons {
	public static void main(String[] args) throws InterruptedException {
		Lock lock;
		Thread d=new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		System.out.println("d.isDaemon()="+d.isDaemon()+".");
		TimeUnit.SECONDS.sleep(1);
	}
}

class Daemon implements Runnable{
	private Thread[] t = new Thread[10];
	
	@Override
	public void run() {
		for(int i=0;i<t.length;i++){
			t[i] =new Thread(new DaemonSpawn());
			t[i].start();
			System.out.println("DaemonSpawn"+ i + "started.");
		}
		for(int i=0;i<t.length;i++){
			System.out.println("t["+i+"].isDaemon()="+t[i].isDaemon()+".");
		}
		while(true){
			Thread.yield();
		}
	}
	
}


class DaemonSpawn implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			Thread.yield();
		}
	}
	
}