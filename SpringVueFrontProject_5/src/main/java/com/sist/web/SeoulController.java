package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 화면만 변경 => forward / redirect
@Controller
public class SeoulController {
	@GetMapping("seoul/list.do")
	public String seoul_list()
	{
		return "seoul/list";
	}
	@GetMapping("seoul/detail.do")
	public String seoul_detail()
	{
		return "seoul/detail";
	}
}
