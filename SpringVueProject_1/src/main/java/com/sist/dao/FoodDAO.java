package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class FoodDAO {
   @Autowired
   private FoodMapper mapper;
   
   
   public List<FoodVO> foodListData(int start,int end)
   {
	   return mapper.foodListData(start, end);
   }
   public int foodTotalPage()
   {
	   return mapper.foodTotalPage();
   }
   public FoodVO foodDetailData(int fno)
   {
	   return mapper.foodDetailData(fno);
   }
}