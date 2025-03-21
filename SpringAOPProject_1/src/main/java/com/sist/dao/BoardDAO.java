package com.sist.dao;
/*
     ���ռ��� ���� ���α׷� => �������� �����ڰ� ���� ����
     ------------------ 
      Container - Ŭ������ ������ ��Ƽ� ����
      POJO - �ٸ� Ŭ������ ������ ���� ���� Ŭ���� => �������̽� / ������� �ʴ� �Ϲ� �ڹ� ���α׷�
      DI - Ŭ���� �޸� �Ҵ� �� �ʿ��� ��� ��� ���� �ʱ�ȭ
     
     => ���� �ҽ� ���� �߻� => �������� ���Ǵ� �ҽ��� ��Ƽ� ����
                            ==============================
                             | ���� ��� => AOP
                                => �ݺ� �ڵ� X
                             | OOP vs AOP
                                => AOP�� OOP�� ������ ����
                                => CallBack => �ڵ� ȣ��
                                => � �޼ҵ��ΰ�
                                => ��� ����
        try
        {
        	getConnection()  ==>  BEFORE
        	...
        	...
        }catch(Exception e) {
        	e.printStackTrace()
        }finally {
        	disConnection()  ==>  AFTER
        }
        
        @== Before
        try
        {
        	-------------------- Around setAutoCommit(false)
        	...
        	...
        	-------------------- commit() => Ʈ����� / �α� ����
        }catch(Exception e) {                          ------- ���������� ���̺귯��
        	@== After-Throwing
        }finally {
        	@== After
        }
        return ... @== After-Returning
        
        �⺻
         => �ڵ� �ҽ�
            --------
            �������� ���Ǵ� �ҽ�
            �ٽ����� ���Ǵ� �ҽ�
 */
public class BoardDAO {
	public void getConnection()
	{
		System.out.println("����Ŭ ����");
	}
	public void disConnection()
	{
		System.out.println("����Ŭ �ݱ�");
	}
	public void boardListData(int page)
	{
//		getConnection();
		System.out.println(page+"������ ��� ���");
//		disConnection();
	}
	public String boardDetailData(String name)
	{
//		getConnection();
		System.out.println(name+"�� ���� �� ����");
//		disConnection();
		return name;
	}
	
	public void boardInsert()
	{
//		getConnection();
		System.out.println("�Խù� �߰� �Ϸ�");
//		disConnection();
	}
	public void boardupdate()
	{
//		getConnection();
		System.out.println("�Խù� ���� �Ϸ�");
//		disConnection();
	}
	public void boardDelete()
	{
//		getConnection();
		System.out.println("�Խù� ���� �Ϸ�");
//		disConnection();
	}
	public void print()
	{
		System.out.println("���α׷� ����");
	}
}
