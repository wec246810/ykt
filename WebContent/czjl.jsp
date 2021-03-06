<%@page import="net.sf.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>个人充值记录</title>
		<link href="assets/css/sjzstyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <jsp:useBean id="ub" class="com.Demo.User_BankInfo"></jsp:useBean>
  <jsp:useBean id="vc" class="com.ysk.databaseutils.Verify_Cookies"></jsp:useBean>

<!--  
String cookie =String.valueOf(session.getAttribute("http_cookie"));
	out.println(cookie);
	String fname=request.getParameter("fname");
	String lname=request.getParameter("lname");
	String result=Post.Do_Get(cookie, 1, fname, lname);
	out.println(result);
%> -->
<%
	String cookie =String.valueOf(session.getAttribute("http_cookie"));	
   if(!vc.vcookie(cookie)){
	   response.setHeader("refresh", "1;URL=login.html");
   }
	String one=request.getParameter("one");
	String two=request.getParameter("two");	
	JSONArray ja=ub.Get_BankInfo(cookie, one, two);
	
%>
<div class="content">
			<div class="wrapper">
				<div class="light"><i></i></div>
				<hr class="line-left">
				<hr class="line-right">
				<div class="main">
					<h1 class="title">充值记录</h1>
					<div class="year">
						<h2><a href="#"><i></i></a></h2>
							<div class="list">
							<ul>
						<% for(int j=ja.size()-1;j>=0;j--){ %>
						<% for(int i=ja.getJSONArray(j).size()-1;i>=0;i--){ %>
						<% if(!ja.getJSONArray(0).getJSONObject(0).getString("操作时间").contains("抱歉")&&!ja.getJSONArray(j).getJSONObject(i).getString("操作时间").equals("")){ %>
								<li class="cls highlight">
									<p class="date" style="font-size: 30px;"><%= ja.getJSONArray(j).getJSONObject(i).getString("操作时间")%></p>
									<p class="intro" style="font-size: 30px;">+<%=ja.getJSONArray(j).getJSONObject(i).getString("钱包操作金额")%></p>
									<p class="version">&nbsp;</p>
									<div class="more">
										<p>圈存机：<%=ja.getJSONArray(j).getJSONObject(i).getString("圈存机")%></p>
										<p>描述：<%=ja.getJSONArray(j).getJSONObject(i).getString("描述")%></p>
									</div>
								</li>
	
								<% }}} %>
								
															</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="assets/js/jquery.min.js"></script>
		<script>
			$(".main .year .list").each(function(e, target) {
				var $target = $(target),
					$ul = $target.find("ul");
				$target.height($ul.outerHeight()), $ul.css("position", "absolute");
			});
			$(".main .year>h2>a").click(function(e) {
				e.preventDefault();
				$(this).parents(".year").toggleClass("close");
			});
		</script>
	
</body>
</html>