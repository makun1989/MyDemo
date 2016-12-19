package com.makun.chapter8;

public class Frog {

}

class Characteristic{
	private String s;
	public Characteristic(String s){
		this.s=s;
		System.out.println("createing characteristic : "+s);
	}
	protected void dispose(){
		System.out.println("disposing characteristic : "+s);
	}
}


class Description{
	private String d;
	public Description(String d){
		this.d=d;
		System.out.println("createing description : "+d);
	}
	protected void dispose(){
		System.out.println("disposing description : "+d);
	}
}

class LivingCreature{
	Characteristic cha=new Characteristic("is alive.");
	Description de=new Description("Basic living creature.");
	public LivingCreature(){
		System.out.println("LivingCreature()");
	}
	protected void dispose(){
		System.out.println("LivingCreature dispose.");
		cha.dispose();
		de.dispose();
	}
}

class Animal extends LivingCreature{
	Characteristic cha=new Characteristic("has heart.");
	Description de=new Description("Living in water.");
	public Animal(){
		System.out.println("Animal()");
	}
	
	protected void dispose(){
		System.out.println("Animal dispose.");
		cha.dispose();
		de.dispose();
		super.dispose();
	}
}