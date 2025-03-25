package com.sist.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.vo.SawonVO;

// Spring => ����� ���� => ~Controller
// Struts => ~Action
// ����� => ~Model
@Controller
public class SawonController {
	@RequestMapping("sawon/insert.do")
	public String sawon_insert(HttpServletRequest request, HttpServletResponse response)
	{
		return "sawon/insert";
	}
	@RequestMapping("sawon/insert_ok.do")
    public String swaon_insert_ok(HttpServletRequest request,
    		HttpServletResponse response)
    {
    	String sabun=request.getParameter("sabun");
    	String name=request.getParameter("name");
    	String job=request.getParameter("job");
    	String dept=request.getParameter("dept");
    	String loc=request.getParameter("loc");
    	String pay=request.getParameter("pay");
    	SawonVO vo=new SawonVO();
    	vo.setSabun(Integer.parseInt(sabun));
    	vo.setPay(Integer.parseInt(pay));
    	vo.setName(name);
    	vo.setLoc(loc);
    	vo.setJob(job);
    	vo.setDept(dept);
    	
    	request.setAttribute("vo", vo);
        return "sawon/output";	
    }
	
	@RequestMapping("sawon/insert_ok3.do")
	public String sawon_insert_ok2(HttpServletRequest request, int sabun, String name, String dept, 
			            String loc, String job, int pay)
	{
		SawonVO vo=new SawonVO();
		vo.setSabun(sabun);
		vo.setPay(pay);
		vo.setName(name);
		vo.setLoc(loc);
		vo.setJob(job);
		
		return "sawon/output";
	}
}
