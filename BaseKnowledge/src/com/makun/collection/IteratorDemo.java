package com.makun.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorDemo {
	public static void main(String args[]){
		List<String> list=new LinkedList<String>();
		list.add("first");
		list.add("second");
		list.add("third");
		list.add("fourth");
		Iterator<String> iterator=list.iterator();
		while(iterator.hasNext()){
			String str=iterator.next();
			System.out.println(str);
//			if(str.equals("second")){
//				list.add("fifth");
//			}
		}
	}
}
