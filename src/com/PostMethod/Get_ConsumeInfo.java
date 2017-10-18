package com.PostMethod;


import com.HttpUtils.HttpMethod;
import com.Jsoup.JsoupMethod;

public class Get_ConsumeInfo {
	JsoupMethod Jsoup=null;
	String result="";
	public String Do_Get(String cookie,int n,String fname,String lname){
		
		String result=null;
		HttpMethod Post=new HttpMethod();
		Post.Get_Post_ConsumeInfo(cookie);
		result=Post.Post_ConsumeInfo(cookie,1,fname,lname);
		Jsoup=new JsoupMethod();
		Jsoup.setDoc(result);
		Jsoup.Get_ConsumeInfo_List();
		return result;
	}
	public int GetPageNum(){
		return Jsoup.GetPage();
	}
	public String  GetInfoData(){
//		Jsoup.Get_ConsumeInfo_List();
		return result;
	}
}
