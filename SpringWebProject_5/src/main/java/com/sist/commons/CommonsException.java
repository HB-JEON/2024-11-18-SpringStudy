package com.sist.commons;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
// 공통 예외처리
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class CommonsException {
	@ExceptionHandler(SQLException.class)
	public void sqlException(SQLException ex)
	{
		System.out.println("========= DB 오류 =========");
		ex.printStackTrace();
	}
	
	@ExceptionHandler(IOException.class)
	public void IOException(IOException ex)
	{
		System.out.println("========= 입출력 오류 =========");
		ex.printStackTrace();
	}
	
	@ExceptionHandler(Exception.class)
	public void Exception(Exception ex)
	{
		System.out.println("========= 입출력 오류 =========");
		ex.printStackTrace();
	}
}
