package com.sist.dao;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.sql.*;
import com.sist.vo.*;

@Repository
// @Scope("prototype")
public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public BoardDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public void disConnection()
	{
		try 
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public List<BoardVO> boardListData(int page)
	{
		List<BoardVO> list=new ArrayList<BoardVO>();
		// => MyBatis : SQL, ?, 어떤 VO
		try 
		{
			// SELECT no, subject, name, hit, regdate, FROM board
			// LIMIT 11, 10
			getConnection();
			String sql="SELECT no, subject, name, hit, regdate, group_tab, num "
					+ "FROM (SELECT no, subject, name, hit, regdate, group_tab, rownum as num "
					+ "FROM (SELECT no, subject, name, hit, regdate, group_tab "
					+ "FROM springReplyBoard ORDER BY group_id DESC, group_step ASC)) "
					+ "WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			int rowSize=10;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				BoardVO vo=new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setHit(rs.getInt(4));
				vo.setRegdate(rs.getDate(5));
				vo.setGroup_tab(rs.getInt(6));
				list.add(vo);
			}
			
		}catch (Exception e) 
		{
			e.printStackTrace();
		}finally 
		{
			disConnection();
		}
		return list;
	}
	// 총페이지
	public int boardRowCount()
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT COUNT(*) FROM springReplyBoard";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
		return total;
	}
	// INSERT / UPDATE / Detail
	public void boardInsert(BoardVO vo)
	{
		try
		{
			getConnection();
			String sql="INSERT INTO springReplyBoard("
					+ "no, name, subject, content, pwd, group_id) "
					+ "VALUES(srb_no_seq.nextval, ?, ?, ?, ?, "
					+ "(SELECT NVL(MAX(group_id)+1, 1)"
					+ "FROM springReplyBoard))";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
	}
	/*
	    @Aspect
	    public class Transactional
	    {
	    	@Around()
	    	public void around(JoinPoint jp)
	    	{
	    		----------- setAutoCommit(false)
	    		  소스 코딩
	    		----------- commit
	    	}
	    	@AfterThrowable()
	    	public void afterThrowing(Exception e)
	    	{
	    		catch
	    		rollback()
	    	}
	    	@After()
	    	public void after()
	    	{
	    		finally
	    		setAutoCommit(true)
	    	}
	    }
	 */
	public BoardVO boardDetailData(int no)
	{
		BoardVO vo=new BoardVO();
		try
		{
			getConnection();
			
			// around 시작
			conn.setAutoCommit(false);
			
			String sql="UPDATE springReplyBoard SET "
					+ "hit=hit+1 "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			
			sql="SELECT no, name, subject, content, hit, regdate "
					+ "FROM springReplyBoard "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setHit(rs.getInt(5));
			vo.setRegdate(rs.getDate(6));
			rs.close();
			
			// around 끝
			conn.commit();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			// jdbc => myBatis => JPA
			// Ajax => Vue => React
			
			// after-throwing
			try
			{
				conn.rollback();
			}catch(Exception ex) {}
		}finally
		{
			// after
			try
			{
				conn.setAutoCommit(true);
			}catch(Exception e) {}
			
			disConnection();
		}
		return vo;
	}
	public BoardVO boardUpdateData(int no)
	{
		BoardVO vo=new BoardVO();
		try
		{
			getConnection();
			String sql="SELECT no, name, subject, content, hit, regdate "
					+ "FROM springReplyBoard "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setHit(rs.getInt(5));
			vo.setRegdate(rs.getDate(6));
			rs.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
		return vo;
	}
	public boolean boardUpdate(BoardVO vo)
	{
		boolean bCheck=false;
		try
		{
			getConnection(); // 자동
			String sql="SELECT pwd FROM springReplyBoard "
					+ "WHERE no="+vo.getNo();
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next(); // 메모리에 데이터 출력 위치 찾기
			String db_pwd=rs.getString(1);
			rs.close();
			
			if(db_pwd.equals(vo.getPwd()))
			{
				bCheck=true;
				sql="UPDATE springReplyBoard SET name=?, subject=?, content=? "
					+ "WHERE no=?";
				ps=conn.prepareStatement(sql);
				// ? 값 채우기
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getContent());
				ps.setInt(4, vo.getNo());
				ps.executeUpdate();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			disConnection();
		}
		return bCheck;
	}
	// reply
	/*
	                    고유번호 그룹(답변 별로 모아서)
	                      그불 별 안에서의 출력 순서
	                                     
	                      no    gi    gs    gt    root    depth
	    AAAAAA             1     1     0     0      0        2
	     => DDDDD          5     1     1     1      1        0
	     => BBBBBB         3     1     1     1      1        1
	      => CCCCCC        4     1     2     2      3        0
	     
	    EEEEEE             5     2     0     0      0        0 
	     => FFFFFF         
	 */
	public void replyInsert(int pno, BoardVO vo)
	{
		try
		{
			getConnection(); // around start
			conn.setAutoCommit(false);
			// SQL 문장 여러개
			// 상위 게시물 => group_id, group_step, group_tab
			String sql="SELECT group_id, group_step, group_tab "
					+ "FROM springReplyBoard "
					+ "WHERE no="+pno;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int gi=rs.getInt(1); // 그대로 
			int gs=rs.getInt(2); // +1
			int gt=rs.getInt(3); // +1
			rs.close();
			// group_step을 증가 (그룹 별 출력 순서 변경)
			sql="UPDATE springReplyBoard "
					+ "SET group_step=group_step+1 "
					+ "WHERE group_id=? AND group_step>?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, gi);
			ps.setInt(2, gs);
			ps.executeUpdate();
			// 게시물 추가
			sql="INSERT INTO springReplyBoard(no, name, subject, content, pwd, group_id, group_step, group_tab, root) "
					+ "VALUES(srb_no_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps. setString(4, vo.getPwd());
			ps.setInt(5, gi);
			ps.setInt(6, gs+1);
			ps.setInt(7, gt+1);
			ps.setInt(8, pno);
			ps.executeUpdate();
			// depth++
			sql="UPDATE springReplyBoard SET "
					+ "depth=depth+1 "
					+ "WHERE no="+pno;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			conn.commit(); // around end
		}catch(Exception e)
		{
			e.printStackTrace();
			try
			{
				conn.rollback(); // after-throwing
			}catch(Exception ex) {}
		}finally
		{
			try {
				conn.setAutoCommit(true); // after
			} catch (Exception e) {}
			disConnection();
		}
	}
	// DELETE
	public boolean boardDelete(int no, String pwd)
	{
		boolean bCheck=false;
		try
		{
			getConnection();
			conn.setAutoCommit(false);
			// 비밀번호 확인
			String sql="SELECT root, depth, pwd FROM springreplyBoard "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int root=rs.getInt(1);
			int depth=rs.getInt(2);
			String db_pwd=rs.getString(3);
			if(db_pwd.equals(pwd))
			{
				bCheck=true;
				if(depth==0) // 삭제
				{
					sql="DELETE FROM springReplyBoard "
							+ "WHERE no="+no;
					ps=conn.prepareStatement(sql);
					ps.executeUpdate();
				}else // 수정
				{
					String msg="관리자에 의해 삭제된 게시물입니다.";
					sql="UPDATE springReplyBoard SET subject=?, content=? "
							+ "WHERE no=?";
					ps=conn.prepareStatement(sql);
					ps.setString(1, msg);
					ps.setString(2, msg);
					ps.setInt(3, no);
					ps.executeUpdate();
				}
				sql="UPDATE springReplyBoard "
						+ "SET depth=depth-1 "
						+ "WHERE no="+root;
				ps=conn.prepareStatement(sql);
				ps.executeUpdate();
			}
			// depth 확인
			// 삭제 여부 확인 depth=0 => 삭제, update
			// depth--
			conn.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			try 
			{
				conn.rollback();
			} catch (Exception ex) {}
		}finally
		{
			try 
			{
				conn.setAutoCommit(true);
			} catch (Exception e) {}
			disConnection();
		}
		return bCheck;
	}
}