package com.makun;

import org.aspectj.lang.ProceedingJoinPoint;

public class Privilege {
	private String name;
	private String password;

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void determine(ProceedingJoinPoint joinPoint) throws Throwable {
		if (name.equals("abc")) {
			joinPoint.proceed();
		}
	}

}
