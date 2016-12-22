package com.makun.chapter14;

import org.junit.Test;

public class ToyTest {
	static void printInfo(Class cc) {
		System.out.println("Class name:" + cc.getName() + ",is interface:" + cc.isInterface());
		System.out.println("Simple name:" + cc.getSimpleName());
		System.out.println("Canonical name:" + cc.getCanonicalName());
		System.out.println();
	}

	public static void main(String[] args) {
		Class cc = null;
		try {
			cc = Class.forName("com.makun.chapter14.FancyToy");
		} catch (ClassNotFoundException e) {
			System.out.println("Fancy toy class not found.");
			System.exit(1);
		}
		printInfo(cc);
		for (Class face : cc.getInterfaces()) {
			printInfo(face);
		}

		Class up = cc.getSuperclass();
		Object obj = null;
		try {
			obj = up.newInstance();
		} catch (InstantiationException e) {
			System.out.println("can't initiate class");
			System.exit(1);
		} catch (IllegalAccessException e) {
			System.out.println("can't access class");
			System.exit(1);
		}
		printInfo(obj.getClass());
	}

	@Test
	public void testSuper() {
		Class cc = null;
		try {
			cc = Class.forName("com.makun.chapter14.Toy");
		} catch (ClassNotFoundException e) {
			System.out.println("Can't initiate class.");
		}
		System.out.println(cc.getSuperclass());
		System.out.println(cc.getSuperclass().getName());
		Class objClass = Object.class;
		System.out.println(objClass.getSuperclass());
	}
	
	@Test 
	public void printClass(){
		Class cc=null;
		try {
			cc=Class.forName("com.makun.chapter14.FancyToy");
		} catch (ClassNotFoundException e) {
			System.out.println("Can't initiate class.");
		}
		while(cc!=null){
			System.out.println(cc.getName());
			cc=cc.getSuperclass();
		}
	}
	
	/**
	 * 验证一个char数组是不是对象
	 * @throws Throwable
	 */
	@Test
	public void testCharArray()throws Throwable{
		char[] charArray=new char[20];
		System.out.println(charArray instanceof Object);
		int i=10;
	}
}

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
	// public Toy(){
	//
	// }
	public Toy(int i) {

	}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
	FancyToy() {
		super(1);
	}
}
