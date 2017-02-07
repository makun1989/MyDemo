package com.makun.chapter11;

import java.util.*;

public class SetDemo {
	public static void main(String[] args) {
		fillAndDisplay(new TreeSet());
		
	}
	public static void fillAndDisplay(Collection collection){
		fillCollection(collection);
		display(collection);
	}
	
	public static void fillCollection(Collection collection){
		collection.add(3);
		collection.add(6);
		collection.add(8);
		collection.add(1);
	}
	public static void display(Collection collection){
		Iterator iterator = collection.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
	}
}
