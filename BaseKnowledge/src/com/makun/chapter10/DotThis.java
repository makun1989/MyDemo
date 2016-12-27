package com.makun.chapter10;

public class DotThis {
	private String str;
	public DotThis(String str){
		this.str=str;
	}
	
	public void f(){
		System.out.println("DotThis f()"+str);
	}
	
	public class Inner{
		public DotThis outer(){
			return DotThis.this;
		}
	}
	
	public Inner inner(){
		return new Inner();
	}
	
	public static void main(String[] args) {
		DotThis dot =new DotThis("haha");
		DotThis dot1=new DotThis("heihei");
		
		DotThis.Inner in=dot1.new Inner();
		in.outer().f();
	}
}
