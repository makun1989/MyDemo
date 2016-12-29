package com.makun.chapter21.test;

public class ReadThread extends Thread{
	private boolean ready;
	private int number;
	@Override
	public void run() {
		while(!ready){
			number++;
		}
		System.out.println(ready);
	}
	public void readyOn(){
		ready=true;
		
	}
	
	public static void main(String[] args)throws Exception {
		ReadThread read=new ReadThread();
		read.start();
		Thread.sleep(200);
		read.readyOn();
		System.out.println(read.ready);;
	}
	
}
