package com.sist.spring3;

public class MainClass {
	public static void main(String[] args) {
		Container c=new Container();
		A a=(A)c.getBean("a");
		System.err.println("a="+a);
		a.sayHello();
		A a1=(A)c.getBean("a");
		System.err.println("a1="+a1);
		a1.sayHello();
	}
}
