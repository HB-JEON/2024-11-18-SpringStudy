package com.sist.dao;

import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	public List<FoodVO> busanFoodListData(int start, int end)
	{
		return mapper.busanFoodListData(start, end);
	}
	public int busanFoodTotalPage()
	{
		return mapper.busanFoodTotalPage();
	}
	public FoodVO busanFoodDetailData(int fno)
	{
		return mapper.busanFoodDetailData(fno);
	}
}
