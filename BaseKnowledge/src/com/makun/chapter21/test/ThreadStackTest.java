package com.makun.chapter21.test;

public class ThreadStackTest {
	
	public static void main(String[] args) {
		printStack(getStackByThread());
		printStack(getStackByException());
	}
	
	private static StackTraceElement[] getStackByThread(){
		return Thread.currentThread().getStackTrace();
	}
	
	private static StackTraceElement[] getStackByException(){
		return new Exception().getStackTrace();
	}
	
	private static void printStack(StackTraceElement []stacks){
		for(StackTraceElement ele:stacks){
			System.out.println(ele);
		}
		System.out.println();
	}
}
