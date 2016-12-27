package com.makun.chapter5;

public class InitialValues {
	private InitialValues value;
	private boolean b;
	private char c;
	private byte by;
	private short s;
	private int i;
	private long l;
	private float f;
	private double d;

	public static void main(String[] args) {
		InitialValues val=new InitialValues();
		System.out.println("The value of boolean is:"+val.b);
		System.out.println("The value of char is:"+val.c);
		System.out.println("The value of byte is:"+val.by);
		System.out.println("The value of short is:"+val.s);
		System.out.println("The value of int is:"+val.i);
		System.out.println("The value of long is:"+val.l);
		System.out.println("The value of float is:"+val.f);
		System.out.println("The value of double is:"+val.d);
		System.out.println("The value of InitValues is:"+val.value);
	}
}
