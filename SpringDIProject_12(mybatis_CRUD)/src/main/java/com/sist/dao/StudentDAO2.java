package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
import com.sist.mapper.*;
public class StudentDAO2 {
	private StudentMapper1 mapper;
	@Select("SELECT * FROM student")
	public List<StudentVO> studentListData()
	{
		return mapper.studentListData();
	}
	public StudentVO studentDetailData(int hakbun)
	{
		return mapper.studentDetailData(hakbun);
	}
	public void studentInsert(StudentVO vo)
	{
		mapper.studentInsert(vo);
	}
	public void studentDelete(int hakbun)
	{
		mapper.studentDelete(hakbun);
	}
	public void studentUpdate(StudentVO vo)
	{
		mapper.studentUpdate(vo);
	}
}
