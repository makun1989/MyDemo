package com.makun.chapter8;

public class ReturnTypeDemo {

}

class Grain{
	
}

class Wheat extends Grain{
	
}

class Parent{
	public Wheat returnG(){
		return null;
	}
}

class Child extends Parent{
	@Override
	public Wheat returnG(){
		return null;
	}
}