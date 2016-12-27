package com.makun.chapter10;

import com.makun.chapter10.interfaceDe.Destination;

public class Parcel5 {
	//演示定义在方法内部的内部类.
	public Destination destination(String s) {
		class PDestination implements Destination {
			private String label;

			private PDestination(String label) {
				this.label = label;
			}

			@Override
			public String readLabel() {
				// TODO Auto-generated method stub
				return label;
			}

		}

		return new PDestination(s);
	}
	
	public static void main(String[] args) {
		Parcel5 p=new Parcel5();
		p.destination("alabama");
	}
}
