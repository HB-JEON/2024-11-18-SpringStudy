package com.sist.web;
import java.util.*;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatHandler extends TextWebSocketHandler {
	// 1. 접속자 정보 저장
	private Map<String, WebSocketSession> users=new HashMap<String, WebSocketSession>();
	
	// 사용자가 접속한 경우
	// 접속자 정보 => WebSocketSession => IP / PORT
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println(session.getId()+"님이 입장 하였습니다.");
		users.put(session.getId(), session);
	}
	// 문자 메세지 전송
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		for(WebSocketSession ws:users.values())
		{
			ws.sendMessage(message);
		}
	}
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// 오류 처리
		System.out.println(exception.getMessage());
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session.getId()+"님이 퇴장 하였습니다.");
		users.remove(session.getId());
	}
}
