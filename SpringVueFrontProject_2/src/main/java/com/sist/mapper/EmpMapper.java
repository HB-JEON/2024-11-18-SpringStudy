package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;

public interface EmpMapper {
	@Select("SELECT empno, ename, job, sal, TO_CHAR(hiredate, 'YYYY-MM-DD') as dbday "
			+ "FROM emp")
	public List<EmpVO> empListData();
	// List(selectList) or VO(selectOne)
	// Row 여러개인 경우, Row 한개인 경우
	
	@Select("SELECT * FROM dept")
	public List<DeptVO> deptListData();
}