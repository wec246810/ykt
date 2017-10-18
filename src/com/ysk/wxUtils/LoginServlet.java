package com.ysk.wxUtils;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.entity.UrlEncodedFormEntity;

@WebServlet("/wxLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//»Øµ÷µØÖ·
		String callBackUrl="http://ysk521.cn/WeChatIC/callBack";
		String url="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AuthUtils.APPID
				+ "&redirect_uri="+URLEncoder.encode(callBackUrl)
				+ "&response_type=code"
				+ "&scope=snsapi_userinfo"
				+ "&state=STATE#wechat_redirect";
		System.out.println(url);
		response.sendRedirect(url);
		System.out.println("aaaaaaaaaaaaaaaaaa");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
