package com.sist.main;

public class MyTarget {
	private My my;
	public MyTarget(My my)
	{
		this.my=my;
	}
	public void execute()
	{
		System.out.println("My 수행 전"); // BEFORE
		my.excute();
		System.out.println("My 수행 후"); // AFTER
	}
}
