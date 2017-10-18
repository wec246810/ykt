package com.ysk.databaseutils;

import com.HttpUtils.HttpMethod;

public class Verify_Cookies {
	public Boolean vcookie(String cookies){
		HttpMethod Post=new HttpMethod();
		Post.Go_Home(cookies);
		if(Post.Money!=""){
			System.out.println("cookiesÕıÈ·");
			return true;
		}else{
			System.out.println("cookies´íÎó");
			return false;
		}
		
		
	}
}
