package com.makun.champter10;

import org.junit.Test;

import com.makun.champter10.interfaceDe.Contents;
import com.makun.champter10.interfaceDe.Destination;

public class TestParcel {
	@Test
	public void test(){
		//Parcel4 显示了内部类作用的范围以及调用的方法.
		
		Contents.StaticInner inner=new Contents.StaticInner();
		System.out.println(inner.getStr());
		
//		Parcel4 p=new Parcel4();
//		Contents c=p.contents();
//		Destination d=p.destination("China;");
	}
}
