package com.sist.web;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.vo.*;
import com.sist.manager.*;
/*
    1. JSON 파싱
    2. XML 파싱
      Open API => JSON / XML => 파이썬
      
      빅데이터
       데이터
        1) 정형화 데이터 : 데이터베이스
        2) 반정형화 데이터 : 구분 => JSON / XML / HTML
        3) 비정형화 데이터 : 트위터 / 페이스북
           ------- 정형화된 데이터 변환
                   ------------- 시각화 => 예측(머신러닝, 딥러닝)
                                          -------------------
                                           | AI
           날씨 예측 / 지하철 / 범죄 예측
           파이썬 => 넘파일 / 판다스 / MatPlotLib
           -----------------------------------
 */
@RestController
public class MovieRestController {
	@Autowired
	private YoutubeManager ym;
	
	@GetMapping("movie/find_vue.do")
	public Map movie_find(String fd)
	{
		Map map=new HashMap();
		// 동영상 제목 / 동영상 키
		// http://localhost:8080/web/movie/find_vue.do?fd=%EB%B6%80%EC%82%B0%EC%97%AC%ED%96%89
		try
		{
			String json=ym.youtubeJsonData(fd);
//			System.out.println(json);
			JSONParser jp=new JSONParser();
			JSONObject root=(JSONObject)jp.parse(json);
			JSONArray items=(JSONArray)root.get("items");
			List<MovieVO> list=new ArrayList<MovieVO>();
			for(int i=0; i<items.size(); i++)
			{
				JSONObject obj=(JSONObject)items.get(i);
				MovieVO vo=new MovieVO();
				JSONObject id=(JSONObject)obj.get("id");
				String key=(String)id.get("videoId");
				JSONObject sni=(JSONObject)obj.get("snippet");
				String title=(String)sni.get("title");
				
				vo.setTitle(title);
				vo.setVideoId(key);
				list.add(vo);
			}
			map.put("list", list);
		}catch(Exception e) {}
		return map;
	}
}
