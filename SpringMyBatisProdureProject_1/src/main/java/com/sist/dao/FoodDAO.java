package com.sist.dao;


import java.util.*;
import java.sql.*;
import com.sist.vo.*;
import lombok.Setter;
import oracle.jdbc.OracleTypes;

public class FoodDAO {
	private Connection conn;
	private CallableStatement cs;
	// => Default : PreparedStatement
	// @Options(statementType=StatementType.CALLBLE>
	@Setter
	private String url; 
	@Setter
	private String username;
	@Setter
	private String password;
	
	public FoodDAO(String driver)
	{
		try
		{
			Class.forName(driver);
		}catch(Exception e) {}
	}
	public void getConection()
	{
		try
		{
			conn=DriverManager.getConnection(url,username,password);
		}catch(Exception e) {}
	}
	public void disConection()
	{
		try
		{
			if(cs!=null) cs.close();
			if(conn!=null) conn.close();
		}catch(Exception e) {}
	}
	
	public List<FoodVO> foodListData(int page)
	{
		List<FoodVO> list=new ArrayList<FoodVO>();
		try
		{
			getConection();
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			/*
			 CREATE OR REPLACE PROCEDURE foodListData(
				    pStart NUMBER,
				    pEnd NUMBER,
				    pResult OUT SYS_REFCURSOR
				)
				IS
				BEGIN
				    OPEN pResult FOR
				    SELECT fno, poster, name, num
				    FROM (SELECT fno, poster, name, rownum as num
				    FROM (SELECT fno, poster, name
				    FROM project_food ORDER BY fno ASC))
				    WHERE num BETWEEN pStart AND pEnd;
				END;
				/
			 */
			String sql="{CALL foodListData(?, ?, ?)}";

			// @Select(value = "{CALL foodListData(pStart, mode = IN, javaType = java.lang.Integer...)})
			cs=conn.prepareCall(sql);
			// ? 값 
			cs.setInt(1, start);
			cs.setInt(2, end);
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs=(ResultSet)cs.getObject(3);
			while(rs.next())
			{
				FoodVO vo=new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setName(rs.getString(3));
				list.add(vo);
			}
			rs.close();
			// 모든 값이 Map으로 넘어옴
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			disConection();
		}
		return list;
	}
	/*
	 			CREATE OR REPLACE PROCEDURE foodTotalPage(
				    pTotal OUT NUMBER
				)
				IS
				BEGIN
				    SELECT CEIL(COUNT(*)/12.0) INTO pTotal
				    FROM project_food;
				END;
				/
	 */
	public int foodTotalPage()
	{
		int total=0;
		try
		{
			getConection();
			String sql="{CALL foodTotalPage(?)}";
			cs=conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.INTEGER);
			cs.executeQuery();
			total=cs.getInt(1);
			cs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			disConection();
		}
		return total;
	}
}
