package com.sist.spring2;
/*
     A <=> B
     A <=> I <=> B
           -
           인터페이스가 오류가 나면
           인터페이스와 관련된 모든 클래스가 오류
           -------- 고정하여 사용
     => 결합성이 낮은 프로그램을 구현
        ------------------- 세미나 => 발표자(로드존슨)
                                           ------ Open Source
                                                  -----------
                                                  Spring.io
                                                  ---------
                                                   발전 : 2.5
        웹 로직 / 웹 스페어 => 툴 사용 : 
 */
public interface Hello {
	public String sayHello(String name);
}
