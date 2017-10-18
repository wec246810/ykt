package com.DataBaseUtils;

import java.util.List;

public class Mytest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Post_UserPwd persion=new Post_UserPwd();
//		persion.do_Post("1462141939", "091516");
		Get_UserPwd person=new Get_UserPwd();
		List<String> User=person.Get_WeChatData("1");
		System.out.println("UserName=="+User.get(0)+"\n"+"UserPwd=="+User.get(1));
	}

}
