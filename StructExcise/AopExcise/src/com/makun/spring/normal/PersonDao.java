package com.makun.spring.normal;

public class PersonDao extends MyDbTemplate{
	public void savePerson(String sql) throws Exception{
		this.insert(sql);
	}
}
