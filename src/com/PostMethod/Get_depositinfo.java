package com.PostMethod;

import com.HttpUtils.HttpMethod;
import com.Jsoup.JsoupMethod;

public class Get_depositinfo {
	JsoupMethod Jsoup=null;
	public String Do_Get(String cookie,int n,String fname,String lname){
		String result=null;
		HttpMethod Post=new HttpMethod();
		Post.Get_Post_depositinfo(cookie);
		System.out.println(fname);
		System.out.println("2017-02-27");
		result=Post.Post_depositinfo(cookie,n,fname,lname);
		Jsoup=new JsoupMethod();
		Jsoup.setDoc(result);
		Jsoup.Get_depositinfo_List();
		return result;
		
	}
	public void Get_list(){
		
	}
}
