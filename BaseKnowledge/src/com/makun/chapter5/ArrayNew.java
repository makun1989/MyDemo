package com.makun.chapter5;

import java.util.Arrays;
import java.util.Random;

public class ArrayNew {
	public static void main(String[] args) {
		int[] raw=new int[new Random().nextInt(33)];
		System.out.println(raw.length);
		System.out.println(raw[3]);
		System.out.println(Arrays.toString(raw));
	}
}	
