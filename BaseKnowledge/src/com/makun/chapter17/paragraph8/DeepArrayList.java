package com.makun.chapter17.paragraph8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class DeepArrayList {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
		/**会报一个ConcurrentModificationException异常,因为
		 * .next()必须在.remove()之前调用。在一个foreach循环中，编译器会使.next()在删除元素之后被调用，
		 * 因此就会抛出ConcurrentModificationException异常，你也许希望看一下ArrayList.iterator()
		 * 的源代码。
		 */
		for (String str : list) {
			if (str.equals("a"))
				list.remove(str);
		}
		
		new HashSet();
		/**
		 * 正确的写法是如下所示:
		 */
//		ArrayList<String> list = new ArrayList<String>(Arrays.asList("a","b","c","d"));
//		Iterator<String> iter = list.iterator();
//		while(iter.hasNext()){
//		        String s = iter.next();
//		        if(s.equals("a")){
//		            iter.remove();
//		    }
//		}
	}
}
