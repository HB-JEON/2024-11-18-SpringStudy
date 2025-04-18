package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	@GetMapping("/board/list")
	public String board_list()
	{
		return "board/list";
	}
	@GetMapping("/board/insert")
	public String board_insert()
	{
		return "board/insert";
	}
	@GetMapping("/board/detail")
	public String board_detail(int no, Model model)
	{
		System.out.println("no: "+no);
		model.addAttribute("no", no);
		return "board/detail";
	}
	@GetMapping("/board/update")
	public String board_update(int no, Model model)
	{
		model.addAttribute("no", no);
		return "board/update";
	}
	@GetMapping("/board/delete")
	public String board_delete(int no, Model model)
	{
		model.addAttribute("no", no);
		return "board/delete";
	}
}
