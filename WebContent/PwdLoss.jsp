<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>存款信息查询</title>
</head>
<body>
 <jsp:useBean id="Post" class="com.PostMethod.Post_PwdLoss"></jsp:useBean>
 <jsp:useBean id="vc" class="com.ysk.databaseutils.Verify_Cookies"></jsp:useBean>
<%
String cookie =String.valueOf(session.getAttribute("http_cookie"));
if(!vc.vcookie(cookie)){
	   response.setHeader("refresh", "1;URL=login.html");
}
   if(request.getParameter("txtNewpwd")==request.getParameter("txtNewpwd1")){
		String txtOutID=request.getParameter("txtOutID");
		String txtPwd=request.getParameter("txtPwd");
		String txtIDcardNo=request.getParameter("txtIDcardNo");
		String txtNewpwd=request.getParameter("txtNewpwd");
		String result=Post.Do_Get(cookie, txtOutID, txtPwd, txtIDcardNo, txtNewpwd);
		response.setHeader("refresh", "1;URL=HomeNew.jsp");
   }else{
	   out.println("两次输入密码不一致");
   }

%>
</body>
</html>