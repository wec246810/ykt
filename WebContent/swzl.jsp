<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="net.sf.json.JSONArray"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>失物招领中心</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="assets/css/bootstrap-grid.min.css" />
	<link rel="stylesheet" type="text/css" href="assets/css/fban_demo.css">
	
	<!--必要样式-->
	<link rel="stylesheet" type="text/css" href="assets/css/fban_demo1.css">
<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	.demo{padding: 1em 0;}
	a:hover,a:focus{
		outline: none;
		text-decoration: none;
	}
	.tab .nav-tabs{
		border: 1px solid #1fc1dd;
	}
	.tab .nav-tabs li{
		margin: 0;
	}
	.tab .nav-tabs li a{
		font-size: 14px;
		color: #999898;
		background: #fff;
		margin: 0;
		padding: 20px 25px;
		border-radius: 0;
		border: none;
		border-right: 1px solid #ddd;
		text-transform: uppercase;
		position: relative;
	}
	.tab .nav-tabs li a:hover{
		border-top: none;
		border-bottom: none;
		border-right-color: #ddd;
	}
	.tab .nav-tabs li.active a,
	.tab .nav-tabs li.active a:hover{
		color: #fff;
		border: none;
		background: #1fc1dd;
		border-right: 1px solid #ddd;
	}
	.tab .nav-tabs li.active a:before{
		content: "";
		width: 58%;
		height: 4px;
		background: #fff;
		position: absolute;
		top: 0;
		left: 0;
		right: 0;
		margin: 0 auto;
	}
	.tab .nav-tabs li.active a:after{
		content: "";
		border-top: 10px solid #1fc1dd;
		border-left: 10px solid transparent;
		border-right: 10px solid transparent;
		position: absolute;
		bottom: -10px;
		left: 43%;
	}
	.tab .tab-content{
		font-size: 13px;
		color: #999898;
		line-height: 25px;
		background: #fff;
		padding: 20px;
		border: 1px solid #1fc1dd;
		border-top: none;
	}
	.tab .tab-content h3{
		font-size: 24px;
		color: #999898;
		margin-top: 0;
	}
	@media only screen and (max-width: 480px){
		.tab .nav-tabs li{
			width: 100%;
			text-align: center;
		}
		.tab .nav-tabs li.active a,
		.tab .nav-tabs li.active a:after,
		.tab .nav-tabs li.active a:hover{
			border: none;
		}
	}
/*.col-sm-3{ width:650px; margin:0 auto;}
	}*/
</style>
</head>
 <jsp:useBean id="qs" class="com.ysk.databaseutils.Query_swzl"></jsp:useBean>
  <jsp:useBean id="qx" class="com.ysk.databaseutils.Query_xwqs"></jsp:useBean>
  <jsp:useBean id="vc" class="com.ysk.databaseutils.Verify_Cookies"></jsp:useBean>
<body>
	<% 
	String cookie =String.valueOf(session.getAttribute("http_cookie"));
	if(!vc.vcookie(cookie)){
		   response.setHeader("refresh", "1;URL=login.html");
	   }
	JSONArray ja =qs.query_swzl();
	JSONArray jax =qx.query_xwqs();
	%>
		<div class="demo1" >
			<div class="col-sm-3" align="center">
				<a href="swzl.html" class="btn btn-lg blue">发表信息</a>
			</div>
		</div></br>
		<div class="demo">
			<div class="container">
				<div class="row">
					<div class="col-lg-offset-3 col-lg-6">
						<div class="tab" role="tabpanel">
							<!-- Nav tabs -->
							<ul class="nav nav-tabs" role="tablist">
								<li role="presentation" class="active">
									<a href="#Section1" aria-controls="home" role="tab" data-toggle="tab">寻物启事</a>
								</li>
								<li role="presentation">
									<a href="#Section2" aria-controls="profile" role="tab" data-toggle="tab">失物招领</a>
								</li>
							</ul>
							<!-- Tab panes -->
							<div class="tab-content tabs">
								<div role="tabpanel" class="tab-pane fade in active" id="Section1">
									<%
									for(int i=ja.size()-1;i>=0;i--){%>
										<h3 style="color:red">>>><%= ja.getJSONObject(i).getString("时间") %></h3>
										<h4 >联系方式：<%= ja.getJSONObject(i).getString("联系方式") %></h4>
										<p>物品信息：<%= ja.getJSONObject(i).getString("信息") %></p>
									<%	
									}
									%>
			

								</div>
								<div role="tabpanel" class="tab-pane fade" id="Section2">
									<%
									for(int i=jax.size()-1;i>=0;i--){%>
										<h3 style="color:red">>>><%= jax.getJSONObject(i).getString("时间") %></h3>
										<h4>联系方式：<%= jax.getJSONObject(i).getString("联系方式") %></h4>
										<p>物品信息：<%= jax.getJSONObject(i).getString("信息") %></p>
									<%	
									}
									%>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<script src="assets/js/jquery-1.12.3.min.js" type="text/javascript"></script>
		<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>