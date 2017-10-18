<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Date"%>
    <%@page import="java.text.SimpleDateFormat"%>
    <%@page import="net.sf.json.JSONArray"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>今日消费查询</title>

		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>个人消费记录</title>
		<link href="assets/css/sjzstyle.css" rel="stylesheet" type="text/css" />
<style type="text/css">
  body h1{
   	 text-align:center
    }
    .umoney{
     color:#F00
     }
     </style>
     
</head>

<body>
 <jsp:useBean id="uc" class="com.Demo.User_CustStateInfo"></jsp:useBean>
  <jsp:useBean id="uc1" class="com.Demo.User_ConsumeInfo"></jsp:useBean>
  <jsp:useBean id="vc" class="com.ysk.databaseutils.Verify_Cookies"></jsp:useBean>
<%
	String cookie =String.valueOf(session.getAttribute("http_cookie"));
	//out.println(cookie);
  if(!vc.vcookie(cookie)){
	   response.setHeader("refresh", "1;URL=login.html");
   }
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	String toady=df.format(new Date());// new Date()为获取当前系统时间
	String ze="0";
	if(!uc.Get_User_CustStateInfo(cookie, toady, toady).getJSONObject(0).getString("交易科目代码").contains("抱歉")){
		ze=uc.Get_User_CustStateInfo(cookie, toady, toady).getJSONObject(0).getString("钱包交易总额");
	}
	JSONArray ja=uc1.Get_User_ConsumeInfo(cookie, toady, toady);
%>

<div class="content">
	
<h1>你好，今日消费总计<span class="umoney"><%= ze %></span>元。</h1></br></br>
			<div class="wrapper">
				<div class="light"><i></i></div>
				<hr class="line-left">
				<hr class="line-right">
				<div class="main">
					<h1 class="title">消费记录</h1>
					<div class="year">
						<h2><a href="#"><i></i></a></h2>
							<div class="list">
							<ul>
						<% for(int j=ja.size()-1;j>=0;j--){ %>
						<% for(int i=ja.getJSONArray(j).size()-1;i>=0;i--){ %>
						<% if(!ja.getJSONArray(0).getJSONObject(0).getString("操作时间").contains("抱歉")&&!ja.getJSONArray(j).getJSONObject(i).getString("操作时间").equals("")){ %>
								<li class="cls highlight">
									<p class="date"  style="font-size: 30px;"><%= ja.getJSONArray(j).getJSONObject(i).getString("操作时间")%></p>
									<p class="intro" style="font-size: 30px;">-<%=ja.getJSONArray(j).getJSONObject(i).getString("钱包交易金额")%></p>
									<p class="version">&nbsp;</p>
									<div class="more">
										<p>科目描述：<%=ja.getJSONArray(j).getJSONObject(i).getString("科目描述")%></p>
										<p>钱包余额：<%=ja.getJSONArray(j).getJSONObject(i).getString("钱包余额")%></p>
										<p>操作员：<%=ja.getJSONArray(j).getJSONObject(i).getString("操作员")%></p>
										<p>工作站：<%=ja.getJSONArray(j).getJSONObject(i).getString("工作站")%></p>
										<p>终端名称：<%=ja.getJSONArray(j).getJSONObject(i).getString("终端名称")%></p>
									</div>
								</li>
	
								<% }}} %>
								
															</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="assets/js/jquery-1.12.3.min.js"></script>
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