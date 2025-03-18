package com.sist.main;
/*
	 <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		   p:driverClassName="oracle.jdbc.driver.OracleDriver"
		   p:url="jdbc:oracle:thin:@localhost:1521:XE"
		   p:username="hr"
		   p:password="happy"
	/>
 */
/*
    map.put("ds", new MyBasicDataSource())
                  ----------------------- getBean("ds")
 */
import org.apache.commons.dbcp.BasicDataSource;

public class MyBasicDataSource extends BasicDataSource{
	public MyBasicDataSource()
	{
		setDriverClassName("oracle.jdbc.driver.OracleDriver");
		setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		setUsername("hr");
		setPassword("happy");
	}
}
