package com.makun.chapter9;

import java.util.Arrays;


//面向抽象类的编程,典型的策略模式
public class ProcessDemo {
	public static String s="welcome to china.";
	public static void main(String[] args) {
		doSom(new UpperCase(),s);
		doSom(new LowerCase(),s);
		doSom(new SplitCase(),s);
		
	}
	private static void doSom(Processor processor,String s){
		System.out.println("The class is:"+processor.name());
		System.out.println("The result is:"+processor.process(s));
	}
}


class Processor{
	public String name(){
		return this.getClass().getSimpleName();
	}
	
	public Object process(Object obj){
		return obj;
	}
}

class UpperCase extends Processor{
	@Override
	public String process(Object obj){
		return ((String) obj).toUpperCase();
	}
}

class LowerCase extends Processor{
	@Override
	public String process(Object obj){
		return ((String) obj).toLowerCase();
	}
}


class SplitCase extends Processor{
	@Override
	public String process(Object obj){
		return Arrays.toString(((String)obj).split(" "));
	}
}











