package com.sist.vo;

import lombok.Data;

/*
USERID             VARCHAR2(20) 
AUTHORITY NOT NULL VARCHAR2(20)
 */
@Data
public class AutorityVO {
	private String userid, authority;
}
