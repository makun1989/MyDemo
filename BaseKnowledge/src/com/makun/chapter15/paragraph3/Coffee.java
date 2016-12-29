package com.makun.chapter15.paragraph3;

public class Coffee {
	private static int count =0;
	private int id=count++;
	@Override
	public String toString() {
		
		return getClass().getSimpleName()+"  "+id;
	}
}
