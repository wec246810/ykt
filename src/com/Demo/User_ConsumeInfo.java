package com.Demo;

import com.HttpUtils.HttpMethod;
import com.Jsoup.JSOUP_Method;
import com.Jsoup.JsoupMethod;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
//消费信息
public class User_ConsumeInfo {
	HttpMethod User=new HttpMethod();
	public JSONArray Get_User_ConsumeInfo(String cookie,String ftime,String ltime){
		User.Get_Post_ConsumeInfo(cookie);
		JSONArray ja=new JSONArray();
		JsoupMethod jm= new JsoupMethod();
		String html1=User.Post_ConsumeInfo(cookie, 1, ftime, ltime);
		jm.setDoc(html1);
		System.out.println(jm.GetPage());
		if(jm.GetPage()>1){
		for(int i=1;i<=jm.GetPage();i++){
			String html=User.Post_Page_ConsumeInfo(cookie, i, ftime, ltime);
			JSOUP_Method jsoup=new JSOUP_Method(html);
			System.out.println("解析的页数为"+i);
			ja.add(jsoup.Get_User_ConsumeInfo(true));
		}}else{
			String html=User.Post_ConsumeInfo(cookie, 1, ftime, ltime);
			JSOUP_Method jsoup=new JSOUP_Method(html);
			ja.add(jsoup.Get_User_ConsumeInfo(true));
		}
		System.out.println(ja);
		System.out.println(ja.size());
		return ja;
	
	}
}
