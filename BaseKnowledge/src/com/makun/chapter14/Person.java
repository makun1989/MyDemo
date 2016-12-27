package com.makun.chapter14;

public class Person {
	public  final String name;
	public final String last;
	public final String address;
	public Person(String name,String last,String address){
		this.name=name;
		this.last=last;
		this.address=address;
	}
	
	public String toString(){
		return name+"	"+last + "	"+address;	
	}
	
	public static class NullPerson extends Person implements Null{

		private NullPerson() {
			super("none", "none", "none");
		}
		public String toString (){
			return "NullPerson";
		}
	}
	public static  final Person NULL=new NullPerson();
}
interface Null{
	
}