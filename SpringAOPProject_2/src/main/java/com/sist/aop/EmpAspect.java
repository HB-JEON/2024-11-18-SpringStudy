package com.sist.aop;

import com.sist.dao.*;
import java.util.*;

import org.aspectj.lang.ProceedingJoinPoint;

public class EmpAspect {
	private EmpDAO dao;

	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}
	// ���� ��
	public void before()
	{
		dao.getConnection();
		System.out.println("EmpDAO : getConnection Call..");
	}
	// finally
	public void after()
	{
		dao.disConnection();
		System.out.println("EmpDAO : disConnection Call...");
	}
	// ���� �ٽ� �ڵ� ó��
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
		Object obj=null;
		long start=System.currentTimeMillis();
		// ����ڰ� ��û�� �޼ҵ��� ���� �б� => ��
		//  => Ʈ����� => setAutoCommit(false) / �ΰ�
		System.out.println("ȣ��� �޼ҵ� : "+jp.getSignature().getName());
		// �޼ҵ� ȣ��
		obj=jp.proceed(); // ������ �޼ҵ� ȣ�� => empListData / empDetailData
		long end=System.currentTimeMillis();
		System.out.println("���� �ð� : "+(end-start));
		// commit() / ����
		return obj;
	}
	// catch ���� �� ó��
	public void afterThrowing(Throwable ex)
	{
		System.out.println("======= ���� �߻� =======");
		ex.printStackTrace();
		// ���� ���� ó��
	}
	// ���� ���� �� ó��
	public void afterReturning(Object obj)
	{
		System.out.println("======= ����� �ڵ� ó�� =======");
		// => ���������� �ʿ��� request ���� => putter
		List<EmpVO> list=(List<EmpVO>)obj;
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getDbday()+" "
					+vo.getJob()+" "
					+vo.getSal());
		}
	}
}
