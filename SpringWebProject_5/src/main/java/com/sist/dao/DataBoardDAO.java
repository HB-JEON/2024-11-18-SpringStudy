package com.sist.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> boardListData(int start, int end)
	{
		return mapper.boardListData(start, end);
	}
	public int boardRowCount()
	{
		return mapper.boardRowCount();
	}
	public int boardInsert(DataBoardVO vo)
	{
		mapper.boardInsert(vo);
		return mapper.boardCurentNoData();
	}
	/*
	 @Update("UPDATE springDataBoard SET hit=hit+1 WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT * FROM springdataBoard WHERE no=#{no}")
	public DataBoardVO databoardDetailData(int no);
	 */
	public DataBoardVO databoardDetailData(int no)
	{
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}
	/*
	 	@Select("SELECT pwd FROM springDataBoard WHERE no=#{no}")
		  public String databoardGetPassword(int no);
		
		@Delete("DELETE FROM springDataBoard WHERE no=#{no}")
		  public void databoardDelete(int no);
	 */
	public String databoardGetPassword(int no)
	{
		return mapper.databoardGetPassword(no);
	}
	public void databoardDelete(int no)
	{
		mapper.databoardDelete(no);
	}
	public int databoardFileCount(int no)
	{
		return mapper.databoardFileCount(no);
	}
	public DataBoardVO databoardUpdateData(int no)
	{
		return mapper.databoardDetailData(no);
	}
	public void databoard_update(DataBoardVO vo)
	{
		mapper.databoardUpdate(vo);
	}
}
