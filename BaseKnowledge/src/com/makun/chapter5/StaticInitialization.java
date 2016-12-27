package com.makun.chapter5;

public class StaticInitialization {
	public static void main(String[] args) {
//		System.out.println("creating table in main");
//		new Table();
		new Bench();
		
	}
	
	//static Table table= new Table();
}

class Bench{
	static{
		i=5;
//		System.out.println(i);
	}
	static int i=4;
	
	static{
		System.out.println(i);
	}
	
	static{
		i=6;
	}
}

class Bowl{
	Bowl(int marker){
		System.out.println("Bowl:"+marker);
	}
	void f1(int marker){
		System.out.println("f1():"+marker);
	}
}

class Table{
	static Bowl b1=new Bowl(1);
	Table(){
		System.out.println("Table()");
		b2.f1(2);
	}
	
	void f2(int marker){
		System.out.println("f2():"+marker);
	}
	
	static Bowl b2=new Bowl(2);
}


