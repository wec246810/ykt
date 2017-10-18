package com.PostMethod;

import com.HttpUtils.HttpMethod;

public class Post_PwdLoss {

	public String Do_Get(String cookie,String txtOutID,String txtPwd,String txtIDcardNo,String txtNewpwd){
		String result=null;
		HttpMethod Post=new HttpMethod();
		Post.Get_Post_PwdLoss();
		result=Post.Post_PwdLoss(cookie, txtOutID, txtPwd, txtIDcardNo, txtNewpwd);
		return result;
		
	}
}
