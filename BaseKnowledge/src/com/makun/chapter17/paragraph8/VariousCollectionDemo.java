package com.makun.chapter17.paragraph8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;

public class VariousCollectionDemo {
	public static void main(String[] args) {
		fillAndList(new ArrayList<String>());
		fillAndList(new LinkedList<Integer>());
		fillAndList(new Vector<Long>());
		fillAndList(new HashSet());
		fillAndList(new LinkedHashSet());
		fillAndList(new TreeSet());
	}
	
	private static void fillAndList(Collection c){
		c.add("cat");
		c.add("mouse");
		c.add("dog");
		c.add("mouse");
		Iterator iterator = c.iterator();
		System.out.println(c.getClass().getSimpleName()+" has " + c.size()+" elements:");
		while(iterator.hasNext()){
			String s=(String) iterator.next();
			System.out.print(s+", ");
		}
		System.out.println("\n");
	}
}
