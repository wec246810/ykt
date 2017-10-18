package com.PostMethod;

import com.HttpUtils.HttpMethod;
//POST¸üÐÂÃÜÂë
public class Post_UpdatePwd {

	public String Do_Get(String cookie,String ctl00$ContentPlaceHolder1$txtPwd,String ctl00$ContentPlaceHolder1$txtNewCode){
		String result=null;
		HttpMethod Post=new HttpMethod();
		Post.Get_Post_UpdatePwd(cookie);
		result=Post.Post_UpdatePwd(cookie, ctl00$ContentPlaceHolder1$txtPwd, ctl00$ContentPlaceHolder1$txtNewCode);
		return result;
		
	}
}
