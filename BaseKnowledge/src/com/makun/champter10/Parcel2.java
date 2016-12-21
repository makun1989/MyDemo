package com.makun.champter10;

public class Parcel2 {
	class Contents {
		private int i = 11;

		public int value() {
			return i;
		}
	}

	class Destination {

		private String label;

		public Destination(String whereTo) {
			label = whereTo;
		}

		public String readLabel() {
			return label;
		}
	}
	
	public  Destination to(String dest){
		return new Destination(dest);
	}
	
	public Contents contents(){
		return new Contents();
	}
	
	public void ship(String dest){
		Contents c=contents();
		Destination d=to(dest);
		System.out.println(d.readLabel());
	}
	
	public static void main(String[] args) {
		Parcel2 p=new Parcel2();
		p.ship("China");
		
		
		Parcel2 q=new Parcel2();
		Parcel2.Destination d=q.to("henan");
		Parcel2.Contents c=q.contents();
	}
}
