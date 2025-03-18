package com.sist.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String[] xml={"app-member.xml", "app-sawon.xml", "app-student.xml"};
		ApplicationContext app=new ClassPathXmlApplicationContext("app-*.xml");
		Sawon sa=(Sawon)app.getBean("sa");
		System.out.println(sa.getSabun());
		System.out.println(sa.getName());
		System.out.println(sa.getDept());
		System.out.println("=================");
		Member mem=(Member)app.getBean("mem");
		System.out.println(mem.getMno());
		System.out.println(mem.getName());
		System.out.println(mem.getAddress());
		System.out.println("=================");
		Student std=(Student)app.getBean("std");
		System.out.println(std.getHakbun());
		System.out.println(std.getName());
		System.out.println(std.getSubject());
	}

}
