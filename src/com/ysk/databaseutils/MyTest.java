package com.ysk.databaseutils;

public class MyTest {
	public static void main(String args[]){
		//���cookies
		Get_Cookies gc=new Get_Cookies();
//		System.out.println(gc.get_cookies("1462141947"));
		//����cookies
//		setcookies st=new setcookies();
//		st.setcookie("123","1462141947");
		//��֤cookies;
//		Verify_Cookies vc=new Verify_Cookies();
//		vc.vcookie(gc.get_cookies("1462141947"));
//		�����û�
		Add_User au=new Add_User();
		au.adduser("123", "132456");
		//ʧ�������ѯ
//		Query_swzl qs= new Query_swzl();
//		System.out.println(qs.query_swzl());
		//Ѱ������
//		Query_xwqs qx=new Query_xwqs();
//		System.out.println(qx.query_xwqs());
		//�û�����ʧ������
//		Insert_Swzl is=new Insert_Swzl();
//		is.insert_swzl("2017-04-16", "1575555", "����");
		//�û�����Ѱ������
//		Insert_Xwqs ix=new Insert_Xwqs();
//		ix.insert_xwqs("2017-04-16", "23", "����");
		//��ѯ�û�
//		Query_User qu=new Query_User();
//		qu.query_user("1462141939");
	}
}
