package com.sist.vo;

import lombok.Data;
import java.util.*;

@Data
public class ReserveVO {
	private int rno, fno, isReserve;
	private String userid, rday, rtime, rinwon, dbday;
	private Date regday;
	private FoodVO fvo=new FoodVO();
	private MemberVO mvo=new MemberVO();
}
