package com.sist.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
// 스프링 관리하는 클래스 => 기능이 존재하는 클래스
// ~DAO, ~Manager, ~Service
@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	
	public List<RecipeVO> recipeListData(int start, int end)
	{
		return mapper.recipeListData(start, end);
	}
	public int recipeTotalPage()
	{
		return mapper.recipeTotalPage();
	}
}
