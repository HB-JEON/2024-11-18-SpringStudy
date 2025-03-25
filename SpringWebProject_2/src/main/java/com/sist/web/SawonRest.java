package com.sist.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.vo.SawonVO;

@RestController
public class SawonRest {
	@RequestMapping(value = "sawon/list.do",produces = "text/plain;charset=UTF-8")
	public String sawon_list() throws Exception
	{
		List<SawonVO> list=new ArrayList<SawonVO>();
		SawonVO vo=new SawonVO();
		vo.setName("홍길동");
		vo.setDept("개발부");
		vo.setLoc("부산");
		vo.setJob("사원");
		vo.setPay(3000);
		list.add(vo);
		
		ObjectMapper mapper=new ObjectMapper();
		String s=mapper.writeValueAsString(list);
		
		return s;
	}
}
