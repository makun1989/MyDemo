package com.makun.chapter14;

public class Position {
	private String title;
	private Person person;
	
	public Position(String jobTitle , Person employee){
		title = jobTitle;
		person=employee;
		if(person==null)
			person=Person.NULL;
	}
	
	public Position(String title){
		this.title =title;
		this.person =Person.NULL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person=person;
		if(this.person==null)
			this.person=Person.NULL;
	}
	
	
	
}
