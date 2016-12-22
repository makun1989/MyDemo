package com.makun.chapter14;

import org.junit.Test;

public class BoundedClassReference {
	@Test
	public void test(){
		Class<? extends Number> cc=int.class;
	}
}
