package com.sist.vo;

import lombok.Data;
import java.util.*;
/*
이름         널?       유형             
---------- -------- -------------- 
NO         NOT NULL NUMBER         
NAME       NOT NULL VARCHAR2(51)   
SUBJECT    NOT NULL VARCHAR2(2000) 
CONTENT    NOT NULL CLOB           
PWD        NOT NULL VARCHAR2(10)   
REGDATE             DATE           
HIT                 NUMBER         
GROUP_ID            NUMBER         
GROUP_STEP          NUMBER         
GROUP_TAB           NUMBER         
ROOT                NUMBER         
DEPTH               NUMBER         

 */
@Data
public class BoardVO {
	private int no, hit, group_id, group_step, group_tab, root, depth;
	private String name, subject, content, pwd;
	private Date regdate;
}