package com.makun.chapter16;

import java.util.Arrays;

public class CompType implements Comparable<CompType>{
	int i;
	int j;
	private static int count=1;
	public CompType(int i,int j){
		this.i=i;
		this.j=j;
	}
	
	public String toString(){
		String result="[i="+i+",j="+j+"],";
		if(count %3 ==0)
			result+="\n";
		return result;
	}

	@Override
	public int compareTo(CompType o) {
		
		return (i<o.i)?1:(i==o.i?0:-1);
	}
	public static void main(String[] args) {
		CompType[] arr=new CompType[4];
		arr[0]=new CompType(10,3);
		arr[1]=new CompType(6,3);
		arr[2]=new CompType(15,3);
		arr[3]=new CompType(19,3);
		System.out.println("before sorting:");
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("after sorting:");
		System.out.println(Arrays.toString(arr));
	}
}
