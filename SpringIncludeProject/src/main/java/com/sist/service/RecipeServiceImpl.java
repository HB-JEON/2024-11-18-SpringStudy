package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Service // 여러개의 DAO를 통합하여 사용
/*
								   @Controller
   요청			=======			 Model 			<=======>			Service 		<=======>		DAO
    JSP(.do)         			  | ViewReolver -> JSP                                               | 리팩토링
 */
public class RecipeServiceImpl implements RecipeService{
	@Autowired
	private RecipeDAO rDao;
	
	@Autowired
	private RecipeDetailDAO dDao;
	
	@Override
	public List<RecipeVO> recipeListData(Map map) {
		// TODO Auto-generated method stub
		return rDao.recipeListData(map);
	}

	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		return rDao.recipeTotalPage();
	}

	@Override
	public RecipeDetailVO recipeDetailData(int no) {
		// TODO Auto-generated method stub
		return dDao.recipeDetailData(no);
	}
	
}
