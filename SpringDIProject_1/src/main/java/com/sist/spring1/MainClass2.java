package com.sist.spring1;
/*
    1. 개발자 => 클래스 메모리 할당 X
                --------------- 모든 클래스의 메모리 할당 요청
                                ---------   ------------- XML, Annotation 이용
                                 관리할 수 있게 제작
                                 ----------------
                                  생성 ~ 소멸
                                  --- 변수의 초기화
                                      메모리 누수 현상 방지
       스프링 클래스 관리자 => 컨테이너
                             경량 => 클래스 간의 연관 관계가 단순
       <bean> => @Bean
       <select> => @Select()
       => DAO
       
       =======================================================================
       Spring => 클래스 관리(컨테이너)
                 --------- 기능만 가지고 있다(컴포넌트)
                  | XML => 동작을 위한 메뉴얼 작업
                    클래스와 클래스의 연관 관계를 설정
                    ---------------------------- DI
                     DI / AOP / 트랜잭션 / MVC
                 컨테이너
                   | DL - 객체 찾기
                     DI - 주입 (초기화가 필요한 변수에 대한 값을 설정)
                           ex) 데이터베이스 연결
                                => 드라이버 / URL / UserName / Password
                                => Security
                           = setter DI
                           = constructor DI
                           -----------------------------------
                           = 생성 시 메소드 : init-method
                           = 소멸 시 메소드 : destory-method
                           ----------------------------------- 메소드 DI
                           객체 찾기 : getBean() / @Autowired
                           -------
                            관리 대상 : Model, DAO, Manager, Service
                            관리 제외 : VO, DTO, Bean => 사용자 정의 데이터형
                                        => int / double...
                     
 */
public class MainClass2 {
	public static void main(String[] args) {
		
	}
}
