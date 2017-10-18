package com.PostMethod;

import com.HttpUtils.HttpMethod;
import com.Jsoup.JsoupMethod;

public class Get_CustStateInfo {
	public String Do_Get(String cookie,String fname,String lname){
		
		JsoupMethod Jsoup=new JsoupMethod();
		
		String result=null;
		HttpMethod Post=new HttpMethod();
		Post.Get_Post_CustStateInfo(cookie);
		System.out.println(fname);
		System.out.println("2017-02-27");
		result=Post.Post_CustStateInfo(cookie,fname,lname);
//		System.out.println("0000000000000000000000000");
		Jsoup=new JsoupMethod();
		Jsoup.setDoc(result);
		Jsoup.Get_CustStateInfo_List();
		Jsoup.GetPage();
		return result;
		
	}
}
