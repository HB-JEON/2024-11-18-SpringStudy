package com.sist.auto;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class Oracle implements DAO{

	@Override
	public void connection() {
		// TODO Auto-generated method stub
		System.out.println("¿À¶óÅ¬ ¿¬°á");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("¿À¶óÅ¬ ÇØÁ¦");
	}

}