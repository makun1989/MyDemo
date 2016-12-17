package com.makun.champter5;

import java.util.Arrays;

public class NewVarArgs {
	public static void main(String[] args) {
		int[] a=new int[]{
				2,3,454,22,new Integer(30)
		};
		System.out.println(a.length);
		int x=new Integer(3);
		int y=new Integer(20);
		Integer[] integer=new Integer[]{
				32,94
		};
		
//		printArray((int[])a);
		printLength('c');
		printLength();
	}
	private static void printArray(Object... objects){
		for(int i=0;i<objects.length;i++){
			System.out.println(Arrays.toString((int[]) objects[i]));
		}
	}
	
	private static void printLength(Character...args ){
		System.out.println(args.getClass()+":"+args.length);
	}
	
	private static void parseConvert(Integer...integers ){
		for(Integer i:integers){
			System.out.println(i);
		}
	}
}
