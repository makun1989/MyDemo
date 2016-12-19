package com.makun.demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SalaryTest {
	@Test
	public void testInitial(){
		ApplicationContext context=new ClassPathXmlApplicationContext("configApplication.xml");
		SalaryManager bean = (SalaryManager) context.getBean("salaryManager");
		Privilege privilege=(Privilege) context.getBean("privilege");
		privilege.setName("abc");
		bean.showSalary();
	}
}
