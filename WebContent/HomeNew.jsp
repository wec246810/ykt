<%@page import="net.sf.json.JSONArray"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>山西大学一卡通个人中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="format-detection" content="telephone=no" />
<meta charset="utf-8" />
<style type="text/css">
    html, body { color:#222; font-family:Microsoft YaHei, Helvitica, Verdana, Tohoma, Arial, san-serif; margin:0; padding: 0; text-decoration: none; }
    img { border:0; }
    ul { list-style: none outside none; margin:0; padding: 0; }
    body {
        background-color:#eee; 
    }
    body .mainmenu:after { clear: both; content: " "; display: block; }

    body .mainmenu li{ 
        float:left;
        margin-left: 2.5%;
        margin-top: 2.5%;
        width: 30%;  
        border-radius:3px; 
        overflow:hidden;
    }

    body .mainmenu li a{ display:block;  color:#FFF;   text-align:center }
    body .mainmenu li a b{ 
        display:block; height:80px;
    }
    body .mainmenu li a img{ 
        margin: 15px auto 15px;
        width: 50px;
        height: 50px;
    }
    body .userinfo h5{
   	 text-align:center
   	  
    }
    .uname,.umoney{
     color:#F00
     }
     .footer{
				position:absolute;bottom:0;width:100%;height:30px;}
    body .mainmenu li a span{ display:block; height:30px; line-height:30px;background-color:#FFF; color: #999; font-size:14px; }
    body .mainmenu li:nth-child(8n+1) {background-color:#36A1DB}
    body .mainmenu li:nth-child(8n+2) {background-color:#678ce1}
    body .mainmenu li:nth-child(8n+3) {background-color:#8c67df}
    body .mainmenu li:nth-child(8n+4) {background-color:#84d018}
    body .mainmenu li:nth-child(8n+5) {background-color:#14c760}
    body .mainmenu li:nth-child(8n+6) {background-color:#f3b613}
    body .mainmenu li:nth-child(8n+7) {background-color:#ff8a4a}
    body .mainmenu li:nth-child(8n+8) {background-color:#fc5366}
</style>
</head>
 <jsp:useBean id="user_Base" class="com.Demo.User_Base"></jsp:useBean>
 <jsp:useBean id="gc" class="com.ysk.databaseutils.Get_Cookies"></jsp:useBean>
 <jsp:useBean id="vc" class="com.ysk.databaseutils.Verify_Cookies"></jsp:useBean>

<body>
	 <%
	 JSONArray ja=null;
	String cookie =String.valueOf(session.getAttribute("http_cookie"));
	  if(!vc.vcookie(cookie)){
		   response.setHeader("refresh", "1;URL=login.html");
	   }
	  try{
		 ja= user_Base.Get_User_Base(cookie); 
	  }catch(Exception e){
		  response.setHeader("refresh", "1;URL=login.html");
	  }
	  finally{
		  
	  }
 	
 	
  	%>
	<div class="userinfo" >
	<%
	 try{%>
		 <h5>Hi，<span class="uname"><%= ja.getJSONObject(0).getString("姓名") %></span>同学，你的钱包余额为<span class="umoney"><%=ja.getJSONObject(0).getString("主钱包余额")%></span>。</h5>
	<%  }catch(Exception e){
		  response.setHeader("refresh", "1;URL=login.html");
	  }
	  finally{
		  
	  }
	%>
		
	</div>
    <ul class="mainmenu">
        <li><a href="/ykt/UserInfo.jsp" ><b><img src="assets/img/grxx.png" /></b><span>个人信息</span></a></li>
        <li><a href="/ykt/UserLoss.html" ><b><img src="assets/img/gs.png" /></b><span>一键挂失</span></a></li>
        <li><a href="/ykt/xfjl.html" ><b><img src="assets/img/xfjl.png" /></b><span>消费记录</span></a></li>
        <li><a href="/ykt/UpdatePwd.html" ><b><img src="assets/img/xgmm.png" /></b><span>修改密码</span></a></li>
        <li><a href="/ykt/jrxf.jsp" ><b><img src="assets/img/xf.png" /></b><span>今日消费</span></a></li>
        <li><a href="/ykt/czjl.html" ><b><img src="assets/img/czjl.png" /></b><span>充值记录</span></a></li>
        <li><a href="/ykt/swzl.jsp" ><b><img src="assets/img/swzl.png" /></b><span>失物招领</span></a></li>
        <li><a href="/ykt/yx.jsp" ><b><img src="assets/img/ly.png" /></b><span>提醒服务</span></a></li>
        <li><a href="/ykt/" ><b><img src="assets/img/gd.png" /></b><span>待添加</span></a></li>          
    </ul>
   <div class="footer" align="center">意见反馈：1176971130@qq.com</div>
</body>
</html>