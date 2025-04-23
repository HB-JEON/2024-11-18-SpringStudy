package com.sist.manager;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import org.springframework.stereotype.Component;

import com.sist.vo.*;

@Component
public class YoutubeManager {
	public static void main(String[] args) {
		YoutubeManager y=new YoutubeManager();
		y.youtubeJsonData("부산여행");
	}
	public String youtubeJsonData(String fd)
	{
		String result="";
		try
		{
			String strUrl="https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=25&q="+URLEncoder.encode(fd, "UTF-8")+"&type=video&key=AIzaSyBc5R3WaOUJjAwQu4V5bI9zj3qtVIHg1ds";
			URL url=new URL(strUrl);
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();
			StringBuffer sb=new StringBuffer();
			if(conn!=null) // 연결이 되었다면
			{
				BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
				while(true)
				{
					String s=in.readLine();
					if(s==null)
					{
						break;
					}
					sb.append(s);
				}
				
				result=sb.toString();
				
				in.close();
				conn.disconnect();
			}
			System.out.println(sb.toString());
		}catch(Exception e) {}
		return result;
	}
}
