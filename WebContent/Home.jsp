<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>一卡通中心</title>
</head>
 <jsp:useBean id="vc" class="com.ysk.databaseutils.Verify_Cookies"></jsp:useBean>
  <%  String cookie =String.valueOf(session.getAttribute("http_cookie"));
	  if(!vc.vcookie(cookie)){
		   response.setHeader("refresh", "1;URL=login.html");
	   }else{
		   response.setHeader("refresh", "1;URL=HomeNew.jsp");
	   }
	   %>
<body>

</html>