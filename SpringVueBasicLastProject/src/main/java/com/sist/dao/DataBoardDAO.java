package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	public List<DataBoardVO> databoardListData(Map map)
	{
		return mapper.databoardListData(map);
	}
	public int databoardTotalPage()
	{
		return mapper.databoardTotalPage();
	}

	public void dataBoardInsert(DataBoardVO vo)
	{
		mapper.dataBoardInsert(vo);
	}
	public DataBoardVO databoardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}
}
