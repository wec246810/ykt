package com.ysk.databaseutils;

public class MyTest {
	public static void main(String args[]){
		//获得cookies
		Get_Cookies gc=new Get_Cookies();
//		System.out.println(gc.get_cookies("1462141947"));
		//设置cookies
//		setcookies st=new setcookies();
//		st.setcookie("123","1462141947");
		//验证cookies;
//		Verify_Cookies vc=new Verify_Cookies();
//		vc.vcookie(gc.get_cookies("1462141947"));
//		增加用户
		Add_User au=new Add_User();
		au.adduser("123", "132456");
		//失物招领查询
//		Query_swzl qs= new Query_swzl();
//		System.out.println(qs.query_swzl());
		//寻物启事
//		Query_xwqs qx=new Query_xwqs();
//		System.out.println(qx.query_xwqs());
		//用户增加失物招领
//		Insert_Swzl is=new Insert_Swzl();
//		is.insert_swzl("2017-04-16", "1575555", "测试");
		//用户增加寻物启事
//		Insert_Xwqs ix=new Insert_Xwqs();
//		ix.insert_xwqs("2017-04-16", "23", "测试");
		//查询用户
//		Query_User qu=new Query_User();
//		qu.query_user("1462141939");
	}
}
