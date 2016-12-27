package com.makun.chapter7;

public class InitializeTime {
	private String str;
	public InitializeTime(){
		System.out.println("haha");
		str="abcdefg";
	}
	
	public String s4;
	
	@Override
	public String toString() {
		s4="a demo";
		return str;
	}
	
	public static void main(String[] args) {
		InitializeTime ini=new InitializeTime();
		System.out.println(ini);
	}
}
