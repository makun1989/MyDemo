package com.makun.chapter16;

import java.util.Arrays;

public class FillingArray {	
	public static void main(String[] args) {
		String[] a=new String[10];
		StringBuilder b=new StringBuilder();
		b.append("oh,");
		Arrays.fill(a, b.toString());
		System.out.println(Arrays.toString(a));
		b.append("mygod");
		a[3]=b.toString();
		System.out.println(a[1]==a[5]);
	}
}
