package com.Demo;

import com.HttpUtils.HttpMethod;
import com.Jsoup.JSOUP_Method;
import com.Jsoup.JsoupMethod;

import net.sf.json.JSONArray;
//��������Ϣ��ȫһ���ķ���������ɾ��,���׻��ܣ��Ȳ�����
public class User_CustStateInfo {
	HttpMethod User=new HttpMethod();
	public JSONArray Get_User_CustStateInfo(String cookie,String ftime,String ltime){
		User.Get_Post_CustStateInfo(cookie);
	
			String html=User.Post_CustStateInfo(cookie, ftime, ltime);
			JSOUP_Method jsoup=new JSOUP_Method(html);
		return jsoup.Get_User_CustStateInfo(true); 
		
	
	}
}
