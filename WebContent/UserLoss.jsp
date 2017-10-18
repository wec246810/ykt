<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>一卡通挂失</title>
</head>
<body>
 <jsp:useBean id="Post" class="com.PostMethod.Post_UserLoss"></jsp:useBean>
 <jsp:useBean id="vc" class="com.ysk.databaseutils.Verify_Cookies"></jsp:useBean>
<%
String cookie =String.valueOf(session.getAttribute("http_cookie"));
if(!vc.vcookie(cookie)){
	   response.setHeader("refresh", "1;URL=login.html");
}
	//out.println(cookie);
	String UserPwed=request.getParameter("ctl00$ContentPlaceHolder1$txtPwd");
	String UserSFZId=request.getParameter("ctl00$ContentPlaceHolder1$txtIDcardNo");
	String result=Post.Do_Get(cookie, UserPwed, UserSFZId);
	response.setHeader("refresh", "1;URL=HomeNew.jsp");
	//out.println(result);
%>
</body>
</html>