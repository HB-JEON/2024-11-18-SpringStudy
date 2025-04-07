package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.EmpDAO;

// => 요청된 데이터를 JSP 전송 => EL / JSTL
// => 화면 변경 가능
// => 브라우저 연동
/*
    브라우저 ======================== 오라클
      |     연결 할 수 있는 프로그램 X
    브라우저 =========== 자바 => 스프링
                         | ========== 오라클
                      파이썬 => 장고
                      C# => ASP.Net
     => 순수하게 JSP만 이용 시 => @Controller
     => 자바스크립트 => @RestController
         자바 = 사바스크립트 매칭
         예약 / 결제 / 추천
 */

@Controller
public class EmpController {
	// DAO 가져오기
	@Autowired
	private EmpDAO dao;
	
	@GetMapping("emp/list.do")
	public String emp_list(Model model) // JSP로 값을 전송 => HttpServletRequest / Model
	{
		// model => JSP로 데이터 전송 객체
		List<EmpVO> list=dao.empListData();
		model.addAttribute("list", list);
		return "emp/list";
	}
	
	@GetMapping("emp/list2.do")
	public String emp_list2()
	{
		return "emp/list2";
	}
}
