package com.sist.main;
/*
     ������
       => Ŭ���� ���� ����
          --------- �����̳� Ŭ����
                BeanFactory
                     |
                ApplicationContext
                     |------------------- AnnotationConfigApplicationContext
                     |                     => �ڹٷ� ��� => 5���� �̻󿡼� ����(����)
                WebpApplicationContext
                
          *** Component : Ŭ���� �Ѱ�(����� ������ �ִ� Ŭ����)
                          JButton / JTexField
                          ~Model / ~Manager / ~DAO => ��ǰ
          *** Container : ������ => Ŭ������ �����ϴ� ����
                           => ���� ����
                 | Ŭ���� ����
                   ---------
                    1) ��ü ����
                        <bean id="a" class=com.sist.main.A"/>
                          => Class clsName=Class.forName("com.sist.main.A")
                             Object obj=clsName.newInstance()
                              => map.put("a", obj) => ������
                    2) ���� �ÿ� ��� ������ ���� �ʱ�ȭ
                       ---------------------------- DI
                        | setXxx() => setter DI
                          ������ �Ű����� => constructor DI
                          ���� �� / �Ҹ� �ÿ� �� ���� ȣ�� => method DI
                    3) ��ü ã�� => DL => getBean()
                    4) ��ü �Ҹ�
                 | ��� 3����
                    Ŭ���� ��� / DI
                     1) XML : ���� ���
                     2) Annotation : ����
                     3) XML+Annotation => �� / �ǹ�
                        --- ----------
                        XML - ������Ʈ���� ���� ���Ǵ� �κ� / ���̺귯�� Ŭ����
                                                           --------------
                                                            MyBatis / Transaction
                        Annotation - ����� ���� Ŭ����
                        
             => �������� ���Ǵ� Ŭ������ �޼ҵ带 ��Ƽ� ���� : ������
                 => com.sist.commons
                 => �ڵ� ȣ���� ����(AOP)
             => �� => MVC
                 => �߰� (Task, Security / Batch / SI / Spring-Data)
             => �����ӿ�ũ VS ���̺귯��
                --------    --------
                 | ����       | ����ǰ
                    => �⺻ ������ ���� Ʋ�� ��������ִ�.
                                      -
                       ���Ŀ� �°� ���� �� ���
                       --- XML - �Ӽ� / �±װ� �̹� ��������ִ�. => DTD / ��Ű��
                           Annotation - �̹� ��������ִ�. => @Controller / @RequestMapping
                           ���̺귯�� �߰� : pom.xml / gradle(Spring-Boot)
                           
             ���������� �����ϴ� ���̺귯��
               = spring-core : Container / DI
               = spring-aop : AOP => ���� ���
               = spring-orm : MyBatis / JPA
               = spring-dao : JDBC
               = spring-web / = spring-webmvc
             ������ ����� ����
               = ���꼺 => ���̺귯���� �ϼ��� / �ŷڼ� / ���� �ӵ�
               = �������� / Ȯ�强 => �ٸ� ��� ���α׷��� ����
               = ���� / �������� �����ؼ� ��� ����
               = *** ���� ����� �°� ���̺귯�� ����
                     ------- AI / MSA
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
