package com.makun.chapter20;

@DBTable(name = "MEMBER")
public class Member {
	@SqlString(30)
	String firstName;

	@SqlString(50)
	String lastName;

	@SqlInteger
	Integer age;

	@SqlString(value = 30, constraints = @Constraints(primaryKey = true) )
	String handler;

	static int memberCount;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Integer getAge() {
		return age;
	}

	public String getHandler() {
		return handler;
	}

	@Override
	public String toString() {
		return handler   ;
	}

}
