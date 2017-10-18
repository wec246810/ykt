<%@page import="net.sf.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>一卡通个人信息</title>
		<link rel="stylesheet" type="text/css" href="assets/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="assets/fonts/font-awesome-4.2.0/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="assets/css/demo.css" />
		<link rel="stylesheet" type="text/css" href="assets/css/component.css" />
</head>
 <jsp:useBean id="user_Base" class="com.Demo.User_Base"></jsp:useBean>
 <jsp:useBean id="vc" class="com.ysk.databaseutils.Verify_Cookies"></jsp:useBean>
<body>
 <%
	String cookie =String.valueOf(session.getAttribute("http_cookie"));
 if(!vc.vcookie(cookie)){
	   response.setHeader("refresh", "1;URL=login.html");
 }
 	JSONArray ja= user_Base.Get_User_Base(cookie); 
 	
  	%>
	<div class="container">
			<!--<header class="codrops-header">
				<h1>Text Input Effects <span>Simple ideas for enhancing text input interactions</span></h1>
				<p>更多精彩内容请关注：<a href="http://www.htmleaf.com/" target="_blank">jQuery之家</a></p>
			</header>-->

			<section class="content bgcolor-4">
				<h2>个人信息</h2>
				<span class="input input--kuro">
					<input class="input__field input__field--kuro" type="text" id="input-7" value=<%= ja.getJSONObject(0).getString("单位") %> />
					<label class="input__label input__label--kuro" for="input-7">
						<span class="input__label-content input__label-content--kuro">班级</span>
					</label>
				</span>
				<span class="input input--kuro">
					<input class="input__field input__field--kuro" type="text" id="input-8" value=<%= ja.getJSONObject(0).getString("工号") %> />
					<label class="input__label input__label--kuro" for="input-8">
						<span class="input__label-content input__label-content--kuro">学号</span>
					</label>
				</span>
				<span class="input input--kuro">
					<input class="input__field input__field--kuro" type="text" id="input-9" value=<%= ja.getJSONObject(0).getString("卡状态") %> />
					<label class="input__label input__label--kuro" for="input-9">
						<span class="input__label-content input__label-content--kuro">卡状态</span>
					</label>
				</span>
				<span class="input input--kuro">
					<input class="input__field input__field--kuro" type="text" id="input-9" value=<%= ja.getJSONObject(0).getString("姓名") %> />
					<label class="input__label input__label--kuro" for="input-9">
						<span class="input__label-content input__label-content--kuro">姓名</span>
					</label>
				</span>
					<span class="input input--kuro">
					<input class="input__field input__field--kuro" type="text" id="input-9" value=<%= ja.getJSONObject(0).getString("身份") %> />
					<label class="input__label input__label--kuro" for="input-9">
						<span class="input__label-content input__label-content--kuro">学历</span>
					</label>
				</span>
					<span class="input input--kuro">
					<input class="input__field input__field--kuro" type="text" id="input-9" value=<%= ja.getJSONObject(0).getString("补助余额") %> />
					<label class="input__label input__label--kuro" for="input-9">
						<span class="input__label-content input__label-content--kuro">补助余额</span>
					</label>
				</span>
			</section>
			
		</div><!-- /container -->
		<script src="js/classie.js"></script>
		<script>
			(function() {
				// trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
				if (!String.prototype.trim) {
					(function() {
						// Make sure we trim BOM and NBSP
						var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
						String.prototype.trim = function() {
							return this.replace(rtrim, '');
						};
					})();
				}

				[].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
					// in case the input is already filled..
					if( inputEl.value.trim() !== '' ) {
						classie.add( inputEl.parentNode, 'input--filled' );
					}

					// events:
					inputEl.addEventListener( 'focus', onInputFocus );
					inputEl.addEventListener( 'blur', onInputBlur );
				} );

				function onInputFocus( ev ) {
					classie.add( ev.target.parentNode, 'input--filled' );
				}

				function onInputBlur( ev ) {
					if( ev.target.value.trim() === '' ) {
						classie.remove( ev.target.parentNode, 'input--filled' );
					}
				}
			})();
		</script>
</body>
</html>