package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;

public interface FoodMapper {
	@Select("SELECT fno, poster, name, rownum "
			+ "FROM food_menupan "
			+ "WHERE rownum<=12")
	public List<FoodVO> foodListData();
}
