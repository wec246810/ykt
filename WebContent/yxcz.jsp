<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <jsp:useBean id="re" class="com.ysk.databaseutils.rset_email"></jsp:useBean>
<title>邮箱重置</title>
</head>
<%
	String cookie =String.valueOf(session.getAttribute("http_cookie"));
	re.restemail(cookie);
	out.print("邮箱已重置");
	response.setHeader("refresh", "1;URL=HomeNew.jsp");
%>
<body>
	
</body>
</html>