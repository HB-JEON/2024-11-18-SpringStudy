package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.MemberMapper;
import com.sist.vo.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
	public MemberVO memberLogin(String id, String pwd)
	{	
		MemberVO vo=new MemberVO();
		int count=mapper.memberIdCount(id);
		if(count==0)
		{
			// ID X
			vo.setMsg("NoID");
		}else
		{
			// ID O
			MemberVO dbvo=mapper.memberGetInfoData(id);
			if(pwd.equals(dbvo.getPwd()))
			{
				// 로그인 시 세션에 저장할 데이터
				vo.setMsg("OK");
				vo.setId(dbvo.getId());
				vo.setName(dbvo.getName());
				vo.setSex(dbvo.getSex());
			}else
			{
				vo.setMsg("NoPWD");
			}
		}
		return vo;
	}
}
