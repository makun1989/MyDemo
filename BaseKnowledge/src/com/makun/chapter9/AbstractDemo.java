package com.makun.chapter9;

public class AbstractDemo {
	public static void main(String[] args) {
		Rodent rodent = new Rodent(){
		
		};
		System.out.println(rodent.i);
	}
}


abstract class Rodent{
	int i=10;
}