package com.makun.chapter18;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Blips {
	public static void main(String[] args) {
		
	}
}

class Blip1 implements Externalizable{
	public Blip1(){
		System.out.println("Blip1 Constructor.");
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip1 write Externalizable");
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip1 read Externalizable");
	}
	
}

class Blip2 implements Externalizable{
	Blip2(){
		System.out.println("Blip2 Constructor.");
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip2 write Externalizable");
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip2 read Externalizable");
	}
	
}
