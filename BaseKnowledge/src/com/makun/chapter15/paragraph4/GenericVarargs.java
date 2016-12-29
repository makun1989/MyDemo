package com.makun.chapter15.paragraph4;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargs {
	public static  <T> List<T> makeList(T... args){
		List<T> list =new ArrayList<T>();
		for(T item: args){
			list.add(item);
		}
		return list;
	}
	
	public static void main(String[] args) {
		List<String> list = makeList("a");
		System.out.println(list);
	}
}
