package com.makun.chapter7;

public class CloneTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Person p1=new Person();
		p1.setName("haha");
		p1.setAge(22);
		Person p2=(Person) p1.clone();
		System.out.println(p2.getAge()+ p2.getName());
		p2.setName("huhu");

		System.out.println(p1.getAge()+ p1.getName());

		System.out.println(p2.getAge()+ p2.getName());
	}
}

class Person implements Cloneable {
	private String name;
	private int age;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
