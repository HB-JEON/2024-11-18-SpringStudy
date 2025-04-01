package com.sist.web;

import java.io.File;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.DataBoardDAO;
import com.sist.dao.FileInfoDAO;
import com.sist.vo.DataBoardVO;
import com.sist.vo.FileInfoVO;
// 데이터 값을 보낼 때 => 자바스크립트와 통신 => 일반 문자열 / JSON
@RestController
public class DataBoardRestController {
	@Autowired
	private DataBoardDAO dDao;
	
	@Autowired
	private FileInfoDAO fDao;
	/*
	      <delete id="" parameterType="string">
	        declare
	        begin
	          DELETE FROM jjim WHERE id=#{id}
	          DELETE FROM like WHERE id=#{id}
	          DELETE FROM reply WHERE id=#{id}
	          DELETE FROM reserve WHERE id=#{id}
	          DELETE FROM cart WHERE id=#{id}
	          DELETE FROM buy WHERE id=#{id}
	        end
	      </delete>
	 */
	
	@GetMapping(value="databoard/delete_ok.do", produces="text/plain;charset=UTF8")
	public String databoard_delete_ok(int no, String pwd)
	{
		String result="no";
		String db_pwd=dDao.databoardGetPassword(no);
		List<FileInfoVO> list=fDao.fileListData(no);
		int count=dDao.databoardFileCount(no);
		
		if(db_pwd.equals(pwd))
		{
			result="yes";
			if(count>0)
			{
				fDao.fileInfoDelete(no); // 파일 정보 삭제
				try
				{
					// 실제 저장된 파일 삭제
					for(FileInfoVO vo:list)
					{
						File file=new File("c:\\download\\"+vo.getFilename());
						file.delete();
					}
				}catch(Exception e) {}
			}
			dDao.databoardDelete(no); // 게시물 삭제
		}
		
		return result;
	}
	@PostMapping(value="databoard/update_ok.do", produces="text/html;charset=UTF-8")
	public String databoard_update(DataBoardVO vo)
	{
		String js="";
		String db_pwd=dDao.databoardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			dDao.databoard_update(vo);
			js="<script>location.href=\"detail.do?no="+vo.getNo()+"\";</script>";
		}else
		{
			js="<script>"
				+"alert(\"비밀번호를 확인해주세요.\");"
				+"history.back();"
				+"</script>";
		}
		return  js;
	}
}
