package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
// XML 대신 사용
/*
    <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
	<mvc:annotation-driven></mvc:annotation-driven>
    <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver"
     	p:prefix="/"
      	p:suffix=".jsp" 
    />
 */
@Configuration // 자동 메모리 할당
// <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
@EnableAspectJAutoProxy
// <mvc:annotation-driven></mvc:annotation-driven>
@ComponentScan(basePackages = {"com.sist.*"})
// <mybatis-spring:scan base-package="com.sist.mapper" factory-ref="ssf"/>
@MapperScan(basePackages = {"com.sist.mapper"})
// <tx:annotation-driven/>
@EnableTransactionManagement
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
	
	// HandlerMapping, HandlerAdapter 초기화
	/*
	                                                        | @GetMapping(URI)    
	                                                        | @PostMapping(URI)    
	    요청(*.do) === DispatcherServlet === HandlerMapping === Model(@Controller, @RestController) <=> DAO
	                                                               | request / model
	                                                           DispatcherServlet
	                                                               | JSP 역할 => return "main/main"
	                                                           ViewResolver
	                                                               | request
	                                                              JSP
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	/*
	   <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver"
     	 p:prefix="/"
      	 p:suffix=".jsp" 
       />
	 */
	@Bean("viewResolver")
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver ir=new InternalResourceViewResolver();
		ir.setPrefix("/");
		ir.setSuffix(".jsp");
		return ir;
	}
	/*
	    <util:properties id="db" location="/WEB-INF/config/db.properties"/>
	    <!-- MyBatis 전송 : SqlSessionFactoruBean -->
	    <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
	    	p:driverClassName="#{db['driver']}"
	    	p:url="#{db['url']}"
	    	p:username="#{db['username']}"
	    	p:password="#{db['password']}"
	    />
	     <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
	     	p:dataSource-ref="ds"
	     />
	 */
	// BasicDataSource
	@Bean("ds")
	public DataSource dataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	// sqlSessionFactory
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	// Transaction
	@Bean("transactionManager")
	public PlatformTransactionManager transactionManager()
	{
		DataSourceTransactionManager tx=new DataSourceTransactionManager();
		tx.setDataSource(dataSource());
		return tx;
	}
	// Mapping
}
