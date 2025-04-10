package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class ReplyDAO {
	@Autowired
	private ReplyMapper mapper;
	
	public List<ReplyVO> replyListData(int bno)
	{
		return mapper.replyListData(bno);
	}
	public void replyInsert(ReplyVO vo)
	{
		mapper.replyInsert(vo);
	}
}
