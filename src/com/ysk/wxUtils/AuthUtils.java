package com.ysk.wxUtils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonObject;

import net.sf.json.JSONObject;

public class AuthUtils {
	public  static final String APPID="wxb5017479805c8830";
	public  static final String APPSECRET="bc80cbd54f482a3528536f0944cb70a1";
  	public static JSONObject doGetJson(String url){
	  JSONObject js=new JSONObject();
	 DefaultHttpClient clent=new DefaultHttpClient();
	  HttpGet httpget =new HttpGet();
	 try {
		HttpResponse respone= clent.execute(httpget);
		HttpEntity entity=respone.getEntity();
		if(entity!=null){
			String result =EntityUtils.toString(entity,"UTF-8");
			js=JSONObject.fromObject(result);
		}
	} catch (ClientProtocolException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	 httpget.releaseConnection();
	return js;
	  
  }
}
