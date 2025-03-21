package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.BoardDAO;
// Ʈ����� / ���� => �ڵ� ȣ��
/*
   insert => ����(��� X)
   update => ����
   delete => 
   
    public void insert()
    {
    	try
    	{
    		getConnection()
    		conn.setAutoCommit(false) *
    		...
    		...
    		con.commit() *
    	}catch(Exception e) {
    		conn.rollback() *
    	}finally {
    		conn.setAutoCommit(true) *
    		dis.Connection()
    	}
    	
    	@Transactional
    	public void insert()
    	{
    		insert
    		insert
    	}
    }
 */
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		BoardDAO dao=(BoardDAO)app.getBean("dao");
		dao.boardListData(1);
		dao.boardDetailData("ȫ�浿");
		dao.boardInsert();
		dao.boardupdate();
		dao.boardDelete();
	}
}
