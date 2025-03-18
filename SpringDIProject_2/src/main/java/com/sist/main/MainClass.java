package com.sist.main;
/*
     스프링
       => 클래스 관리 영역
          --------- 컨테이너 클래스
                BeanFactory
                     |
                ApplicationContext
                     |------------------- AnnotationConfigApplicationContext
                     |                     => 자바로 등록 => 5버전 이상에서 권장(보안)
                WebpApplicationContext
                
          *** Component : 클래스 한개(기능을 가지고 있는 클래스)
                          JButton / JTexField
                          ~Model / ~Manager / ~DAO => 부품
          *** Container : 조립자 => 클래스를 관리하는 영역
                           => 메인 보드
                 | 클래스 관리
                   ---------
                    1) 객체 생성
                        <bean id="a" class=com.sist.main.A"/>
                          => Class clsName=Class.forName("com.sist.main.A")
                             Object obj=clsName.newInstance()
                              => map.put("a", obj) => 대기상태
                    2) 생성 시에 멤버 변수에 대한 초기화
                       ---------------------------- DI
                        | setXxx() => setter DI
                          생성자 매개변수 => constructor DI
                          생성 시 / 소멸 시에 한 번만 호출 => method DI
                    3) 객체 찾기 => DL => getBean()
                    4) 객체 소멸
                 | 방식 3가지
                    클래스 등록 / DI
                     1) XML : 공통 사용
                     2) Annotation : 개별
                     3) XML+Annotation => 웹 / 실무
                        --- ----------
                        XML - 프로젝트에서 공통 사용되는 부분 / 라이브러리 클래스
                                                           --------------
                                                            MyBatis / Transaction
                        Annotation - 사용자 정의 클래스
                        
             => 공통으로 사용되는 클래스나 메소드를 모아서 관리 : 공통모듈
                 => com.sist.commons
                 => 자동 호출이 가능(AOP)
             => 웹 => MVC
                 => 추가 (Task, Security / Batch / SI / Spring-Data)
             => 프레임워크 VS 라이브러리
                --------    --------
                 | 레고       | 완제품
                    => 기본 동작을 위한 틀이 만들어져있다.
                                      -
                       형식에 맞게 세팅 후 사용
                       --- XML - 속성 / 태그가 이미 만들어져있다. => DTD / 스키마
                           Annotation - 이미 만들어져있다. => @Controller / @RequestMapping
                           라이브러리 추가 : pom.xml / gradle(Spring-Boot)
                           
             스프링에서 제공하는 라이브러리
               = spring-core : Container / DI
               = spring-aop : AOP => 공통 모듈
               = spring-orm : MyBatis / JPA
               = spring-dao : JDBC
               = spring-web / = spring-webmvc
             스프링 사용의 목적
               = 생산성 => 라이브러리의 완성도 / 신뢰성 / 개발 속도
               = 유지보수 / 확장성 => 다른 언어 프로그램과 연동
               = 무료 / 스프링을 변경해서 사용 가능
               = *** 현대 기술에 맞게 라이브러리 제작
                     ------- AI / MSA
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
