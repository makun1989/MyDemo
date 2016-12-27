package com.makun.chapter10;

import com.makun.chapter10.interfaceDe.Contents;
import com.makun.chapter10.interfaceDe.Destination;

public class Parcel4 {
	private class PContents implements Contents {
		int i = 11;

		@Override
		public int value() {
			return i;
		}

	}

	private class PDestination implements Destination {

		private String label;

		private PDestination(String whereTo) {
			label = whereTo;
		}

		@Override
		public String readLabel() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public Destination destination(String s) {
		return new PDestination(s);
	}

	public Contents contents() {
		return new PContents();
	}

}
