package com.sist.main;
// Proxy => �븮�� => AOP
/*
     ���α׷� => �ٽ� �ڵ�
                -------
                 �ΰ����� �ڵ� => ��Ƽ� ���� => ������ / AOP
                  | �����ͺ��̽� ���� / �����ͺ��̽� ����
                    ����(�ΰ� => ����)
                    Ʈ����� => commit / rollback
                    �α�
                    ���� �����
                 ----------------------------------- AOP ���̺귯��
                  | ����� ���� AOP
                    ------------- ���ͼ�Ʈ(�ڵ� �α���), AOP
     �ߺ� ���� => �޼ҵ�ȭ ó��
     ---------------------- CallBack
      AOP�� ����
       1. Aspect : ���������� ����Ǵ� ����� ��Ƶ� ��� => ���� ���
       2. Target : �����ϴ� ��� => ����ִ� ����(����)
       3. Advice : ��� � ����� �߰��� ��
                   JoinPoint + PointCut
       4. JoinPoint : ���� => ��� ȣ��
                      Before
                      After
                      After-Returning
                      After-Throwing
                      Around
                      
                      public void display()
                      {
                      	Before => try ���� ��
                      	  try
                      	  {
                      	    --------- Around start
                      	     => �α�
                      	     => � �޼ҵ带 ��û
                      	     => setAutoCommit(false)
                      	     �ٽ� �ڵ� => �޼ҵ� ȣ��
                      	    --------- Around end
                      	     => �ɸ� �ð� Ȯ��
                      	  }
                      	  catch(Exception e)
                      	  {
                      	    After-Throwing => �����߻� �� ó��
                      	  }
                      	  finally
                      	  {
                      	    After => ������ ����
                      	  }
                      	  return => After-Returning => ������� ��
                      }
       5. PointCut : � �޼ҵ� => execution("������ ��Ű��.Ŭ������.�޼ҵ��(..)")
                                               *                 | �Ű������� 0�� �̻�
                                                                
             => �޼ҵ忡 ���� �����ϴ� �ҽ��� ��Ƶ� : Aspect
             -------------------------------------------------
             => �޼ҵ尡 ȣ��� ��
             => �޼ҵ带 � ��ġ�� ���������� ����
             ------------------------------------------------- Advice
                                  --- Weaving
             => include�� ���� : ���ึ�� ����
 */
public class MainClass {
	public static void main(String[] args) {
		My m=new My();
		m.excute();
		
		MyTarget mt=new MyTarget(m);
		mt.execute();
	}
}
