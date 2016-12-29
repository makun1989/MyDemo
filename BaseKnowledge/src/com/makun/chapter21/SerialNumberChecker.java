package com.makun.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SerialNumberChecker {
	private static final int SIZE=10;
	private static final CircularSet set=new CircularSet(1000);
	private static final ExecutorService exec=Executors.newCachedThreadPool();
	
	static class SerialChecker implements Runnable{

		@Override
		public void run() {
			while(true){
				int serial = SerialNumberGenerator.getNext();
				if(set.contains(serial)){
					System.out.println("Duplicate:"+serial);
					System.exit(0);
				}
				set.add(serial);
			}
		}
	}
	
	
	public static void main(String[] args) {
		for(int i=0;i<SIZE;i++){
			exec.execute(new SerialChecker());
		}
	}

}

class SerialNumberGenerator{
	private static volatile int serialNumber=0;
	public  static int  getNext(){
		return serialNumber++;
	}
}

class CircularSet{
	private int[] array;
	private int len;
	private int index=0;
	public CircularSet(int len){
		array=new int[len];
		this.len=len;
		for(int i=0;i<len;i++){
			array[i]=-1;
		}
	}
	
	public synchronized void add(int num){
		array[index]=num;
		index=++index%len;
	}
	
	public synchronized boolean contains(int val){
		for(int i=0;i<len;i++){
			if(array[i]==val)
				return true;
		}
		return false;
	}
}


