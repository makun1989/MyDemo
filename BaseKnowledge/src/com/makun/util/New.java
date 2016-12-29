package com.makun.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class New {
	public static <K,V> Map<K,V> map(){
		return new HashMap<K,V>();
	}
	
	public static <T> ArrayList<T> arrayList(){
		return new ArrayList<T>();
	}
	
}
