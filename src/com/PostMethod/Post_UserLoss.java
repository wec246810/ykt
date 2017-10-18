package com.PostMethod;

import com.HttpUtils.HttpMethod;

public class Post_UserLoss {

	public String Do_Get(String cookie,String UserPwed,String UserSFZId){
		String result=null;
		HttpMethod Post=new HttpMethod();
		Post.Get_Post_UserLoss(cookie);
		result=Post.Post_UserLoss(cookie, UserPwed, UserSFZId);
		return result;
		
	}
}
