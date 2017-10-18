<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="assets/css/guashi.css"/>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:useBean id="ge" class="com.ysk.databaseutils.Get_email"></jsp:useBean>
<title>一卡通提醒服务</title>
</head>
 <jsp:useBean id="vc" class="com.ysk.databaseutils.Verify_Cookies"></jsp:useBean>
<%
String cookie =String.valueOf(session.getAttribute("http_cookie"));
	if(!vc.vcookie(cookie)){
	   response.setHeader("refresh", "1;URL=login.html");
   }
	String email="";
	String resu=ge.getemail(cookie);
	if(resu==null||resu.equals("")){
		response.setHeader("refresh", "1;URL=yx.html");
	}else{
		email=ge.getemail(cookie);
	}
	
%>
<body>
			<div id="login">   
      	 <h1>已绑定邮箱</h1>   
       	<form action="yxcz.jsp" method="post">
     <!-- <input type="text" required="required" placeholder="学号" name="u"></input>    -->    
          <input type="text" required="required" placeholder="<%= email %>" name="yx" disabled="false"></input>  
          <button class="but" type="submit">解除绑定</button>   
        </form></br>
        <form action="ceshi.jsp" method="post">
        <button class="but" type="submit">测试</button>   
        </form>
   </div>
</body>
</html>