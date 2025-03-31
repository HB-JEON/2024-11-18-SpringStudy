package com.sist.service;
import com.sist.vo.*;
import java.util.*;

public interface FoodRecipeService {
	public List<FoodVO> foodListData(Map map);
	public FoodVO foodDetailData(int fno);
	public int foodTotalPage();
}
