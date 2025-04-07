package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 화면 변경
@Controller
public class RecipeController {
	@GetMapping("recipe/list.do")
	public String recipe_list()
	{
		return "recipe/list";
	}
}
