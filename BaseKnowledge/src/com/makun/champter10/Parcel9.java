package com.makun.champter10;

import com.makun.champter10.interfaceDe.Destination;

public class Parcel9 {
	public Destination destination(String dest){
		
		
		return new Destination(){
			private String label=dest;
			@Override
			public String readLabel() {
				// TODO Auto-generated method stub
				return label;
			}
			
		};
	}
}
