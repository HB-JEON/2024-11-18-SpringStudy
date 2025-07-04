package com.sist.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.Setter;

public class LoginFailureHandler implements AuthenticationFailureHandler {
	@Setter
	private String defaultFailureUrl;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String errorMsg="";
		try
		{
			if(exception instanceof BadCredentialsException)
			{
				errorMsg="아이디 및 비밀번호를 확인 해주세요.";
			}
			else if(exception instanceof DisabledException)
			{
				errorMsg="휴면 계정 입니다.";
			}
		}catch(Exception e) {}
		request.setAttribute("message", errorMsg);
		request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
	}
}
