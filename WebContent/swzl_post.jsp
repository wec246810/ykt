<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@page import="java.util.Date"%>
    <%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>失误招领跳转页</title>
</head>
 <jsp:useBean id="is" class="com.ysk.databaseutils.Insert_Swzl"></jsp:useBean>
 <jsp:useBean id="ix" class="com.ysk.databaseutils.Insert_Xwqs"></jsp:useBean>
  <jsp:useBean id="gu" class="com.ysk.databaseutils.Get_UserInfo"></jsp:useBean>
<%
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
String time=df.format(new Date());// new Date()为获取当前系统时间
String contact =request.getParameter("contact");
String Cookie =String.valueOf(session.getAttribute("http_cookie"));
String user=gu.getuserinfo(Cookie);
//out.print(user);
String info= new String(request.getParameter("info").getBytes("iso-8859-1"),"UTF-8");
String a=request.getParameter("s");
if(!contact.equals("")&&!info.equals("")){
	if(a.equals("zsz")){
		ix.insert_xwqs(time, contact, info,user);
	}else if(a.equals("zdx")){
		is.insert_swzl(time, contact, info,user);}
		out.print("提交成功，正在跳转...");
		//su.setuserinfo(Cookie, name, classes, sex);
	 response.setHeader("refresh", "1;URL=swzl.jsp");
}else{
	out.print("所有项必须填哦！");
	response.setHeader("refresh", "1;URL=swzl.html");
}
%>
<body>
	
</body>
</html>