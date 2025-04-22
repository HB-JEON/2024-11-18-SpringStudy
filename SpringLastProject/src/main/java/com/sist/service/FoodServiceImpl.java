package com.sist.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;
import com.sist.dao.*;

// 의존성 낮추기 / DAO 여러개를 통합하여 사용
@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	private FoodDAO fDao;
	
	@Override
	public List<FoodVO> busanFoodListData(int start, int end) {
		// TODO Auto-generated method stub
		return fDao.busanFoodListData(start, end);
	}

	@Override
	public int busanFoodTotalPage() {
		// TODO Auto-generated method stub
		return fDao.busanFoodTotalPage();
	}

	@Override
	public FoodVO busanFoodDetailData(int fno) {
		// TODO Auto-generated method stub
		return fDao.busanFoodDetailData(fno);
	}

}
