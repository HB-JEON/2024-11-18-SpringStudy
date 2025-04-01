package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.net.URLEncoder;
/*
    1. DataBase 연동
    2. Web 연동
            Model        DAO
    브라우저 <=====> 자바 <=====> 오라클
      | NodeJS      | 파이썬, C#
                   DispatcherServlet = HandleMapping - ViewResolver - JSP
                     | 동작하기 위한 설정 작업
                       (메뉴얼 작업)
                       ----------- XML, properties
                                   ---------------
                                    메타 데이터
                                    
     1. 사용자가 요청한 데이터 읽기 => detail.do?no=10
         <a> <form> ajax, axios
                     |     | Vue, React, Next
                   JQuery
         *** detail.do => *.do, /*  =>  <url-mapping>
                    -- DispatcherServlet => web.xml
                        | interceptor(자동 로그인)
     2. DispatchServlet => HandlerMapping
                           --------------
                            | @RequestMapping
                              @GetMapping
                              @PostMapping
                               => 밑에 있는 메소드 호출
                                   | 출력에 필요한 데이터를 JSP
                            --------------------------------
                                        | interceptor
                             | JSP로 데이터를 전송
                                => 어떤 JSP로 전송 할지
                                    = return "main/main.jsp"
                                => 어떤 값을 보낼 것인지
                                    = request.setAttribute()
                                    = model.addAttribute()
                                => 전송하는 클래스
                                    = ViewResolver
                                       | 경로명 / 확장자
                            ---------------------------------
                                        | interceptor
 */
/*
    스프링 : 프레임워크
            -------- 미리 구현된 클래스의 집합
                     ---------------------
                      기본 틀이 제작 되어있는 상태 => 틀에 맞게 구현
                      ------------------------
                       XML - 태그와 속성이 스프링 동작에 맞게 제작되어 있음
                             클래스 메모리 할당 => 객체 생성
                             <bean> 하나의 클래스를 메모리 할당
                             <context:component-scan> : 패키지 단위 객체 생성
                             ------------------------
                              | 객체 생성요청 / 객체 생성(X) => 인터페이스, VO, 임시 클래스는 제외
                                 => 어노테이션으로 표시
                                     - 개발자 직접 제어 => VO, MainClass...
                                     - 스프링이 관리 => DAO, Manager, Service, Model(Controller)...
                                     - 가비지 컬렉션 => 필요없는 객체 메모리를 회수
                                        => 프로그램 종료 시 => new / 필요없는 객체 소멸
                                        => 핵심 코딩만 수행 / 사용
                              | 개발자의 수준과 실력에 상관 없이 일정한 수준의 개발 가능
                                 => 형식 동일
                                 => MyBatis, Spring
                                     => SQL : 경우의 수(JOIN, SUBQUERY, 문장 2개...)
                              | 초보자도 많은 시간을 투자하지 않고 유지보수 가능
                              | 무료(오픈 소스) => 개발시간 단축 => MVC 동작 기본틀 => 기능 
                                 - Model(@Controller) : 결과 값 전송
                                 - DAO : 데이터 관리
                                 - JSP : 결과 값 출력
                              | 많은 기능 => 학습하는 시간이 오래 걸린다. => 버전 갱신이 잦음(3개월)
                              | 프로그램 자체가 무거움 => 속도 저하
                                                      -------- Jquery3 => 4, 5
                              | LG, 한화 => Vue / 삼성, 현대 => React / 금융권 => React
                                ----------------------------------------------------
                                  1. DI(값 주입) => 스프링에서 객체 생성 시 사용 => 필요한 데이터가 존재할 경우 => 객체 멤버변수 초기화
                                      초기화 방식
                                        - 명시적 초기화
                                           String driver="oracle..." => 거의 사용 X
                                        - setter DI 
                                           p:변수명=값
                                        - 생성자 DI 
                                           c:매개변수명=값...
                                        - 객체 주소 값 대입
                                           p:객체명-ref="id"
                                          -------------------
                                           @Autowired
                                      객체 생성
                                        @Component => AOP, 일반 클래스(~Manager)
                                        @Repository => DAO => 테이블 1개를 제어
                                        @Service => 관련된 BI => 관련된 DAO 여러개 한번에 제어
                                        @Controller => Model => 화면 변경 => Router
                                        @RestController => Model => 다른 프로그램과 연결 => JSON => javaScripte
                                        @ControllerAdvice => 공통 예외처리
                                        --------------------------------
                         AOP => 필요마다 공통된 기능을 모아서 관리 => 자동 호출 가능
                                 | 소스 중복 제거, 공통으로 적용 => 자동화 처리
                                 => 어떤 메소드에서 적용 | 메소드의 영역
                                    -----------------   -----------
                                     | PointCut          | JoinPoint
                                                            @Before => aaa()
                                                            @Atfer => bbb()
                                                            @After-Throwing => ccc()
                                                            @Atfter-Returning => ddd()
                                                            @Around
                                     ------------------------------- Advice
                                      PintCut => execution("* 패키지.클래스명.메소드명(변수명...)")
                                                            - 리턴형         ------ *, 시작*
                                                              매개변수 :...
                                      => Controller 적용
                                         public String board_int(Stirng page, Model model)
                                         {
                                         	@Before => 메소드 적용
                                         	aaa()
                                         	try
                                         	{
                                         		---------------- Around start => log, transaction, 보안
                                         		  소스 코딩
                                         		---------------- Around end
                                         	}catch
                                         	{
                                         		After_Throwing
                                         		ccc()
                                         	}finally
                                         	{
                                         		@After
                                         		bbb()
                                         	}
                                         	return "" @After-Returning ddd()
                                         }
                         ORM => MyBatis 연동 
                                 - XML / Annotation / XML+Annotation
                                                      --------------- SQL 문장이 길거나 복잡한 SQL => XML
                                                       ("<trim prefix=\"OR\"...>")
                                JPA 연동
                                 - 자동화(SQL 문장을 자동으로 생성)
                                   SQL + 자동화
                         MVC
                          동작
                            브라우저 요청 => http://localhost:8080/web/databoard/list.do
                             1. DispatcherServlet 요청을 받는다.
                             2. HandlerMapping 전송 => databoard/list.do 
                                 => @GetMapping("databoard/list.do") 
                                     - 하위 메소드 호출
                                     - 전송 값 model.addattribute()
                                     - JSP 전송 return "..."
                             3. ViewResolver 전송 받은 ModelAndView => JSP 출력
                             
                             DAO / Model / JSP
                             --- 핵심
                       Annotation
 */
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;
import com.sist.dao.*;
@Controller
public class DataBoardController {
	@Autowired
	private DataBoardDAO dDao;
	
	@Autowired
	private FileInfoDAO fDao;
	
	@GetMapping("databoard/list.do")
	// list.do?page=1
	public String databoard_list(String page, Model model)
	{
		// request 대신 JSP 전송하는 객체 : Model
		// reqeust => Cookie
		// response => Cookie 저장, 다운로드 시에 사용
		/*
		   매개변수로 데이터를 받는 경우
		    => 값이 없는 경우 (ull 값이 들어간다)
		    => 모든 값이 존재하는 경우 : 해당 데이터형
		    => 요청 값을 받는 경우
		       ----------------
		        1. 순서가 없다.
		        2. 모든 요청 값은 String으로 받을 수 있다.
		        3. 데이터형 변경 요청
		        4. 커맨드 객체 => 여러개가 동시에 => VO
		        5. List, String[]
		           |      | 동적쿼리
		         파일 업로드
		        6. JSP 내장 객체를 받을 수 있다.
		            HttpServletRequest
		            HttpServletResponse
		            HttpSession
		            RedirceAttribute
		            ServletContext => application realPath     
		 */
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		List<DataBoardVO> list=dDao.boardListData((curpage*10)-9, curpage*10);
		int count=dDao.boardRowCount();
		int totalpage=(int)(Math.ceil(count/10.0));
		count=count-((curpage*10)-10);
		// 전송
		model.addAttribute("list", list); // ${list}
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("count", count);
		// JSP는 Spring과 관련 X
		return "databoard/list";
	}
	@GetMapping("databoard/insert.do")
	public String databoard_insert()
	{
		return "databoard/insert";
	}
	@PostMapping("databoard/insert_ok.do")
	public String databoard_insert_ok(DataBoardVO vo)
	{
		List<MultipartFile> list=vo.getFiles();
		System.out.println("전송된 파일 수 : "+list.size());
		String path="c:\\download\\";
		try {
			if(list.size()==0)
			{
				vo.setFilecount(0);
			}else
			{
				vo.setFilecount(list.size());
			}
			
			int no=dDao.boardInsert(vo);
			// 입력된 데이터의 번호를 읽기 => 참조 번호
			FileInfoVO fvo=new FileInfoVO();
			// 파일 저장 => 데이터 베이스 저장
			if(list.size()>0)
			{
				for(MultipartFile mf:list)
				{
					String filename=mf.getOriginalFilename();
					File file=new File(path+filename);
					mf.transferTo(file); // 업로드
					
					fvo.setFilename(filename);
					fvo.setFilesize(file.length());
					fvo.setNo(no);
					
					fDao.boardFileInsert(fvo);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:list.do";
	}
	@GetMapping("databoard/detail.do")
	public String databoard_detail(int no, Model model)
	{
		// 화면 이동과 같은 연결하는 상황에서는 String
		DataBoardVO vo=dDao.databoardDetailData(no);
		List<FileInfoVO> list=fDao.fileListData(no);
		model.addAttribute("vo", vo);
		model.addAttribute("list", list);
		return "databoard/detail";
	}
	@GetMapping("databoard/download.do") 
	public void databoard_download(String fn, HttpServletResponse res)
	{
		// 화면 이동 없이 출력하는 상황 void
		try {
			File file=new File("c:\\download\\"+fn);
			// 파일명 / 파일 크기
			res.setContentLength((int)file.length());
			res.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fn, "UTF-8"));
			BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
			// 서버에서 파일 읽기 => 클라이언트에 복사
			BufferedOutputStream bos=new BufferedOutputStream(res.getOutputStream());
			byte[] buffer=new byte[1024];
			int i=0; // 읽은 byte의 수
			while((i=bis.read(buffer, 0, 1024))!=-1)
			{
				bos.write(buffer, 0, i);
			}
			bis.close();
			bos.close();
		} catch (Exception e) {}
	}
	@GetMapping("databoard/delete.do")
	public String databoard_delete(int no, Model model)
	{
		model.addAttribute("no", no);
		return "databoard/delete";
	}
	@GetMapping("databoard/update.do")
	public String databoard_update(int no, Model model)
	{
		DataBoardVO vo=dDao.databoardUpdateData(no);
		model.addAttribute("vo", vo);
		return "databoard/update";
	}
}
