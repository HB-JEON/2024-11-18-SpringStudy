package com.sist.service;
import com.sist.vo.*;
import com.sist.dao.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodRecipeServiceImpl implements FoodRecipeService{
	@Autowired
	private FoodDAO fDao;
	
	@Override
	public List<FoodVO> foodListData(Map map) {
		return fDao.foodListData(map);
	}
	
	@Override
	public FoodVO foodDetailData(int fno) {
		return fDao.foodDetailData(fno);
	}
	
	@Override
	public int foodTotalPage() {
		return fDao.foodTotalPage();
	}
}
