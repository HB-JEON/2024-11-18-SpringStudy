package com.sist.dao;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class MyDataSource {
	private String driver;
	private String url, username, password;
	public MyDataSource()
	{
		setDriver("oracle.jdbc.driver.OracleDriver");
		setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		setUsername("hr");
		setPassword("happy");
	}
}
