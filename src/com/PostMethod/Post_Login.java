package com.PostMethod;

import com.HttpUtils.HttpMethod;

public class Post_Login {
	
	public String Do_Post(String UserName,String Password){
		String result=null;
		HttpMethod Post=new HttpMethod();
		Post.Get_Post();
		do{
			if(result!=null)
			System.out.println("this is Post ...="+result);
			Post.GetYzm();
			System.out.println("UserName :"+UserName+"Password"+Password);
			result=Post.HttpLoginPost(UserName, Password);
			//��Ҫ������д�뵽���ݿ�
		}while(result.contains("��֤�����"));
		
		return result;
		
	}
}
