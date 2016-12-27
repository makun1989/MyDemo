package com.makun.champter11.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test4 {
	public static void main(String[] args) {
		String[] arr=new String[3];
		fillArray(arr,arr.length);
		List<String> arrList=new ArrayList<String>();
		fill(arrList,6);
		System.out.println(arr);
		System.out.println(arrList);
	}
	private static void fillArray(Object[] a,int length){
		for(int i=0;i<length;i++){
			a[i]=StrGenerator.next();
		}
	};
	private static void fill(Collection c,int number){
		for(int k=0;k<number;k++){
			c.add(StrGenerator.next());
		}
	}
}

class StrGenerator{
	static String[] filmList=new String[]{
			"snow white","recuue","alabama","Kind man","You win"
	};
	private static int count=0;
	public static String next(){
		return filmList[(count++)%filmList.length];
	}
}
