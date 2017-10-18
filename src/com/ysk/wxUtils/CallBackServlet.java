package com.ysk.wxUtils;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class CallBackServlet
 */
@WebServlet("/callBack")
public class CallBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CallBackServlet() {
        super();
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		Enumeration<String> enu = request.getParameterNames();
//		while (enu.hasMoreElements()) {
//			
//			String paraName = (String) enu.nextElement();
//			System.out.println(paraName + ": " + request.getParameter(paraName));
//		}
		
		String code=request.getParameter("code");
		System.out.println("--------------------");
		String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+AuthUtils.APPID
				+ "&secret="+AuthUtils.APPSECRET
				+ "&code="+code
				+ "&grant_type=authorization_code";
		JSONObject jo=AuthUtils.doGetJson(url);
		String openid=jo.getString("openid");
		String access_token=jo.getString("access_token");
		String infourl="https://api.weixin.qq.com/sns/userinfo?access_token="+access_token
				+ "&openid="+openid
				+ "&lang=zh_CN";
		JSONObject userinfo=AuthUtils.doGetJson(infourl);
		System.out.println(userinfo);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
