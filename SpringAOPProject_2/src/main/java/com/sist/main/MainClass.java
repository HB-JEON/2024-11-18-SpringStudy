package com.sist.main;
// Proxy => 대리자 => AOP
/*
     프로그램 => 핵심 코드
                -------
                 부가적인 코드 => 모아서 관리 => 공통모듈 / AOP
                  | 데이터베이스 연결 / 데이터베이스 해제
                    보안(인가 => 인증)
                    트랜잭션 => commit / rollback
                    로깅
                    파일 입출력
                 ----------------------------------- AOP 라이브러리
                  | 사용자 정의 AOP
                    ------------- 인터셉트(자동 로그인), AOP
     중복 제거 => 메소드화 처리
     ---------------------- CallBack
      AOP의 개념
       1. Aspect : 공통적으로 적용되는 기능을 모아둔 장소 => 공통 모듈
       2. Target : 적용하는 장소 => 모아주는 역할(위빙)
       3. Advice : 어디에 어떤 기능을 추가할 지
                   JoinPoint + PointCut
       4. JoinPoint : 시점 => 어디서 호출
                      Before
                      After
                      After-Returning
                      After-Throwing
                      Around
                      
                      public void display()
                      {
                      	Before => try 진입 전
                      	  try
                      	  {
                      	    --------- Around start
                      	     => 로깅
                      	     => 어떤 메소드를 요청
                      	     => setAutoCommit(false)
                      	     핵심 코드 => 메소드 호출
                      	    --------- Around end
                      	     => 걸린 시간 확인
                      	  }
                      	  catch(Exception e)
                      	  {
                      	    After-Throwing => 오류발생 시 처리
                      	  }
                      	  finally
                      	  {
                      	    After => 무조건 수행
                      	  }
                      	  return => After-Returning => 정상수행 시
                      }
       5. PointCut : 어떤 메소드 => execution("리턴형 패키지.클래스명.메소드명(..)")
                                               *                 | 매개변수가 0개 이상
                                                                
             => 메소드에 공통 적용하는 소스를 모아둠 : Aspect
             -------------------------------------------------
             => 메소드가 호출될 때
             => 메소드를 어떤 위치에 적용할지를 설정
             ------------------------------------------------- Advice
                                  --- Weaving
             => include와 동일 : 실행마다 수행
 */
public class MainClass {
	public static void main(String[] args) {
		My m=new My();
		m.excute();
		
		MyTarget mt=new MyTarget(m);
		mt.execute();
	}
}
