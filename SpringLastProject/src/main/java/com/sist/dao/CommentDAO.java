package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class CommentDAO {
	@Autowired
	private CommentMapper mapper;
	
	public List<CommentVO> commentListData(Map map)
	{
		return mapper.commentListData(map);
	}
	public int commentTotalPage(@Param("cno") int cno, @Param("type") int type)
	{
		return mapper.commentTotalPage(cno, type);
	}
	public void commentInsert(CommentVO vo)
	{
		mapper.commentInsert(vo);
	}
	public void commentUpdate(String msg, int no)
	{
		mapper.commentUpdate(msg, no);
	}
	@Transactional
	public void commentReplyReplyInsert(int pno, CommentVO vo)
	{
		CommentVO pvo=mapper.commentParentInfoData(pno);
		vo.setGroup_id(pvo.getGroup_id());
		vo.setGroup_step(pvo.getGroup_step()+1);
		
		mapper.commentGroupStepIncrement(pvo);
		mapper.commentReplyReplyInsert(vo);
	}
	
	public void commentDelete(int no)
	{
		CommentVO vo=mapper.commentParentInfoData(no);
		Map map=new HashMap();
		map.put("no", no);
		map.put("group_id", vo.getGroup_id());
		map.put("group_step", vo.getGroup_step());
		
		mapper.commentDelete(map);
	}
}
