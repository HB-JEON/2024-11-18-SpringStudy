package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.FoodVO;
import com.sist.vo.ReserveVO;
@Repository
public class ReserveDAO {
	@Autowired
	private ReserveMapper mapper;
	
	public List<FoodVO> busanFoodReserveData()
	{
		return mapper.busanFoodReserveData();
	}
	public void reserveInsert(ReserveVO vo)
	{
		mapper.reserveInsert(vo);
	}
	public List<ReserveVO> reservoMyPageListData(String userid)
	{
		return mapper.reserveMyPageListData(userid);
	}
	public List<ReserveVO> reserveAdminPageListData()
	{
		return mapper.reserveAdminPageListData();
	}
	public void reserveDelete(int rno)
	{
		mapper.reserveDelete(rno);
	}
	public void reserveUpdate(int rno)
	{
		mapper.reserveUpdate(rno);
	}
}
