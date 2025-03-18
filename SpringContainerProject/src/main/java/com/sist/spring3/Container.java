package com.sist.spring3;

import java.util.*;
/*
     ���丮 ���� => �̱��� ����
     �ܼ��� ����(�淮) / �޸� ���� ������ ����
     
     1. Ŭ������ ��Ƽ� ����
     2. ��ü ���� - �Ҹ�
            ---- ��� ������ �ʱ�ȭ(DI) => Inject
     3. ��ü�� ã���ִ� ����(DL) => Lookup
        -----------------
     4. ���� ����� ����� ��� �ڵ�ȭ ó�� => ���� ��� : �ݹ� �Լ�
                                          ------- AOP
     5. MVC : ���̺귯��
     6. ORM : ���̹�Ƽ�� / JPA...
         => Ʈ�����
     7. Task(�����췯) / ����
     
     ---------------------------
      1) XML
      2) Annotation
          => ������ �����ϰ� �⺻ Ʋ�� ������� �ִ�.
             --------- ���κ���
 */
public class Container {
	private Map clsMap=new HashMap();
	public Container()
	{
		clsMap.put("a", new A());
		clsMap.put("b", new B());
		clsMap.put("c", new C());
	}
	public I getBean(String key)
	{
		return (I)clsMap.get(key);
	}
}
