package com.Demo;

import com.HttpUtils.HttpMethod;
import com.Jsoup.JSOUP_Method;
import com.Jsoup.JsoupMethod;

import net.sf.json.JSONArray;

public class User_BankInfo {
	HttpMethod User=new HttpMethod();
	public JSONArray Get_BankInfo(String cookie,String ftime,String ltime){
		JSONArray ja =new JSONArray();
		JsoupMethod jm= new JsoupMethod();
		User.Get_Post_BankInfo(cookie);
		String html1=User.Post_BankInfo(cookie, 1, ftime, ltime);
		jm.setDoc(html1);
		System.out.println(jm.GetPage());
		if(jm.GetPage()>1){
			for(int i=1;i<=jm.GetPage();i++){
				String html=User.Post_Page_BankInfo(cookie, i, ftime, ltime);
				JSOUP_Method jsoup=new JSOUP_Method(html);
				System.out.println("解析的页数为"+i);
				ja.add(jsoup.Get_User_BankInfo(true));
			}}else{
				String html=User.Post_BankInfo(cookie, 1, ftime, ltime);
				JSOUP_Method jsoup=new JSOUP_Method(html);
				ja.add(jsoup.Get_User_BankInfo(true));
			}
			System.out.println(ja);
			System.out.println(ja.size());
//		JSOUP_Method jsoup=new JSOUP_Method(html);
//		jsoup.Get_User_BankInfo(true);
//		JsoupMethod jm= new JsoupMethod();
//		jm.setDoc(html);
//		System.out.println(jm.GetPage());
		return ja;
	}
}
