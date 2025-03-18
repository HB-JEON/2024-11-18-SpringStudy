package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
    ������ �����ӿ�ũ
    --------------
     1. Container : Ŭ������ ��Ƽ� ����
        BeanFactory
            |
        ApplicationContext : default core(��ü ���� / DI / AOP)
            |
        WebApplicationContext : core(��ü ���� / DI / AOP / MVC)
        
        => GenerricApplicationContext => �ݱ�(��ü �Ҹ�)
        => AnnotationConfigApplicationContext
           => 5�������� �ַ� ���
              ---- ���ȿ� �ַ�
               ��� : XML => ���� �ڹ� ������ ����
                            -------- Boot
        ���
         = ��ü �����ֱ� ����(���� ~ �Ҹ�) => ��� Ŭ���� (VO => ��������)
         = ��ü ã��
         = DL(��ü ã��) / DI(������ �ʱ�ȭ)
                         ---------------
                          1. setter
                          2. contstructor
                          3. method ȣ�� ����
 */
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app1.xml");
		Sawon sa=(Sawon)app.getBean("sal");
		sa.print();
		
		Sawon sa1=(Sawon)app.getBean("sal2");
		sa1.print();
		
		Sawon sa2=(Sawon)app.getBean("sal3");
		sa2.print();
		
		Sawon sa3=(Sawon)app.getBean("sal4");
		sa3.print();
		
		Sawon sa4=(Sawon)app.getBean("sal5");
		sa4.print();
	}
}
