package com.sist.spring1;
/*
    HelloMain�� Hello�� ���� => ���ռ��� ���� ���α׷�
                               ------------------ 
                                �������� �����
                                ���� �߻� �� �ٸ� Ŭ������ ����
    ������ new ��� X
          --- ���ռ��� ���� ���α׷�
 */
public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello hello=new Hello();
		String msg=hello.seyHello("ȫ�浿");
		System.err.println(msg);
	}

}
