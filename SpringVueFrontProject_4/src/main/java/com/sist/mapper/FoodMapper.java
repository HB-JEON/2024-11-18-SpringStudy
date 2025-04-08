package com.sist.mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.*;

import com.sist.vo.*;
public interface FoodMapper {
   @Select("SELECT fno,poster,name, num "
         + "FROM (SELECT fno,poster,name,rownum as num "
         + "FROM (SELECT /*+INDEX_ASC(project_food pf_fno_pk)*/fno,poster,name "
         + "FROM project_food ORDER BY fno ASC)) "
         + "WHERE num BETWEEN #{start} AND #{end}")
   public List<FoodVO> foodListData(@Param("start") int start,
          @Param("end") int end);
   
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food")
   public int foodTotalPage();
   
   @Select("SELECT fno,poster,name, address, num "
	         + "FROM (SELECT fno,poster,name, address, rownum as num "
	         + "FROM (SELECT /*+INDEX_ASC(project_food pf_fno_pk)*/fno,poster,name, address "
	         + "FROM project_food "
	         + "WHERE address LIKE '%'||#{fd}||'%')) "
	         + "WHERE num BETWEEN #{start} AND #{end}")
	   public List<FoodVO> foodFindListData(Map map);
	   
	   @Select("SELECT CEIL(COUNT(*)/12.0) FROM project_food "
	   		+ "WHERE address LIKE '%'||#{fd}||'%'")
	   public int foodFindTotalPage(String fd);
}
