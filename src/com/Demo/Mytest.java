package com.Demo;


import com.HttpUtils.HttpMethod;
import com.Jsoup.JSOUP_Method;
import com.Jsoup.JsoupMethod;
import com.ysk.databaseutils.Get_Cookies;
import com.ysk.databaseutils.Set_Cookies;
import com.ysk.databaseutils.Verify_Cookies;



public class Mytest {

	public static void main(String[] args) {
		String result=null;
		String user="1462141915";
		String pwd="151234";
		HttpMethod Post=new HttpMethod();
		User_Base user_Base=new User_Base();
		User_ConsumeInfo uc=new User_ConsumeInfo();
		User_CustStateInfo uci=new User_CustStateInfo();
		Get_Cookies gc =new Get_Cookies();
		Verify_Cookies vc=new Verify_Cookies();
		User_BankInfo ub=new User_BankInfo();
		Set_Cookies sc=new Set_Cookies();
//		JSOUP_Method jm=new JSOUP_Method(result);
		Post.Get_Post();
		
		do{
			if(result!=null)
			System.out.println(result);
			Post.GetYzm();
			if(vc.vcookie(gc.get_cookies(user))){
				result=gc.get_cookies(user);
				System.out.println("cookies���ã������ݿ��ȡ"+result);
			}else{
				
				result=Post.HttpLoginPost(user, pwd);
				sc.setcookie(result,user);
				System.out.println("cookies�����ã������»�ȡ��ϣ��µ�cookiesΪ:"+result);
			}
			
			
			
		}while(result.contains("��֤�����"));
//		String s="1:2:3,4,5";
//		//�ַ����ָ�
//		System.out.println(jm.splits(s));
		//����������Ϣ
//		user_Base.Get_User_Base(result);
		//�������Ѽ�¼
//		uc.Get_User_ConsumeInfo(result,"2017-04-15","2017-04-14");
		//����Ȧ����Ϣ
		ub.Get_BankInfo(result,"2017-03-14","2017-04-14");
		//���׻�����Ϣ
//		uci.Get_User_CustStateInfo(result,"2017-04-14","2017-04-14");
//		System.out.println("���"+result);
//	    Post.Go_Home(result);
//	    String cookie=Post.cookiestr[0];
//	    System.out.println("��ѯ��cookie=="+cookie);
//		System.out.println(Post.Money+"---");
//		System.out.println(Post.Name);
		
		
		//��ȡ���Ѽ�¼
//		Post.Get_Post_ConsumeInfo(cookie);
//		Post.Post_ConsumeInfo(cookie,1,"2016-01-23","2017-02-27");
		
		//��ȡ�����ѽ��
//		Post.Get_Post_CustStateInfo(cookie);
//		Post.Post_CustStateInfo(cookie,"2013-02-23","2017-02-27");

		//�����Ϣ��ѯ
//		Post.Get_Post_depositinfo(cookie);
//		Post.Post_depositinfo(cookie, 0, "2013-02-23","2017-02-27");
		
		//������ʧ ��һ��������ѯ���� �ڶ����������֤��
//		Post.Get_Post_UserLoss(cookie);
//		Post.Post_UserLoss(cookie, "09151", "15111");
		
		//�޸�����  1.������ 2.������
//		Post.Get_Post_UpdatePwd(cookie);
//		Post.Post_UpdatePwd(cookie, "1516", "123");
		
		//�һ�����
//		Post.Get_Post_PwdLoss();
//		Post.Post_PwdLoss("", "", "", "", "");
		
		
	}
	
	
	
	public void login(){
		
		/*
		 * ��½�ɹ� ����json���� 
		 * json���ݰ���
		 */
		
		
	}
	//�Ƿ�ֻ��Ҫ��cookie���浽��ҳ�����л���������������Ҳ��Ҫ���棬������
	//cookie���м��ܣ�
	//��ҳ���ֻ����Խ�������Ӧ
	//��ѯ���������
	//�޸�����ҳ�������
	
	/*
	 * 1.��½ҳ��     2.��ʧҳ��
	 * 2.��½�ɹ�������Ϣ��ȡ
	 * 3.�鿴���Ѽ�¼
	 * 4.�ͷ���֧��
	 * 5.����¼
	 * 6.�޸�����
	 * 7.������ʧ
	 * 
	 * ��
	 * 
	 */
	
	/*
	 * Ӧ�ý�������
	 * 
	 * ������Ϣ��¼����
	 * 
	 */
}
