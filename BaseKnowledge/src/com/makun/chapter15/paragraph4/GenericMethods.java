package com.makun.chapter15.paragraph4;

public class GenericMethods {
	public <T> void f(T x){
		System.out.println(x.getClass().getName());
	}
	
	public static void main(String[] args) {
		GenericMethods m=new GenericMethods();
		m.f(22);
		m.f("sss");
		m.f(m);
		m.f(1.0f);
	}
}
