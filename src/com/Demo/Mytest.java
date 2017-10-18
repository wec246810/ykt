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
				System.out.println("cookies可用，从数据库调取"+result);
			}else{
				
				result=Post.HttpLoginPost(user, pwd);
				sc.setcookie(result,user);
				System.out.println("cookies不可用，已重新获取完毕，新的cookies为:"+result);
			}
			
			
			
		}while(result.contains("验证码错误"));
//		String s="1:2:3,4,5";
//		//字符串分割
//		System.out.println(jm.splits(s));
		//解析基本信息
//		user_Base.Get_User_Base(result);
		//解析消费记录
//		uc.Get_User_ConsumeInfo(result,"2017-04-15","2017-04-14");
		//解析圈存信息
		ub.Get_BankInfo(result,"2017-03-14","2017-04-14");
		//交易汇总信息
//		uci.Get_User_CustStateInfo(result,"2017-04-14","2017-04-14");
//		System.out.println("结果"+result);
//	    Post.Go_Home(result);
//	    String cookie=Post.cookiestr[0];
//	    System.out.println("查询的cookie=="+cookie);
//		System.out.println(Post.Money+"---");
//		System.out.println(Post.Name);
		
		
		//获取消费记录
//		Post.Get_Post_ConsumeInfo(cookie);
//		Post.Post_ConsumeInfo(cookie,1,"2016-01-23","2017-02-27");
		
		//获取总消费金额
//		Post.Get_Post_CustStateInfo(cookie);
//		Post.Post_CustStateInfo(cookie,"2013-02-23","2017-02-27");

		//存款信息查询
//		Post.Get_Post_depositinfo(cookie);
//		Post.Post_depositinfo(cookie, 0, "2013-02-23","2017-02-27");
		
		//自助挂失 第一个参数查询密码 第二个参数身份证号
//		Post.Get_Post_UserLoss(cookie);
//		Post.Post_UserLoss(cookie, "09151", "15111");
		
		//修改密码  1.旧密码 2.新密码
//		Post.Get_Post_UpdatePwd(cookie);
//		Post.Post_UpdatePwd(cookie, "1516", "123");
		
		//找回密码
//		Post.Get_Post_PwdLoss();
//		Post.Post_PwdLoss("", "", "", "", "");
		
		
	}
	
	
	
	public void login(){
		
		/*
		 * 登陆成功 返回json数据 
		 * json数据包含
		 */
		
		
	}
	//是否只需要将cookie保存到网页缓存中还是其他两个参数也需要保存，待测试
	//cookie进行加密？
	//网页对手机电脑进行自适应
	//查询界面的制作
	//修改密码页面的制作
	
	/*
	 * 1.登陆页面     2.挂失页面
	 * 2.登陆成功进本信息获取
	 * 3.查看消费记录
	 * 4.餐费总支出
	 * 5.存款记录
	 * 6.修改密码
	 * 7.自助挂失
	 * 
	 * 表单
	 * 
	 */
	
	/*
	 * 应用界面制作
	 * 
	 * 个人信息记录制作
	 * 
	 */
}
