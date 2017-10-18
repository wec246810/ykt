<%@page import="com.ysk.databaseutils.Query_User"%>
<%@page import="net.sf.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆跳转</title>
</head>
<body>
 <jsp:useBean id="gc" class="com.ysk.databaseutils.Get_Cookies"></jsp:useBean>
  <jsp:useBean id="user_Base" class="com.Demo.User_Base"></jsp:useBean>
 <jsp:useBean id="vc" class="com.ysk.databaseutils.Verify_Cookies"></jsp:useBean>
 <jsp:useBean id="Post" class="com.PostMethod.Post_Login"></jsp:useBean>
  <jsp:useBean id="sc" class="com.ysk.databaseutils.Set_Cookies"></jsp:useBean>
   <jsp:useBean id="qu" class="com.ysk.databaseutils.Query_User"></jsp:useBean>
    <jsp:useBean id="au" class="com.ysk.databaseutils.Add_User"></jsp:useBean>
    <jsp:useBean id="sud" class="com.ysk.databaseutils.setuserdata"></jsp:useBean>
<%
String userName=request.getParameter("userName");
String password=request.getParameter("password");
String result=Post.Do_Post(userName, password);
String cookies =gc.get_cookies(userName);

if(result.contains("账户或密码错误")){
	out.print("账户或密码错误");
	response.setHeader("refresh", "1;URL=login.html");
}
else if(vc.vcookie(cookies)){
	out.println("cookies验证成功");
	session.setAttribute("http_cookie",cookies);
	response.setHeader("refresh", "1;URL=HomeNew.jsp");
	//out.print(cookies);
}else{
	String cookie=Post.Do_Post(userName, password);
	sc.setcookie(cookie, userName);
	if(!qu.query_user(userName)){
		au.adduser(userName, password);
		JSONArray ja= user_Base.Get_User_Base(cookie); 
		sud.setuserdata(userName, ja.getJSONObject(0).getString("姓名"), ja.getJSONObject(0).getString("单位"), ja.getJSONObject(0).getString("性别"));
		System.out.print("执行到了这里");
	}
	sc.setcookie(cookie, userName);
	out.println("登陆成功等待跳转");
	session.setAttribute("http_cookie",cookie);
	response.setHeader("refresh", "1;URL=HomeNew.jsp");
	//out.print(cookie);
}




%>
<%--原本在上方
String cookie=Post.Do_Post(userName, password);
if(!cookie.contains("账户或密码错误")){
	out.println("登陆成功等待跳转");
	session.setAttribute("http_cookie",cookie);
	response.setHeader("refresh", "1;URL=Home.jsp");
	out.print(cookie);
}else{
	out.println(cookie);
}
--%>
</body>
</html>