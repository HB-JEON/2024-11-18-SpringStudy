package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
    스프링 프레임워크
    --------------
     1. Container : 클래스를 모아서 관리
        BeanFactory
            |
        ApplicationContext : default core(객체 생성 / DI / AOP)
            |
        WebApplicationContext : core(객체 생성 / DI / AOP / MVC)
        
        => GenerricApplicationContext => 닫기(객체 소멸)
        => AnnotationConfigApplicationContext
           => 5버전에서 주로 사용
              ---- 보안에 주력
               등록 : XML => 순수 자바 설정이 가능
                            -------- Boot
        기능
         = 객체 생명주기 관리(생성 ~ 소멸) => 모든 클래스 (VO => 데이터형)
         = 객체 찾기
         = DL(객체 찾기) / DI(변수의 초기화)
                         ---------------
                          1. setter
                          2. contstructor
                          3. method 호출 가능
 */
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app1.xml");
		Sawon sa=(Sawon)app.getBean("sal");
		sa.print();
		
		Sawon sa1=(Sawon)app.getBean("sal2");
		sa1.print();
		
		Sawon sa2=(Sawon)app.getBean("sal3");
		sa2.print();
		
		Sawon sa3=(Sawon)app.getBean("sal4");
		sa3.print();
		
		Sawon sa4=(Sawon)app.getBean("sal5");
		sa4.print();
	}
}
