package com.PostMethod;

import com.HttpUtils.HttpMethod;

public class Get_UserData {
	public String Do_Get(String cookie){
		HttpMethod Post=new HttpMethod();
		Post.Go_Home(cookie);
		System.out.println(Post.Money+"-----------=========="+Post.Name);
		return Post.Money+"   "+Post.Name;
		
	}
}
