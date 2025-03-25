package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
/*
 *   Mapper => 스프링에서 구현 
 *   --------------------
 *          |
 *       BoardDAO
 *          |
 *       Model => JSP
 *       
 *       1. request 보안 취약으로 사용 금지
 *          -------
 *           1) 요청 값 받기 => 매개 변수
 *                            ========
 *                             순서 상관 X
 *                              => 내장 객체 받은 후 처리 가능
 *                               request / response / session
 *                               RedirceAttribute
 *                               => VO
 *           2) JSP 값 전송 => Model
 *           
 *       2. 기본 틀 => 메인보드
 *                    ------ 부품 제작 (CPU / HDD...)
 *           DispatcherServlet : 요청 / 응답
 *           HandlerMapping : Model 찾기
 *                            @RequestMapping 메소드를 찾기 및 호출
 *                            => 세팅
 *           ViewResolver : 결과값(request)을 JSP 전송
 *                           => 경로명 / 확장자
 *                           => application-context.xml
 *       
 *       3. JSP는 변경 사항이 없다.
 *       
 *    => 매개변수 처리
 *    => request를 전송 => request "jsp파일명" 지정
 *    => request를 미전송 => return "redirect:"
 *           
 *    1. 동작 순서
 *        사용자 전송 => 요청 값 받기 => Model 요청 값 전송 => 데이터베이스
 *         => 요청 처리 => 결과값 => JSP 전송
 *         
 *        JSP(forword) => 결과값 전송이 있는 경우
 *        JSP(redirect) => 결과값 전송이 없는 경우 => 기존 파일에 이동
 *        
 *        detail.do = detail.jsp
 *        insert_ok.do = list.jsp
 *    
 */
@Controller  // 화면 변경 => forward / sendRedirect
@RequestMapping("board/")
public class BoardController {
	
	@Autowired
    private BoardDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping("list.do")
	public String board_list(String page,Model model)
	{
		if(page==null)
			page="1";
		
		int curpage=Integer.parseInt(page);
		List<BoardVO> list=dao.boardListData((10*curpage)-9, curpage*10);
		int totalpage=dao.boardTotalPage();
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@RequestMapping("insert.do")
	public String board_insert()
	{
		return "board/insert";
	}
	@RequestMapping("insert_ok.do")
	public String board_insert_ok(BoardVO vo)
	{
		String pwd=encoder.encode(vo.getPwd());
		vo.setPwd(pwd);
		System.out.println("pwd="+pwd);
		dao.boardInsert(vo);
		// => if(pwd.matchs(vo.getPwd())
		
		return "redirect:list.do";
	}
	
	// 상세보기 요청 
	@RequestMapping("detail.do")
	// 데아터형 => String 통합 , 각 데이터형으로 받을 수 있다
	// 처음 시작에 데이터가 없는 경우 => String 
	public String board_detail(int no,Model model)
	{
		// Model => 전송객체 : request를 대체
		/*
		 *   => Cookie 
		 */
		BoardVO vo=dao.boardDetailData(no);
		model.addAttribute("vo", vo);
		
		return "board/detail";
	}
	// 수정 / 삭제 => 비밀번호 검색
	/*
		     메소드 명은 상관 X
		     리턴형
		       String : 파일명 지정
		       void => 다운로드
		     매개변수 사용
		        일반 데이터형
		        배열
		        List
		        VO
		        내장 객체
	*/
	@RequestMapping("update.do")
	public String board_update(int no,Model model)
	{
		BoardVO vo=dao.boardUpdateData(no);
		model.addAttribute("vo", vo);
		return "board/update";
	}
//	@RequestMapping("update_ok.do")
//	public String board_update_ok(BoardVO vo, Model model)
//	{
//		boolean bCheck=dao.boardupdate(vo);
//		model.addAttribute("bCheck", bCheck);
//		model.addAttribute("no", vo.getNo());
//		return "board/update_ok";
//	}
//	@RequestMapping("update_ok.do")
//	@ResponseBody ==> 승격
//	// out.write() => 자바스크립트 전송, JSON, 일반 문자열
//	public String board_update_ok(BoardVO vo)
//	{
//		String result="";
//		boolean bCheck=dao.boardupdate(vo);
//		if(bCheck==true)
//		{
//			result="<script>"
//					+ "location.href=\"detail.do?no="+vo.getNo()+"\""
//							+ "</script>";
//		}
//		else
//		{
//			result="<script>"
//					+ "alert(\"Password Fail\");"
//					+ "history.back();"
//					+ "</script>";
//		}
//		return result;
//	}
	@RequestMapping("delete.do")
	public String board_delete(int no, Model model)
	{
		model.addAttribute("no", no);
		return "board/delete";
	}
	
}