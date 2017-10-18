<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
       <meta charset="utf-8">
 
        <title>一卡通修改密码</title>
   
</head>
<body>
 <jsp:useBean id="Post" class="com.PostMethod.Post_UpdatePwd"></jsp:useBean>
  <jsp:useBean id="sp" class="com.ysk.databaseutils.Set_Pwd"></jsp:useBean>
  <jsp:useBean id="vc" class="com.ysk.databaseutils.Verify_Cookies"></jsp:useBean>
<%
	if(request.getParameter("npwd").equals(request.getParameter("npwd1"))){
		String cookie =String.valueOf(session.getAttribute("http_cookie"));
		  if(!vc.vcookie(cookie)){
			   response.setHeader("refresh", "1;URL=login.html");
		   }
		//out.println(cookie);
		String ctl00$ContentPlaceHolder1$txtPwd=request.getParameter("opwd");
		String ctl00$ContentPlaceHolder1$txtNewCode=request.getParameter("npwd");	
		String result=Post.Do_Get(cookie, ctl00$ContentPlaceHolder1$txtPwd, ctl00$ContentPlaceHolder1$txtNewCode);
		//sp.setcookie(ctl00$ContentPlaceHolder1$txtNewCode, uid);
		out.print("修改密码成功");
		response.setHeader("refresh", "1;URL=HomeNew.jsp");
	}
	else{
		out.print("两次输入密码不一致");
	}
	//out.println(result);
%>
<!-- 以下为html页面 -->
    
</body>
</html>