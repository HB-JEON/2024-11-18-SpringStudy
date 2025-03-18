package com.sist.spring1;
/*
    HelloMain은 Hello에 의존 => 결합성이 강한 프로그램
                               ------------------ 
                                유지보수 어려움
                                에러 발생 시 다른 클래스에 영향
    가급적 new 사용 X
          --- 결합성이 높은 프로그램
 */
public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello hello=new Hello();
		String msg=hello.seyHello("홍길동");
		System.err.println(msg);
	}

}
