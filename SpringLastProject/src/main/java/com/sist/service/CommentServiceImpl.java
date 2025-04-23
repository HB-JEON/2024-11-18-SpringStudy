package com.sist.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.*;
import com.sist.vo.*;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDAO cDao;

	@Override
	public List<CommentVO> commentListData(Map map) {
		// TODO Auto-generated method stub
		return cDao.commentListData(map);
	}

	@Override
	public int commentTotalPage(int cno, int type) {
		// TODO Auto-generated method stub
		return cDao.commentTotalPage(cno, type);
	}

	@Override
	public void commentInsert(CommentVO vo) {
		// TODO Auto-generated method stub
		cDao.commentInsert(vo);
	}
	/*
	    Spring
	      1. Container = 클래스 관리자
	      2. DI = 클래스와 클래스의 의존성이 낮은 프로그램
	               => 인터페이스
	      3. AOP => 공통 모듈
	      4. ORM => 데이터베이스 관련 라이브러리
	      			 MyBatis / JPA
	      5. MVC 동작 과정
	      6. Spring Security : 권한 / 로그인 처리
	      7. RestFul
	 */
	@Override
	public void commentUpdate(String msg, int no) {
		// TODO Auto-generated method stub
		cDao.commentUpdate(msg, no);
	}

	@Override
	public void commentReplyReplyInsert(int pno, CommentVO vo) {
		// TODO Auto-generated method stub
		cDao.commentReplyReplyInsert(pno, vo);
	}

	@Override
	public void commentDelete(int no) {
		// TODO Auto-generated method stub
		cDao.commentDelete(no);
	}
}
