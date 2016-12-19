package com.makun.spring.normal;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonDaoTest {
	@Test
	public void testNormal() throws Exception{//正常方式测试配置文件的正确性
		ApplicationContext context=new ClassPathXmlApplicationContext("configApplication.xml");
//		PersonDao personDao=(PersonDao) context.getBean("personDao");
//		personDao.savePerson("insert into person(pid,name,description) values (3,'aa','word')");
	}
}
