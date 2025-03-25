package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.*;
import com.sist.vo.*;
@RestController
// @ResponseBody => 메소드 => Class 형태로 변경
// @ResponseBody // 화면 이동이 아니라 보통 데이터 전송
// => 자바스크립트 전송 가능 => JSON / JavaScript...
public class BoardRestController {
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping(value = "board/update_ok.do", produces = "text/html;charset=UTF-8")
	public String board_update_ok(BoardVO vo)
	{
		String result="";
		boolean bCheck=dao.boardUpdate(vo);
		if(bCheck==true)
		{
			result="<script>"
					+ "location.href=\"detail.do?no="+vo.getNo()+"\""
							+ "</script>";
		}
		else
		{
			result="<script>"
					+ "alert(\"비밀번호를 확인 해주세요.\");"
					+ "history.back();"
					+ "</script>";
		}
		return result;
	}
	@RequestMapping(value = "board/delete_ok.do", produces = "text/html;charset=UTF-8")
	public String board_delete_ok(int no, String pwd)
	{
		String result="";
		boolean bCheck=dao.boardDelete(no, pwd);
		if(bCheck==true)
		{
			result="<script>"
					+ "location.href=\"list.do\""
							+ "</script>";
		}
		else
		{
			result="<script>"
					+ "alert(\"비밀번호를 확인 해주세요.\");"
					+ "history.back();"
					+ "</script>";
		}
		return result;
	}
}
