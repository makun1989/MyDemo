package com.makun.chapter21.test;

import java.util.Random;

public class ThreadJoinTest {
	static class Computer extends Thread{
		private int start ,end;
		private int[] array;
		private int result=0;
		private Random random =new Random();
		
		public Computer(int[] array,int start,int end)
		{
			this.array=array;
			this.start=start;
			this.end=end;
		}
		@Override
		public void run() {
			for(int i=start;i<end;i++){
				result+=random.nextInt(5000);
			}
		}
		
		public int getResult(){
			return result;
		}
	}
	
	public static void main(String[] args) throws Exception{
		int[] a = new int[1000000];
		int len=a.length;
		Computer c1=new Computer(a,len/2+1,len);
		Computer c2=new Computer(a,0,len/2);
		c1.start();
		c2.start();
		c1.join();
		c2.join();
		System.out.println(c1.getResult());
		System.out.println(c2.getResult());
		System.out.println(c1.getResult()+c2.getResult());
	}

}
