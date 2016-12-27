package com.makun.chapter10;

import com.makun.chapter10.interfaceDe.Contents;

public class Parcel6 {
	//这个例子列举了一个定义在方法中的内部类.
	private Object doSomething(){
		if(true){
			class MyDemo{
				private String name;
				public String getName(){
					return name;
				}
			}
			MyDemo demo=new MyDemo();
			return demo;
		}else{
			return null;
		}
	}
	
	//演示了返回一个匿名内部类.
	private Contents doAnything(){
		return new Contents(){
			String value="abc";
			@Override
			public int value() {
				// TODO Auto-generated method stub
				return value.length();
			}
			
		};
	}
}
