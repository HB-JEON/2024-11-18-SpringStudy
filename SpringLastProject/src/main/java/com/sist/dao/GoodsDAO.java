package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsMapper;
import com.sist.vo.GoodsVO;

@Repository
public class GoodsDAO {
	/*
	    interface DB
	    
	    class A implements DB
	    class B implements DB
	    
	    @Autowired
	    @Qualifier(name="a") => 중복된 경우 특정 객체 지정
	    DB db;
	 */
	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> busanGoodsListData(int start, int end)
	{
		return mapper.busanGoodsListData(start, end);
	}
	public int busanGoodsTotalPage()
	{
		return mapper.busanGoodsTotalPage();
	}
	public GoodsVO busanGoodsDedatilData(int no)
	{
		return mapper.busanGoodsDedatilData(no);
	}
}
