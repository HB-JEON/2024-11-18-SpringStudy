package com.sist.vo;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class DataBoardVO {
	private int no, hit, filecount, replycount;
	private String name, subject, content, pwd, filename, filesize, dbday;
	private Date regdate;
	// upload
	private List<MultipartFile> files;
}