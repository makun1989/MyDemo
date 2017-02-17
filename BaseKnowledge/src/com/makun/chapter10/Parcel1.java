package com.makun.chapter10;

import java.util.ArrayList;
import java.util.LinkedList;

public class Parcel1 {
	class Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	class Destination {

		private  String label;

		public Destination(String whereTo) {
			new ArrayList();
			new LinkedList();
			
			label = whereTo;
		}

		public String readLabel() {
			return label;
		}
	}

	public void ship(String dest) {
		Contents contents = new Contents();
		Destination destination = new Destination(dest);
		System.out.println(destination.readLabel());
	}

	public static void main(String[] args) {
		Parcel1 p = new Parcel1();
		p.ship("California");
	}

}

