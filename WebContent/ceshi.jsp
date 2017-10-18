<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试页面</title>
</head>
<jsp:useBean id="vc" class="com.ysk.databaseutils.Verify_Cookies"></jsp:useBean>
<jsp:useBean id="se" class="com.ysk.SendEmailDemo.sendmail"></jsp:useBean>
<jsp:useBean id="ge" class="com.ysk.databaseutils.Get_email"></jsp:useBean>



<%  String cookie =String.valueOf(session.getAttribute("http_cookie"));
	  if(!vc.vcookie(cookie)){
		   response.setHeader("refresh", "1;URL=login.html");
	   }else{
		   String email=ge.getemail(cookie);
		  	se.setTo(email);
		  	se.run();
		  	response.setHeader("refresh", "1;URL=HomeNew.jsp");
		  out.print("邮件已发送，请注意查收！");
	   }
	  
	   %>

<body>
		
</body>
</html>