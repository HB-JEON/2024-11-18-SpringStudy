package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;

@Service
public class GoodsServiceImpl implements GoodsService {
	/*
	     요청 = Service = DAO = 오라클
	     응답 = Service = DAO = 오라클
	                     ----------- 유지보수 시 클라이언트에 오류가 없게 의존성을 낮춤
	 */
	@Autowired
	private GoodsDAO gDao;
	
	@Override
	public List<GoodsVO> busanGoodsListData(int start, int end) {
		// TODO Auto-generated method stub
		return gDao.busanGoodsListData(start, end);
	}

	@Override
	public int busanGoodsTotalPage() {
		// TODO Auto-generated method stub
		return gDao.busanGoodsTotalPage();
	}

	@Override
	public GoodsVO busanGoodsDedatilData(int no) {
		// TODO Auto-generated method stub
		return gDao.busanGoodsDedatilData(no);
	}

}
