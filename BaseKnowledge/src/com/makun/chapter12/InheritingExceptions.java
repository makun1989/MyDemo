package com.makun.chapter12;

public class InheritingExceptions {
	public void f() throws SimpleException{
		System.out.println("throw SimpleException from f()");
		throw new SimpleException();
	}
	public static void main(String[] args) {
		InheritingExceptions ie=new InheritingExceptions();
		try {
			ie.f();
		} catch (SimpleException e) {
			System.out.println("got it!");
		}
	}
}


class SimpleException extends Exception{
	
}