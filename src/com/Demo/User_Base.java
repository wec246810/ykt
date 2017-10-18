package com.Demo;

import com.HttpUtils.HttpMethod;
import com.Jsoup.JSOUP_Method;
import com.google.gson.JsonArray;

import net.sf.json.JSONArray;

public class User_Base {
	HttpMethod User=new HttpMethod();
	public JSONArray Get_User_Base(String cookie){
		
		String html=User.Go_Home(cookie);
		System.out.println(html);
		JSOUP_Method jsoup=new JSOUP_Method(html);
		System.out.println("2-----------------------");
		return jsoup.Get_User_Base(true);
		
	}
}
