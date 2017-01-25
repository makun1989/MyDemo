package com.makun.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AddingGroups {
	public static void main(String[] args) {
		Collection<Integer> collection =new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		Integer[] more ={6,7,8,9};
		//collection.addAll(Arrays.asList(more));
		Collections.addAll(collection, more);
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		List<Integer> subList = list.subList(0, 2);
		System.out.println(subList.size());
		subList.set(0, 200);
		subList.add(33);
		
		Stack s =new Stack();
		System.out.println(list.get(0));
	}
}
