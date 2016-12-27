package com.makun.chapter21;

import java.util.concurrent.TimeUnit;


//演示守护线程与普通线程的区别.
public class DaemonNotRunFinally {
	public static void main(String[] args) throws Exception{
		Thread t =new Thread (new ADaemon());
		t.setDaemon(true);
		t.start();
		TimeUnit.MILLISECONDS.sleep(100);
	}
}	

class ADaemon implements Runnable{

	@Override
	public void run() {
		try{
			System.out.println("start ADaemon...");
			TimeUnit.SECONDS.sleep(1);
		}catch(InterruptedException e){
			System.out.println("interrupted with some exception.");
		}finally{
			System.out.println("the finally block.");
		}
	}
	
}