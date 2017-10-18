<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>邮箱绑定中...</title>
</head>
 <jsp:useBean id="gu" class="com.ysk.databaseutils.Get_UserInfo"></jsp:useBean>
  <jsp:useBean id="se" class="com.ysk.databaseutils.Set_Email"></jsp:useBean>
    <jsp:useBean id="ve" class="com.ysk.Utils.Vemail"></jsp:useBean>
<%  String email=request.getParameter("yx");
	String cookie =String.valueOf(session.getAttribute("http_cookie"));
	String user=gu.getuserinfo(cookie);
	if(ve.vemail(email)){
		out.print("邮箱数据正在提交...");
		se.setemail(email, user);
	}else{
		out.print("输入邮箱不合法");
	}
	
	
	response.setHeader("refresh", "1;URL=HomeNew.jsp");
	
%>
<body>
	<!--  获取cookie,根据cookie获取到使用者，把邮箱写进数据库里。 -->
</body>
</html>