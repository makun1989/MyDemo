package com.makun.chapter11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class PrintingContainers {
	private static Collection fill(Collection<String> collection) {
		collection.add("rat");
		collection.add("cat");
		collection.add("mouse");
		collection.add("dog");
		collection.add("rat");
		return collection;
	}
	
	static Map fill(Map<String,String> map){
		map.put("cat" ,"tom");
		map.put("mouse","jerry");
		map.put("dog", "Henry");
		map.put("dog" ,"Jone");
		return map;
	}
	//不同的容器对内部的对象有不同的处理方式.
	public static void main(String[] args) {
		System.out.println(fill(new ArrayList<String>()));
		System.out.println(fill(new LinkedList<String>()));
		
		System.out.println(fill(new HashSet<String>()));
		System.out.println(fill(new TreeSet<String>()));
		System.out.println(fill(new LinkedHashSet<String>()));
		
		System.out.println();
		
		System.out.println(fill(new HashMap<String,String>()));
		System.out.println(fill(new TreeMap<String,String>()));
		System.out.println(fill(new LinkedHashMap<String,String>()));
	}
}
