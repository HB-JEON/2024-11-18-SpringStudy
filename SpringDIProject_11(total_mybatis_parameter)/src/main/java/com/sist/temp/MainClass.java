package com.sist.temp;

import java.lang.reflect.Method;

class A
{
	public void aaa() {
		System.out.println("A:aaa() Call...");
	}
	public void bbb() {
		System.out.println("A:bbb() Call...");
	}
	public void ccc() {
		System.out.println("A:ccc() Call...");
	}
}
public class MainClass {
	public static void main(String[] args) {
		try
		{
			Class clsNClass=Class.forName("com.sist.temp.A");
			Object obj=clsNClass.getDeclaredConstructor().newInstance();
			Method[] methods=clsNClass.getDeclaredMethods();
			
			methods[0].invoke(obj, null);
			
		}catch(Exception ex) {}
	}
}
