package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import com.sist.vo.FoodVO;


public interface FoodMapper {
	public int foodTotalPage();
	
	@Select(value="{CALL foodListData(#{pStart,mode=IN,javaType=java.lang.Integer},#{pEnd,mode=IN,javaType=java.lang.Integer},#{pResult,mode=OUT,jdbcType=CURSOR,resultMap=foodMap})}")
	@Options(statementType = StatementType.CALLABLE)
     public List<FoodVO> foodListData(Map map);
}
