package com.makun.spring.normal;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

public class MyDbTemplate {
	private DataSource dataSource;
	
	public MyDbTemplate(){
		
	}
	
	public MyDbTemplate(DataSource dataSource){
		this.dataSource=dataSource;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void insert(String sql) throws Exception{
		Connection conn = dataSource.getConnection();
		Statement statement = conn.createStatement();
		statement.executeUpdate(sql);
		statement.close();
		conn.close();
	}
	
}
