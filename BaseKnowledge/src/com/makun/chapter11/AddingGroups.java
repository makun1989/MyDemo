package com.makun.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class AddingGroups {
	public static void main(String[] args) {
		Collection<Integer> collection =new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		Integer[] more ={6,7,8,9};
		//collection.addAll(Arrays.asList(more));
		Collections.addAll(collection, more);
		System.out.println(collection.size());
	}
}
