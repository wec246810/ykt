package com.HttpUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


import com.CodeOcr.Ocr;
import com.ysk.databaseutils.Set_Cookies;

public class HttpMethod {


	private URL url = null;
	private URLConnection urlconnection = null;
	public String[] cookiestr = { "", "" };


	private String _VIEWSTATE = null;
	private String _EVENTVALIDATION = null;
	private String yzm = "";
	public String Money = "";
	public String Name = "";
			//����cookies
	public String HttpLoginPost(String Id, String Pwd) {
		try {
			url = new URL("http://172.25.1.13/SelfSearchV2_User/login.aspx?ReturnUrl=%2fSelfSearchV2_User%2f");
			urlconnection = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
			StringBuffer params = new StringBuffer();

			params.append("__LASTFOCUS").append("=").append("").append("&");
			params.append("__EVENTTARGET").append("=").append("btnLogin").append("&");
			params.append("__EVENTARGUMENT").append("=").append("").append("&");
			params.append("__VIEWSTATE").append("=").append(this._VIEWSTATE).append("&");
			params.append("__EVENTVALIDATION").append("=").append(this._EVENTVALIDATION).append("&");
			params.append("txtUserName").append("=").append(Id).append("&");
			params.append("txtPassword").append("=").append(Pwd).append("&");
			params.append("txtVaildateCode").append("=").append(this.yzm).append("");

//			System.out.println("Post.params.Content-Length==" + params.length() + "\n");
//			System.out.println(params + "\n");

			byte[] bypes = params.toString().getBytes();
			httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
			httpUrlConnection.setRequestProperty("Connection", "keep-alive");
			httpUrlConnection.setRequestProperty("Content-Length", params.length() + "");
			httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
			httpUrlConnection.setRequestProperty("Origin", "http://172.25.1.13");
			httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			httpUrlConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
			httpUrlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpUrlConnection.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			httpUrlConnection.setRequestProperty("Referer",
					"http://172.25.1.13/SelfSearchV2_User/login.aspx?ReturnUrl=%2fSelfSearchV2_User%2f ");
			httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			httpUrlConnection.setRequestProperty("Accept-Language", "bzh-CN,zh;q=0.8");
			httpUrlConnection.setInstanceFollowRedirects(false);
			if (this.cookiestr[0] != "" && this.cookiestr[0] != null) {
				httpUrlConnection.setRequestProperty("Cookie", this.cookiestr[0]);
				System.out.println("now.this.Post.cookie.SET==" + this.cookiestr[0] + "\n");
			}
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.setDoInput(true);

			httpUrlConnection.getOutputStream().write(bypes);
			httpUrlConnection.connect();

			int responseCode = httpUrlConnection.getResponseCode();
			if (responseCode != 200) {
				System.out.println("��ȷ�ض������" + responseCode + "\n");
				httpUrlConnection.disconnect();
				System.out.println("�˺�������ȷ��" + "\n");
				String cookie = httpUrlConnection.getHeaderField("Set-Cookie");
				System.out.println("Post.Success.cookie==" + cookie + "\n");
				if (this.cookiestr[1] == "" || this.cookiestr[1] == null) {
					cookie = cookie.substring(0, cookie.indexOf(";"));
					this.cookiestr[1] = cookie;
				}
				httpUrlConnection.disconnect();
			
				return this.cookiestr[0]+"; "+this.cookiestr[1];
			} else {
				System.out.println("Post Success!" + "\n");
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					if (line.contains("��֤�������������ȷ����֤��"))
						return "��֤�����";
					if (line.contains("�˻����������"))
						return "�˻����������";
				}
				httpUrlConnection.disconnect();
				return "δ֪����";
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
			return "�����׳��쳣";
		} catch (IOException e) {
			return "IP�׳��쳣";
		}
	}

	public String Get_Post() {
		try {
			url = new URL("http://172.25.1.13/SelfSearchV2_User/login.aspx");
			urlconnection = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.setDoInput(true);
			httpUrlConnection.setInstanceFollowRedirects(false);
			httpUrlConnection.setConnectTimeout(10000);
			httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
			httpUrlConnection.setRequestProperty("Connection", "keep-alive");
			httpUrlConnection.setRequestProperty("Content-Length", "1446");
			httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
			httpUrlConnection.setRequestProperty("Origin", "http://172.25.1.13");
			httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			httpUrlConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
			httpUrlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpUrlConnection.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			httpUrlConnection.setRequestProperty("Referer", "http://172.25.1.13/SelfSearchV2_User/Login.aspx");
			httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			httpUrlConnection.setRequestProperty("Accept-Language", "bzh-CN,zh;q=0.8");

			if (this.cookiestr[0] != "" && this.cookiestr[0] != null) {
				httpUrlConnection.setRequestProperty("Cookie", this.cookiestr[0]);
				System.out.println("first.Get_Post===" + this.cookiestr[0] + "\n");
			}

			httpUrlConnection.setRequestMethod("GET");
			httpUrlConnection.connect();
			int responseCode = httpUrlConnection.getResponseCode();
			if (responseCode != 200) {
				System.out.println(" Error===" + responseCode + "\n");
				httpUrlConnection.disconnect();
				System.out.println("����һ��ͨϵͳʧ�ܣ�" + "\n");
			} else {
				System.out.println("Get_Post===Get Success!" + "\n");
			}

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
			String line;
			System.out.println("now.Get_Post=cookie==" + cookiestr[0] + "\n");
			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains("VIEWSTATE")) {
					// System.out.println(line);
					String VIEWSTATE = line;
					this._VIEWSTATE = VIEWSTATE.substring(64, 1172);
					this._VIEWSTATE = this._VIEWSTATE.replaceAll("/", "%2F");
					this._VIEWSTATE = this._VIEWSTATE.replaceAll("=", "%3D");
					this._VIEWSTATE = this._VIEWSTATE.replaceAll("\\+", "%2B");
					// System.out.println(_VIEWSTATE);
				}
				if (line.contains("EVENTVALIDATION")) {
					// System.out.println(line);
					String EVENTVALIDATION = line;
					this._EVENTVALIDATION = EVENTVALIDATION.substring(77, 165);
					this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("/", "%2F");
					this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("\\+", "%2B");
					// System.out.println(_EVENTVALIDATION);
				}
			}
			httpUrlConnection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			return null;
		}
		return null;
	}
//��ȡ��֤��
	public boolean GetYzm() {

		try {
			url = new URL("http://172.25.1.13/SelfSearchV2_User/validateimage.ashx");
			urlconnection = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
			httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
			httpUrlConnection.setRequestProperty("Accept", "image/webp,image/*,*/*;q=0.8");
			httpUrlConnection.setRequestProperty("Connection", "keep-alive");
			httpUrlConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
			httpUrlConnection.setRequestProperty("Referer", "http://172.25.1.13/SelfSearchV2_User/Login.aspx");
			httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
			httpUrlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			if (this.cookiestr[0] != "" && this.cookiestr[0] != null) {
				httpUrlConnection.setRequestProperty("Cookie", this.cookiestr[0]);
			}
			httpUrlConnection.setRequestMethod("GET");
			httpUrlConnection.connect();
			InputStream is = httpUrlConnection.getInputStream();
			Ocr GetResult = new Ocr();
			yzm = GetResult.Ocr(is, "C:\\Ic\\");
			String cookie = httpUrlConnection.getHeaderField("Set-Cookie");
			if (cookie != null) {
				cookie = cookie.substring(0, cookie.indexOf(";"));
				this.cookiestr[0] = cookie;
			}
//			System.out.println("now.get.YZM.cookie==" + cookie + "\n");
			((HttpURLConnection) urlconnection).disconnect();
			is.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		// ��֤���ύ�ж�
		return true;
	}
//���ػ�����Ϣhtml
	public String Go_Home( String thiscookie) {

		try {
			url = new URL("http://172.25.1.13/SelfSearchV2_User/User/Home.aspx");
			urlconnection = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
			httpUrlConnection.setConnectTimeout(10000);
			httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
			httpUrlConnection.setRequestProperty("Connection", "keep-alive");
			httpUrlConnection.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			httpUrlConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
			httpUrlConnection.setRequestProperty("Referer", "http://172.25.1.13/SelfSearchV2_User/Index.aspx");
			httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
			httpUrlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			
			
//			if (this.cookiestr[0] != "" && this.cookiestr[0] != null) {
//				System.out.println(cookiestr[0]);
//				System.out.println(cookiestr[1]);
//				
//				this.cookiestr[0]=this.cookiestr[0]+"; "+this.cookiestr[1];
//				httpUrlConnection.setRequestProperty("Cookie", this.cookiestr[0]);
//				System.out.println("now.this.Post.cookie.SET==" + this.cookiestr[0] + "\n");
//			}
			
			httpUrlConnection.setRequestProperty("Cookie", thiscookie);
			
			httpUrlConnection.setRequestMethod("GET");
			httpUrlConnection.connect();
			int responseCode = httpUrlConnection.getResponseCode();
			if (responseCode != 200) {
//				System.out.println(" Error===" + responseCode);
				httpUrlConnection.disconnect();
//				System.out.println("����һ��ͨϵͳʧ�ܣ�");
			} else {
//				System.out.println("Get Success!");
			}
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
			String line;
			String result="";
			String result2="";
			while ((line = bufferedReader.readLine()) != null) {
				result+=line;
				if(line.contains("��Ǯ��")){
					result2=line;
				}
			}
			httpUrlConnection.disconnect();
			Money=result2;
			return result;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			return null;
		}
		
	}
//����ɾ��
	public boolean Get_Money() {

		try {
			url = new URL("http://172.25.1.13/SelfSearchV2_User//SelfSearchV2_User/news/index.aspx");
			urlconnection = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
			httpUrlConnection.setConnectTimeout(10000);
			httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
			httpUrlConnection.setRequestProperty("Connection", "keep-alive");
			httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
			httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			httpUrlConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
			httpUrlConnection.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			httpUrlConnection.setRequestProperty("Accept-Language", "bzh-CN,zh;q=0.8");
			if (this.cookiestr[0] != "" && this.cookiestr[0] != null)
				httpUrlConnection.setRequestProperty("Cookie", this.cookiestr[0]);
			httpUrlConnection.setRequestMethod("GET");
			httpUrlConnection.connect();
			int responseCode = httpUrlConnection.getResponseCode();
			if (responseCode != 200) {
//				System.out.println(" Error===" + responseCode + "\n");
				httpUrlConnection.disconnect();
//				System.out.println("����һ��ͨϵͳʧ�ܣ�" + "\n");
			} else {
//				System.out.println("Get Success!" + "\n");
			}
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
			String line;
//			System.out.println("Get_Money.cookie==" + cookiestr[0] + "\n");
			while ((line = bufferedReader.readLine()) != null) {
//				System.out.println(line);
			}
			httpUrlConnection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public boolean Get_Ajax() {

		try {
			url = new URL("http://172.25.1.13/SelfSearchV2_User/User/ajax.ashx?action=GetCardType&r=");
			urlconnection = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
			httpUrlConnection.setConnectTimeout(10000);
			httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
			httpUrlConnection.setRequestProperty("Connection", "keep-alive");
			httpUrlConnection.setRequestProperty("Accept", "*/*");
			httpUrlConnection.setRequestProperty("X-Requested-With", "XMLHttpRequest");
			httpUrlConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
			httpUrlConnection.setRequestProperty("Referer", "http://172.25.1.13/SelfSearchV2_User/Index.aspx");
			httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch");
			httpUrlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");

			if (this.cookiestr[0] != "" && this.cookiestr[0] != null)
				httpUrlConnection.setRequestProperty("Cookie", this.cookiestr[0]);
			httpUrlConnection.setRequestMethod("GET");
			httpUrlConnection.connect();
			int responseCode = httpUrlConnection.getResponseCode();
			String cookie = httpUrlConnection.getHeaderField("Set-Cookie");
			if (cookie != null) {
//				System.out.println(cookie);
				cookie = cookie.substring(0, cookie.indexOf(";"));

				this.cookiestr[0] = cookie;
			}
			if (responseCode != 200) {
//				System.out.println(" Error===" + responseCode);
				httpUrlConnection.disconnect();
//				System.out.println("����һ��ͨϵͳʧ�ܣ�");
			} else {
//				System.out.println("Get Success!");
			}
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
			String line;
//			System.out.println("======================================");
//			System.out.println(cookiestr[0]);
//			System.out.println("======================================");
			while ((line = bufferedReader.readLine()) != null) {
//				System.out.println(line);
			}
			httpUrlConnection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public boolean Get_Post_CustStateInfo(String this_cookie) {
		try {
			url = new URL("http://172.25.1.13/SelfSearchV2_User/User/CustStateInfo.aspx");
			urlconnection = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.setDoInput(true);
			httpUrlConnection.setInstanceFollowRedirects(false);
			httpUrlConnection.setConnectTimeout(10000);
			httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
			httpUrlConnection.setRequestProperty("Connection", "keep-alive");
			httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
			httpUrlConnection.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			httpUrlConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
			httpUrlConnection.setRequestProperty("Referer",
					"http://172.25.1.13/SelfSearchV2_User/User/ConsumeInfo.aspx");
			httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			httpUrlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			httpUrlConnection.setRequestProperty("Cookie", this_cookie);

			httpUrlConnection.setRequestMethod("GET");
			httpUrlConnection.connect();
			int responseCode = httpUrlConnection.getResponseCode();
			if (responseCode != 200) {
//				System.out.println(" Error===" + responseCode + "\n");
				httpUrlConnection.disconnect();
//				System.out.println("����һ��ͨϵͳʧ�ܣ�" + "\n");
			} else {
//				System.out.println("Get_Post===Get Success!" + "\n");
			}

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
			String line;
//			System.out.println("now.Get_Post=cookie==" + cookiestr[0] + "\n");
			while ((line = bufferedReader.readLine()) != null) {
				// System.out.println(line);
				if (line.contains("VIEWSTATE")) {
					// System.out.println(line);
					String VIEWSTATE = line;
					// System.out.println(line);
					this._VIEWSTATE = VIEWSTATE.substring(VIEWSTATE.indexOf("value=") + 7, VIEWSTATE.indexOf(">") - 3);
					this._VIEWSTATE = this._VIEWSTATE.replaceAll("/", "%2F");
					this._VIEWSTATE = this._VIEWSTATE.replaceAll("=", "%3D");
					this._VIEWSTATE = this._VIEWSTATE.replaceAll("\\+", "%2B");
					// System.out.println(_VIEWSTATE);
				}
				if (line.contains("EVENTVALIDATION")) {
					// System.out.println(line);
					String EVENTVALIDATION = line;
					// System.out.println(line);
					this._EVENTVALIDATION = EVENTVALIDATION.substring(EVENTVALIDATION.indexOf("value=") + 7,
							EVENTVALIDATION.indexOf(">") - 3);
					this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("/", "%2F");
					this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("\\+", "%2B");

					// System.out.println(_EVENTVALIDATION);
				}
			}
			httpUrlConnection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			return false;
		}
		return false;
	}

	// �����Ѳ�ѯ
	public String Post_CustStateInfo(String this_cookie, String ctl00$ContentPlaceHolder1$txtStartDate,
			String ctl00$ContentPlaceHolder1$txtEndDate) {

		try {
			url = new URL("http://172.25.1.13/SelfSearchV2_User/User/CustStateInfo.aspx");
			urlconnection = url.openConnection();
			StringBuffer params = new StringBuffer();
//			System.out.println(this._EVENTVALIDATION);
			params.append("__VIEWSTATE").append("=").append(this._VIEWSTATE).append("&");
			params.append("__EVENTVALIDATION").append("=").append(this._EVENTVALIDATION).append("&");
			params.append("ctl00%24ContentPlaceHolder1%24rbtnType").append("=").append("0").append("&");
			params.append("ctl00%24ContentPlaceHolder1%24txtStartDate").append("=")
					.append(ctl00$ContentPlaceHolder1$txtStartDate).append("&");
			params.append("ctl00%24ContentPlaceHolder1%24txtEndDate").append("=")
					.append(ctl00$ContentPlaceHolder1$txtEndDate).append("&");
			params.append("ctl00%24ContentPlaceHolder1%24btnSearch").append("=").append("%E6%9F%A5++%E8%AF%A2");
//			System.out.println("Post_ConsumeInfo.Content-Length==" + params.length() + "\n");
//			System.out.println(params + "\n");
			byte[] bypes = params.toString().getBytes();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
			httpUrlConnection.setConnectTimeout(10000);
			httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
			httpUrlConnection.setRequestProperty("Connection", "keep-alive");
			httpUrlConnection.setRequestProperty("Content-Length", params.length() + "");
			httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
			httpUrlConnection.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			httpUrlConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
			httpUrlConnection.setRequestProperty("Referer",
					"http://172.25.1.13/SelfSearchV2_User/User/ConsumeInfo.aspx");
			httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			httpUrlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			httpUrlConnection.setRequestProperty("Cookie", this_cookie);
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.setDoInput(true);
			httpUrlConnection.getOutputStream().write(bypes);
			httpUrlConnection.connect();
			int responseCode = httpUrlConnection.getResponseCode();
			if (responseCode != 200) {
//				System.out.println(" Error===" + responseCode);
				httpUrlConnection.disconnect();
//				System.out.println("����һ��ͨϵͳʧ�ܣ�");
			} else {
//				System.out.println("���Ӳ�ѯϵͳ�ɹ�");
			}
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
			String line;
			String all = null;
			while ((line = bufferedReader.readLine()) != null) {
				/*
				 * ���Ѽ�¼��ѯ ����һ��ajax 1.ԭԭ������ԭ 12345>>
				 */
				/*
				 * 
				 * ΢������������ѽ�� 1.���������Ѳ�ѯ�ŵ���ά������ Ȼ����н��� Ȼ��ȡ����һ�����
				 */
				/*
				 * ͨ���������ݿ� ����΢�Ŷ�
				 *
				 * �����ݿ��ʱ��ȫ
				 *
				 * 1.ѧϰ������ssh 2.ѧϰjsoup 3.
				 */
				all += line;

			}
//			System.out.println(all);
//			JsoupDemo Demo = new JsoupDemo();
//			Demo.do_Get_ConsumeInfo(all);	
			httpUrlConnection.disconnect();
			return all;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	// �����Ϣ���Ѳ�ѯ

	public boolean Get_Post_depositinfo(String this_cookie) {
		try {
			url = new URL("http://172.25.1.13/SelfSearchV2_User/User/depositinfo.ASPX");
			urlconnection = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.setDoInput(true);
			httpUrlConnection.setInstanceFollowRedirects(false);
			httpUrlConnection.setConnectTimeout(10000);
			httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
			httpUrlConnection.setRequestProperty("Connection", "keep-alive");
			httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
			httpUrlConnection.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			httpUrlConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
			httpUrlConnection.setRequestProperty("Referer",
					"http://172.25.1.13/SelfSearchV2_User/User/ConsumeInfo.aspx");
			httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			httpUrlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			httpUrlConnection.setRequestProperty("Cookie", this_cookie);

			httpUrlConnection.setRequestMethod("GET");
			httpUrlConnection.connect();
			int responseCode = httpUrlConnection.getResponseCode();
			if (responseCode != 200) {
//				System.out.println(" Error===" + responseCode + "\n");
				httpUrlConnection.disconnect();
//				System.out.println("����һ��ͨϵͳʧ�ܣ�" + "\n");
			} else {
//				System.out.println("Get_Post===Get Success!" + "\n");
			}

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
			String line;
//			System.out.println("now.Get_Post=cookie==" + cookiestr[0] + "\n");
			while ((line = bufferedReader.readLine()) != null) {
				// System.out.println(line);
				if (line.contains("VIEWSTATE")) {
					// System.out.println(line);
					String VIEWSTATE = line;
					// System.out.println(line);
					this._VIEWSTATE = VIEWSTATE.substring(VIEWSTATE.indexOf("value=") + 7, VIEWSTATE.indexOf(">") - 3);
					this._VIEWSTATE = this._VIEWSTATE.replaceAll("/", "%2F");
					this._VIEWSTATE = this._VIEWSTATE.replaceAll("=", "%3D");
					this._VIEWSTATE = this._VIEWSTATE.replaceAll("\\+", "%2B");
					// System.out.println(_VIEWSTATE);
				}
				if (line.contains("EVENTVALIDATION")) {
					// System.out.println(line);
					String EVENTVALIDATION = line;
					// System.out.println(line);
					this._EVENTVALIDATION = EVENTVALIDATION.substring(EVENTVALIDATION.indexOf("value=") + 7,
							EVENTVALIDATION.indexOf(">") - 3);
					this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("/", "%2F");
					this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("\\+", "%2B");

					// System.out.println(_EVENTVALIDATION);
				}
			}
			httpUrlConnection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			return false;
		}
		return false;
	}

	public String Post_depositinfo(String this_cookie, int __EVENTARGUMENT,
			String ctl00$ContentPlaceHolder1$txtStartDate, String ctl00$ContentPlaceHolder1$txtEndDate) {

		try {
			url = new URL("http://172.25.1.13/SelfSearchV2_User/User/depositinfo.ASPX");
			urlconnection = url.openConnection();
			StringBuffer params = new StringBuffer();
//			System.out.println(this._EVENTVALIDATION);
			params.append("__EVENTTARGET").append("=").append("ctl00%24ContentPlaceHolder1%24AspNetPager1").append("&");
			params.append("__EVENTARGUMENT").append("=").append("" + __EVENTARGUMENT).append("&");
			params.append("__VIEWSTATE").append("=").append(this._VIEWSTATE).append("&");
			params.append("__EVENTVALIDATION").append("=").append(this._EVENTVALIDATION).append("&");
			params.append("ctl00%24ContentPlaceHolder1%24rbtnType").append("=").append("0").append("&");
			params.append("ctl00%24ContentPlaceHolder1%24txtStartDate").append("=")
					.append(ctl00$ContentPlaceHolder1$txtStartDate).append("&");
			params.append("ctl00%24ContentPlaceHolder1%24txtEndDate").append("=")
					.append(ctl00$ContentPlaceHolder1$txtEndDate).append("&");
			params.append("ctl00%24ContentPlaceHolder1%24btnSearch").append("=").append("%E6%9F%A5++%E8%AF%A2");
			System.out.println("Post_ConsumeInfo.Content-Length==" + params.length() + "\n");
			System.out.println(params + "\n");
			byte[] bypes = params.toString().getBytes();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
			httpUrlConnection.setConnectTimeout(10000);
			httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
			httpUrlConnection.setRequestProperty("Connection", "keep-alive");
			httpUrlConnection.setRequestProperty("Content-Length", params.length() + "");
			httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
			httpUrlConnection.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			httpUrlConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
			httpUrlConnection.setRequestProperty("Referer",
					"http://172.25.1.13/SelfSearchV2_User/User/ConsumeInfo.aspx");
			httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			httpUrlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			httpUrlConnection.setRequestProperty("Cookie", this_cookie);
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.setDoInput(true);
			httpUrlConnection.getOutputStream().write(bypes);
			httpUrlConnection.connect();
			int responseCode = httpUrlConnection.getResponseCode();
			if (responseCode != 200) {
				System.out.println(" Error===" + responseCode);
				httpUrlConnection.disconnect();
				System.out.println("����һ��ͨϵͳʧ�ܣ�");
			} else {
				System.out.println("���Ӳ�ѯϵͳ�ɹ�");
			}
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
			String line;
			String all = null;
			while ((line = bufferedReader.readLine()) != null) {
				/*
				 * ���Ѽ�¼��ѯ ����һ��ajax 1.ԭԭ������ԭ 12345>>
				 */
				/*
				 * 
				 * ΢������������ѽ�� 1.���������Ѳ�ѯ�ŵ���ά������ Ȼ����н��� Ȼ��ȡ����һ�����
				 */
				/*
				 * ͨ���������ݿ� ����΢�Ŷ�
				 *
				 * �����ݿ��ʱ��ȫ
				 *
				 * 1.ѧϰ������ssh 2.ѧϰjsoup 3.
				 */
				all += line;

			}
			httpUrlConnection.disconnect();
			return all;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			return null;
		}

	}

	public boolean Get_Post_UserLoss(String this_cookie) {
		try {
			url = new URL("http://172.25.1.13/SelfSearchV2_User/User/UserLoss.aspx");
			urlconnection = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.setDoInput(true);
			httpUrlConnection.setInstanceFollowRedirects(false);
			httpUrlConnection.setConnectTimeout(10000);
			httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
			httpUrlConnection.setRequestProperty("Connection", "keep-alive");
			httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
			httpUrlConnection.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			httpUrlConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
			httpUrlConnection.setRequestProperty("Referer",
					"http://172.25.1.13/SelfSearchV2_User/User/ConsumeInfo.aspx");
			httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			httpUrlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			httpUrlConnection.setRequestProperty("Cookie", this_cookie);

			httpUrlConnection.setRequestMethod("GET");
			httpUrlConnection.connect();
			int responseCode = httpUrlConnection.getResponseCode();
			if (responseCode != 200) {
				System.out.println(" Error===" + responseCode + "\n");
				httpUrlConnection.disconnect();
				System.out.println("����һ��ͨϵͳʧ�ܣ�" + "\n");
			} else {
				System.out.println("Get_Post===Get Success!" + "\n");
			}

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
			String line;
			System.out.println("now.Get_Post=cookie==" + cookiestr[0] + "\n");
			while ((line = bufferedReader.readLine()) != null) {
				// System.out.println(line);
				if (line.contains("VIEWSTATE")) {
					// System.out.println(line);
					String VIEWSTATE = line;
					// System.out.println(line);
					this._VIEWSTATE = VIEWSTATE.substring(VIEWSTATE.indexOf("value=") + 7, VIEWSTATE.indexOf(">") - 3);
					this._VIEWSTATE = this._VIEWSTATE.replaceAll("/", "%2F");
					this._VIEWSTATE = this._VIEWSTATE.replaceAll("=", "%3D");
					this._VIEWSTATE = this._VIEWSTATE.replaceAll("\\+", "%2B");
					// System.out.println(_VIEWSTATE);
				}
				if (line.contains("EVENTVALIDATION")) {
					// System.out.println(line);
					String EVENTVALIDATION = line;
					// System.out.println(line);
					this._EVENTVALIDATION = EVENTVALIDATION.substring(EVENTVALIDATION.indexOf("value=") + 7,
							EVENTVALIDATION.indexOf(">") - 3);
					this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("/", "%2F");
					this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("\\+", "%2B");

					// System.out.println(_EVENTVALIDATION);
				}
			}
			httpUrlConnection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			return false;
		}
		return false;
	}

	// ���Ѽ�¼��ѯ
	public String Post_UserLoss(String this_cookie, String ctl00$ContentPlaceHolder1$txtPwd,
			String ctl00$ContentPlaceHolder1$txtIDcardNo) {

		try {
			url = new URL("http://172.25.1.13/SelfSearchV2_User/User/UserLoss.aspx");
			urlconnection = url.openConnection();
			StringBuffer params = new StringBuffer();
			System.out.println(this._EVENTVALIDATION);
			params.append("__VIEWSTATE").append("=").append(this._VIEWSTATE).append("&");
			params.append("__EVENTVALIDATION").append("=").append(this._EVENTVALIDATION).append("&");
			params.append("ctl00%24ContentPlaceHolder1%24txtPwd").append("=").append(ctl00$ContentPlaceHolder1$txtPwd)
					.append("&");
			params.append("ctl00%24ContentPlaceHolder1%24txtIDcardNo").append("=")
					.append(ctl00$ContentPlaceHolder1$txtIDcardNo).append("&");
			params.append("ctl00%24ContentPlaceHolder1%24btnLoss").append("=").append("%E6%8C%82++%E5%A4%B1");
			System.out.println("Post_ConsumeInfo.Content-Length==" + params.length() + "\n");
			System.out.println(params + "\n");
			byte[] bypes = params.toString().getBytes();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
			httpUrlConnection.setConnectTimeout(10000);
			httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
			httpUrlConnection.setRequestProperty("Connection", "keep-alive");
			httpUrlConnection.setRequestProperty("Content-Length", params.length() + "");
			httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
			httpUrlConnection.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			httpUrlConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
			httpUrlConnection.setRequestProperty("Referer",
					"http://172.25.1.13/SelfSearchV2_User/User/ConsumeInfo.aspx");
			httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			httpUrlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			httpUrlConnection.setRequestProperty("Cookie", this_cookie);
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.setDoInput(true);
			httpUrlConnection.getOutputStream().write(bypes);
			httpUrlConnection.connect();
			int responseCode = httpUrlConnection.getResponseCode();
			if (responseCode != 200) {
				System.out.println(" Error===" + responseCode);
				httpUrlConnection.disconnect();
				System.out.println("����һ��ͨϵͳʧ�ܣ�");
			} else {
				System.out.println("���Ӳ�ѯϵͳ�ɹ�");
			}
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
			String line;
			String all = null;
			while ((line = bufferedReader.readLine()) != null) {
				/*
				 * ���Ѽ�¼��ѯ ����һ��ajax 1.ԭԭ������ԭ 12345>>
				 */
				/*
				 * 
				 * ΢������������ѽ�� 1.���������Ѳ�ѯ�ŵ���ά������ Ȼ����н��� Ȼ��ȡ����һ�����
				 */
				/*
				 * ͨ���������ݿ� ����΢�Ŷ�
				 *
				 * �����ݿ��ʱ��ȫ
				 *
				 * 1.ѧϰ������ssh 2.ѧϰjsoup 3.
				 */
				all += line;

			}
			
			httpUrlConnection.disconnect();
			return all;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	public boolean Get_Post_UpdatePwd(String this_cookie) {
		try {
			url = new URL("http://172.25.1.13/SelfSearchV2_User/User/UpdatePwd.aspx");
			urlconnection = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.setDoInput(true);
			httpUrlConnection.setInstanceFollowRedirects(false);
			httpUrlConnection.setConnectTimeout(10000);
			httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
			httpUrlConnection.setRequestProperty("Connection", "keep-alive");
			httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
			httpUrlConnection.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			httpUrlConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
			httpUrlConnection.setRequestProperty("Referer",
					"http://172.25.1.13/SelfSearchV2_User/User/ConsumeInfo.aspx");
			httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			httpUrlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			httpUrlConnection.setRequestProperty("Cookie", this_cookie);

			httpUrlConnection.setRequestMethod("GET");
			httpUrlConnection.connect();
			int responseCode = httpUrlConnection.getResponseCode();
			if (responseCode != 200) {
				System.out.println(" Error===" + responseCode + "\n");
				httpUrlConnection.disconnect();
				System.out.println("����һ��ͨϵͳʧ�ܣ�" + "\n");
			} else {
				System.out.println("Get_Post===Get Success!" + "\n");
			}

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
			String line;
			System.out.println("now.Get_Post=cookie==" + cookiestr[0] + "\n");
			while ((line = bufferedReader.readLine()) != null) {
				// System.out.println(line);
				if (line.contains("VIEWSTATE")) {
					// System.out.println(line);
					String VIEWSTATE = line;
					// System.out.println(line);
					this._VIEWSTATE = VIEWSTATE.substring(VIEWSTATE.indexOf("value=") + 7, VIEWSTATE.indexOf(">") - 3);
					this._VIEWSTATE = this._VIEWSTATE.replaceAll("/", "%2F");
					this._VIEWSTATE = this._VIEWSTATE.replaceAll("=", "%3D");
					this._VIEWSTATE = this._VIEWSTATE.replaceAll("\\+", "%2B");
					// System.out.println(_VIEWSTATE);
				}
				if (line.contains("EVENTVALIDATION")) {
					// System.out.println(line);
					String EVENTVALIDATION = line;
					// System.out.println(line);
					this._EVENTVALIDATION = EVENTVALIDATION.substring(EVENTVALIDATION.indexOf("value=") + 7,
							EVENTVALIDATION.indexOf(">") - 3);
					this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("/", "%2F");
					this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("\\+", "%2B");

					// System.out.println(_EVENTVALIDATION);
				}
			}
			httpUrlConnection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			return false;
		}
		return false;
	}

	// ���Ѽ�¼��ѯ
	public String Post_UpdatePwd(String this_cookie, String ctl00$ContentPlaceHolder1$txtPwd,
			String ctl00$ContentPlaceHolder1$txtNewCode) {

		try {
			url = new URL("http://172.25.1.13/SelfSearchV2_User/User/UpdatePwd.aspx");
			urlconnection = url.openConnection();
			StringBuffer params = new StringBuffer();
			System.out.println(this._EVENTVALIDATION);
			params.append("__VIEWSTATE").append("=").append(this._VIEWSTATE).append("&");
			params.append("__EVENTVALIDATION").append("=").append(this._EVENTVALIDATION).append("&");
			params.append("ctl00%24ContentPlaceHolder1%24txtPwd").append("=").append(ctl00$ContentPlaceHolder1$txtPwd)
					.append("&");
			params.append("ctl00%24ContentPlaceHolder1%24txtNewCode").append("=")
					.append(ctl00$ContentPlaceHolder1$txtNewCode).append("&");
			params.append("ctl00%24ContentPlaceHolder1%24txtNewcode2").append("=")
					.append(ctl00$ContentPlaceHolder1$txtNewCode).append("&");
			params.append("ctl00%24ContentPlaceHolder1%24btnSave").append("=").append("%E4%BF%9D++%E5%AD%98");
			System.out.println("Post_ConsumeInfo.Content-Length==" + params.length() + "\n");
			System.out.println(params + "\n");
			byte[] bypes = params.toString().getBytes();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
			httpUrlConnection.setConnectTimeout(10000);
			httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
			httpUrlConnection.setRequestProperty("Connection", "keep-alive");
			httpUrlConnection.setRequestProperty("Content-Length", params.length() + "");
			httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
			httpUrlConnection.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			httpUrlConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
			httpUrlConnection.setRequestProperty("Referer",
					"http://172.25.1.13/SelfSearchV2_User/User/ConsumeInfo.aspx");
			httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			httpUrlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			httpUrlConnection.setRequestProperty("Cookie", this_cookie);
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.setDoInput(true);
			httpUrlConnection.getOutputStream().write(bypes);
			httpUrlConnection.connect();
			int responseCode = httpUrlConnection.getResponseCode();
			if (responseCode != 200) {
				System.out.println(" Error===" + responseCode);
				httpUrlConnection.disconnect();
				System.out.println("����һ��ͨϵͳʧ�ܣ�");
			} else {
				System.out.println("���Ӳ�ѯϵͳ�ɹ�");
			}
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
			String line;
			String all = null;
			while ((line = bufferedReader.readLine()) != null) {
				/*
				 * ���Ѽ�¼��ѯ ����һ��ajax 1.ԭԭ������ԭ 12345>>
				 */
				/*
				 * 
				 * ΢������������ѽ�� 1.���������Ѳ�ѯ�ŵ���ά������ Ȼ����н��� Ȼ��ȡ����һ�����
				 */
				/*
				 * ͨ���������ݿ� ����΢�Ŷ�
				 *
				 * �����ݿ��ʱ��ȫ
				 *
				 * 1.ѧϰ������ssh 2.ѧϰjsoup 3.
				 */
				all += line;

			};
			httpUrlConnection.disconnect();
			return all;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			return null;
		}

	}

	// ���Ѽ�¼��ѯ
	public String Post_PwdLoss(String this_cookie, String txtOutID, String txtPwd, String txtIDcardNo,
			String txtNewpwd) {

		try {
			url = new URL("http://172.25.1.13/SelfSearchV2_User/User/PwdLoss.aspx");
			urlconnection = url.openConnection();
			StringBuffer params = new StringBuffer();
			System.out.println(this._EVENTVALIDATION);
			params.append("__VIEWSTATE").append("=").append(this._VIEWSTATE).append("&");
			params.append("__EVENTVALIDATION").append("=").append(this._EVENTVALIDATION).append("&");
			params.append("txtOutID").append("=").append(txtOutID).append("&");
			params.append("txtPwd").append("=").append(txtPwd).append("&");
			params.append("txtIDcardNo").append("=").append(txtIDcardNo).append("&");
			params.append("txtNewpwd").append("=").append(txtNewpwd).append("&");
			params.append("txtNewpwd2").append("=").append(txtNewpwd).append("&");
			params.append("btnSave").append("=").append("%E4%BF%9D++%E5%AD%98");
			System.out.println("Post_ConsumeInfo.Content-Length==" + params.length() + "\n");
			System.out.println(params + "\n");
			byte[] bypes = params.toString().getBytes();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
			httpUrlConnection.setConnectTimeout(10000);
			httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
			httpUrlConnection.setRequestProperty("Connection", "keep-alive");
			httpUrlConnection.setRequestProperty("Content-Length", params.length() + "");
			httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
			httpUrlConnection.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			httpUrlConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
			httpUrlConnection.setRequestProperty("Referer",
					"http://172.25.1.13/SelfSearchV2_User/User/ConsumeInfo.aspx");
			httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			httpUrlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			httpUrlConnection.setRequestProperty("Cookie", this.cookiestr[0]);
			httpUrlConnection.setRequestMethod("POST");
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.setDoInput(true);
			httpUrlConnection.getOutputStream().write(bypes);
			httpUrlConnection.connect();
			int responseCode = httpUrlConnection.getResponseCode();
			if (responseCode != 200) {
				System.out.println(" Error===" + responseCode);
				httpUrlConnection.disconnect();
				System.out.println("����һ��ͨϵͳʧ�ܣ�");
			} else {
				System.out.println("���Ӳ�ѯϵͳ�ɹ�");
			}
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
			String line;
			String all = null;
			while ((line = bufferedReader.readLine()) != null) {
				/*
				 * ���Ѽ�¼��ѯ ����һ��ajax 1.ԭԭ������ԭ 12345>>
				 */
				/*
				 * 
				 * ΢������������ѽ�� 1.���������Ѳ�ѯ�ŵ���ά������ Ȼ����н��� Ȼ��ȡ����һ�����
				 */
				/*
				 * ͨ���������ݿ� ����΢�Ŷ�
				 *
				 * �����ݿ��ʱ��ȫ
				 *
				 * 1.ѧϰ������ssh 2.ѧϰjsoup 3.
				 */
				all += line;

			}

			httpUrlConnection.disconnect();
			return all;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			return null;
		}
	}
	//��ֵ��¼��ѯ
	public String Get_Post_PwdLoss() {

		try {
			url = new URL("http://172.25.1.13/SelfSearchV2_User/User/PwdLoss.aspx");
			urlconnection = url.openConnection();
			HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
			httpUrlConnection.setDoOutput(true);
			httpUrlConnection.setDoInput(true);
			httpUrlConnection.setInstanceFollowRedirects(false);
			httpUrlConnection.setConnectTimeout(10000);
			httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
			httpUrlConnection.setRequestProperty("Connection", "keep-alive");
			httpUrlConnection.setRequestProperty("Content-Length", "1446");
			httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
			httpUrlConnection.setRequestProperty("Origin", "http://172.25.1.13");
			httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
			httpUrlConnection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
			httpUrlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpUrlConnection.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			httpUrlConnection.setRequestProperty("Referer", "http://172.25.1.13/SelfSearchV2_User/Login.aspx");
			httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			httpUrlConnection.setRequestProperty("Accept-Language", "bzh-CN,zh;q=0.8");

			if (this.cookiestr[0] != "" && this.cookiestr[0] != null) {
				httpUrlConnection.setRequestProperty("Cookie", this.cookiestr[0]);
				System.out.println("first.Get_Post===" + this.cookiestr[0] + "\n");
			}

			httpUrlConnection.setRequestMethod("GET");
			httpUrlConnection.connect();
			String cookie = httpUrlConnection.getHeaderField("Set-Cookie");
			if (cookie != null) {
				cookie = cookie.substring(0, cookie.indexOf(";"));
				this.cookiestr[0] = cookie;
			}
			int responseCode = httpUrlConnection.getResponseCode();
			if (responseCode != 200) {
				System.out.println(" Error===" + responseCode + "\n");
				httpUrlConnection.disconnect();
				System.out.println("����һ��ͨϵͳʧ�ܣ�" + "\n");
			} else {
				System.out.println("Get_Post===Get Success!" + "\n");
			}
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains("VIEWSTATE")) {
					//System.out.println(line);
					String VIEWSTATE = line;
					this._VIEWSTATE = VIEWSTATE.substring(VIEWSTATE.indexOf("value=") + 7, VIEWSTATE.indexOf(">") - 3);
					this._VIEWSTATE = this._VIEWSTATE.replaceAll("/", "%2F");
					this._VIEWSTATE = this._VIEWSTATE.replaceAll("=", "%3D");
					this._VIEWSTATE = this._VIEWSTATE.replaceAll("\\+", "%2B");
					// System.out.println(_VIEWSTATE);
				}
				if (line.contains("EVENTVALIDATION")) {
					// System.out.println(line);
					String EVENTVALIDATION = line;
					this._EVENTVALIDATION = EVENTVALIDATION.substring(EVENTVALIDATION.indexOf("value=") + 7,
							EVENTVALIDATION.indexOf(">") - 3);
					this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("/", "%2F");
					this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("\\+", "%2B");
					// System.out.println(_EVENTVALIDATION);
				}
			}
			httpUrlConnection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			return null;
		}
		return null;

	}

	/*
		 * 
		 * �޸�����
		 * 
		 * @__VIEWSTATE
		 * 
		 * @__EVENTVALIDATION �������
		 * 
		 * @ctl00$ContentPlaceHolder1$txtPwd �ɲ�ѯ����
		 * 
		 * @ctl00$ContentPlaceHolder1$txtNewCode �²�ѯ����
		 * 
		 * @ctl00$ContentPlaceHolder1$txtNewcode2 ȷ���²�ѯ����
		 * 
		 * @ctl00$ContentPlaceHolder1$btnSave �� ��
		 * 
		 * 
		 */
		public boolean Get_Post_BankInfo(String this_cookie) {
			try {
				url = new URL("http://172.25.1.13/SelfSearchV2_User/User/BankInfo.aspx");
				urlconnection = url.openConnection();
				HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
				httpUrlConnection.setDoOutput(true);
				httpUrlConnection.setDoInput(true);
				httpUrlConnection.setInstanceFollowRedirects(false);
				httpUrlConnection.setConnectTimeout(10000);
				httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
				httpUrlConnection.setRequestProperty("Connection", "keep-alive");
				httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
				httpUrlConnection.setRequestProperty("Accept",
						"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
				httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
				httpUrlConnection.setRequestProperty("User-Agent",
						"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
				httpUrlConnection.setRequestProperty("Referer",
						"http://172.25.1.13/SelfSearchV2_User/User/ConsumeInfo.aspx");
				httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
				httpUrlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
				httpUrlConnection.setRequestProperty("Cookie", this_cookie);
	
				httpUrlConnection.setRequestMethod("GET");
				httpUrlConnection.connect();
				int responseCode = httpUrlConnection.getResponseCode();
				if (responseCode != 200) {
	//				System.out.println(" Error===" + responseCode + "\n");
					httpUrlConnection.disconnect();
	//				System.out.println("����һ��ͨϵͳʧ�ܣ�" + "\n");
				} else {
	//				System.out.println("Get_Post===Get Success!" + "\n");
				}
	
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
				String line;
	//			System.out.println("now.Get_Post=cookie==" + cookiestr[0] + "\n");
				while ((line = bufferedReader.readLine()) != null) {
					// System.out.println(line);
					if (line.contains("VIEWSTATE")) {
						// System.out.println(line);
						String VIEWSTATE = line;
						// System.out.println(line);
						this._VIEWSTATE = VIEWSTATE.substring(VIEWSTATE.indexOf("value=") + 7, VIEWSTATE.indexOf(">") - 3);
						this._VIEWSTATE = this._VIEWSTATE.replaceAll("/", "%2F");
						this._VIEWSTATE = this._VIEWSTATE.replaceAll("=", "%3D");
						this._VIEWSTATE = this._VIEWSTATE.replaceAll("\\+", "%2B");
						// System.out.println(_VIEWSTATE);
					}
					if (line.contains("EVENTVALIDATION")) {
						// System.out.println(line);
						String EVENTVALIDATION = line;
						// System.out.println(line);
						this._EVENTVALIDATION = EVENTVALIDATION.substring(EVENTVALIDATION.indexOf("value=") + 7,
								EVENTVALIDATION.indexOf(">") - 3);
						this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("/", "%2F");
						this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("\\+", "%2B");
	
						// System.out.println(_EVENTVALIDATION);
					}
				}
				httpUrlConnection.disconnect();
			} catch (MalformedURLException e) {
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				return false;
			}
			return false;
		}

	// ���Ѽ�¼��ѯ
			public String Post_BankInfo(String this_cookie, int __EVENTARGUMENT,
					String ctl00$ContentPlaceHolder1$txtStartDate, String ctl00$ContentPlaceHolder1$txtEndDate) {
		
				try {
					url = new URL("http://172.25.1.13/SelfSearchV2_User/User/BankInfo.aspx");
					urlconnection = url.openConnection();
					StringBuffer params = new StringBuffer();
		//			System.out.println(this._EVENTVALIDATION);
					params.append("__EVENTTARGET").append("=").append("ctl00%24ContentPlaceHolder1%24AspNetPager1").append("&");
					params.append("__EVENTARGUMENT").append("=").append("" + __EVENTARGUMENT).append("&");
					params.append("__VIEWSTATE").append("=").append(this._VIEWSTATE).append("&");
					params.append("__EVENTVALIDATION").append("=").append(this._EVENTVALIDATION).append("&");
					params.append("ctl00%24ContentPlaceHolder1%24rbtnType").append("=").append("0").append("&");
					params.append("ctl00%24ContentPlaceHolder1%24txtStartDate").append("=")
							.append(ctl00$ContentPlaceHolder1$txtStartDate).append("&");
					params.append("ctl00%24ContentPlaceHolder1%24txtEndDate").append("=")
							.append(ctl00$ContentPlaceHolder1$txtEndDate).append("&");
					params.append("ctl00%24ContentPlaceHolder1%24btnSearch").append("=").append("%E6%9F%A5++%E8%AF%A2");
		//			System.out.println("Post_ConsumeInfo.Content-Length==" + params.length() + "\n");
		//			System.out.println(params + "\n");
					byte[] bypes = params.toString().getBytes();
					HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
					httpUrlConnection.setConnectTimeout(10000);
					httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
					httpUrlConnection.setRequestProperty("Connection", "keep-alive");
					httpUrlConnection.setRequestProperty("Content-Length", params.length() + "");
					httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
					httpUrlConnection.setRequestProperty("Accept",
							"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
					httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
					httpUrlConnection.setRequestProperty("User-Agent",
							"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
					httpUrlConnection.setRequestProperty("Referer",
							"http://172.25.1.13/SelfSearchV2_User/User/ConsumeInfo.aspx");
					httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
					httpUrlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
					httpUrlConnection.setRequestProperty("Cookie", this_cookie);
					httpUrlConnection.setRequestMethod("POST");
					httpUrlConnection.setDoOutput(true);
					httpUrlConnection.setDoInput(true);
					httpUrlConnection.getOutputStream().write(bypes);
					httpUrlConnection.connect();
					int responseCode = httpUrlConnection.getResponseCode();
					if (responseCode != 200) {
		//				System.out.println(" Error===" + responseCode);
						httpUrlConnection.disconnect();
		//				System.out.println("����һ��ͨϵͳʧ�ܣ�");
					} else {
		//				System.out.println("���Ӳ�ѯϵͳ�ɹ�");
					}
					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
					String line;
					String all = null;
					while ((line = bufferedReader.readLine()) != null) {
						if (line.contains("VIEWSTATE")) {
							// System.out.println(line);
							String VIEWSTATE = line;
							// System.out.println(line);
							this._VIEWSTATE = VIEWSTATE.substring(VIEWSTATE.indexOf("value=") + 7, VIEWSTATE.indexOf(">") - 3);
							this._VIEWSTATE = this._VIEWSTATE.replaceAll("/", "%2F");
							this._VIEWSTATE = this._VIEWSTATE.replaceAll("=", "%3D");
							this._VIEWSTATE = this._VIEWSTATE.replaceAll("\\+", "%2B");
							// System.out.println(_VIEWSTATE);
						}
						if (line.contains("EVENTVALIDATION")) {
							// System.out.println(line);
							String EVENTVALIDATION = line;
							// System.out.println(line);
							this._EVENTVALIDATION = EVENTVALIDATION.substring(EVENTVALIDATION.indexOf("value=") + 7,
									EVENTVALIDATION.indexOf(">") - 3);
							this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("/", "%2F");
							this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("\\+", "%2B");
		
							// System.out.println(_EVENTVALIDATION);
						}
						all += line;
		
					}
					httpUrlConnection.disconnect();
					return all;
				} catch (MalformedURLException e) {
					e.printStackTrace();
					return null;
				} catch (IOException e) {
					return null;
				}
		
			}

			public boolean Get_Post_ConsumeInfo(String this_cookie) {
				try {
					url = new URL("http://172.25.1.13/SelfSearchV2_User/User/ConsumeInfo.aspx");
					urlconnection = url.openConnection();
					HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
					httpUrlConnection.setDoOutput(true);
					httpUrlConnection.setDoInput(true);
					httpUrlConnection.setInstanceFollowRedirects(false);
					httpUrlConnection.setConnectTimeout(10000);
					httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
					httpUrlConnection.setRequestProperty("Connection", "keep-alive");
					httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
					httpUrlConnection.setRequestProperty("Accept",
							"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
					httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
					httpUrlConnection.setRequestProperty("User-Agent",
							"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
					httpUrlConnection.setRequestProperty("Referer",
							"http://172.25.1.13/SelfSearchV2_User/User/ConsumeInfo.aspx");
					httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
					httpUrlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
					httpUrlConnection.setRequestProperty("Cookie", this_cookie);
		
					httpUrlConnection.setRequestMethod("GET");
					httpUrlConnection.connect();
					int responseCode = httpUrlConnection.getResponseCode();
					if (responseCode != 200) {
		//				System.out.println(" Error===" + responseCode + "\n");
						httpUrlConnection.disconnect();
		//				System.out.println("����һ��ͨϵͳʧ�ܣ�" + "\n");
					} else {
		//				System.out.println("Get_Post===Get Success!" + "\n");
					}
		
					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
					String line;
		//			System.out.println("now.Get_Post=cookie==" + cookiestr[0] + "\n");
					while ((line = bufferedReader.readLine()) != null) {
						// System.out.println(line);
						if (line.contains("VIEWSTATE")) {
							// System.out.println(line);
							String VIEWSTATE = line;
							// System.out.println(line);
							this._VIEWSTATE = VIEWSTATE.substring(VIEWSTATE.indexOf("value=") + 7, VIEWSTATE.indexOf(">") - 3);
							this._VIEWSTATE = this._VIEWSTATE.replaceAll("/", "%2F");
							this._VIEWSTATE = this._VIEWSTATE.replaceAll("=", "%3D");
							this._VIEWSTATE = this._VIEWSTATE.replaceAll("\\+", "%2B");
							// System.out.println(_VIEWSTATE);
						}
						if (line.contains("EVENTVALIDATION")) {
							// System.out.println(line);
							String EVENTVALIDATION = line;
							// System.out.println(line);
							this._EVENTVALIDATION = EVENTVALIDATION.substring(EVENTVALIDATION.indexOf("value=") + 7,
									EVENTVALIDATION.indexOf(">") - 3);
							this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("/", "%2F");
							this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("\\+", "%2B");
		
							// System.out.println(_EVENTVALIDATION);
						}
					}
					httpUrlConnection.disconnect();
				} catch (MalformedURLException e) {
					e.printStackTrace();
					return false;
				} catch (IOException e) {
					return false;
				}
				return false;
			}

		// ���Ѽ�¼��ѯ��ҳ��
				public String Post_Page_ConsumeInfo(String this_cookie, int __EVENTARGUMENT,
						String ctl00$ContentPlaceHolder1$txtStartDate, String ctl00$ContentPlaceHolder1$txtEndDate) {
			
					try {
						url = new URL("http://172.25.1.13/SelfSearchV2_User/User/ConsumeInfo.aspx");
						urlconnection = url.openConnection();
						StringBuffer params = new StringBuffer();
			//			System.out.println(this._EVENTVALIDATION);
						params.append("__EVENTTARGET").append("=").append("ctl00%24ContentPlaceHolder1%24AspNetPager1").append("&");
						params.append("__EVENTARGUMENT").append("=").append("" + __EVENTARGUMENT).append("&");
						params.append("__VIEWSTATE").append("=").append(this._VIEWSTATE).append("&");
						params.append("__EVENTVALIDATION").append("=").append(this._EVENTVALIDATION).append("&");
						params.append("ctl00%24ContentPlaceHolder1%24rbtnType").append("=").append("0").append("&");
						params.append("ctl00%24ContentPlaceHolder1%24txtStartDate").append("=")
								.append(ctl00$ContentPlaceHolder1$txtStartDate).append("&");
						params.append("ctl00%24ContentPlaceHolder1%24txtEndDate").append("=")
								.append(ctl00$ContentPlaceHolder1$txtEndDate);
						//params.append("&").append("ctl00%24ContentPlaceHolder1%24btnSearch").append("=").append("%E6%9F%A5++%E8%AF%A2");
			//			System.out.println("Post_ConsumeInfo.Content-Length==" + params.length() + "\n");
			//			System.out.println(params + "\n");
						byte[] bypes = params.toString().getBytes();
						HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
						httpUrlConnection.setConnectTimeout(10000);
						httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
						httpUrlConnection.setRequestProperty("Connection", "keep-alive");
						httpUrlConnection.setRequestProperty("Content-Length", params.length() + "");
						httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
						httpUrlConnection.setRequestProperty("Accept",
								"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
						httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
						httpUrlConnection.setRequestProperty("User-Agent",
								"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
						httpUrlConnection.setRequestProperty("Referer",
								"http://172.25.1.13/SelfSearchV2_User/User/ConsumeInfo.aspx");
						httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
						httpUrlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
						httpUrlConnection.setRequestProperty("Cookie", this_cookie);
						httpUrlConnection.setRequestMethod("POST");
						httpUrlConnection.setDoOutput(true);
						httpUrlConnection.setDoInput(true);
						httpUrlConnection.getOutputStream().write(bypes);
						httpUrlConnection.connect();
						int responseCode = httpUrlConnection.getResponseCode();
						if (responseCode != 200) {
			//				System.out.println(" Error===" + responseCode);
							httpUrlConnection.disconnect();
			//				System.out.println("����һ��ͨϵͳʧ�ܣ�");
						} else {
			//				System.out.println("���Ӳ�ѯϵͳ�ɹ�");
						}
						BufferedReader bufferedReader = new BufferedReader(
								new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
						String line;
						String all = null;
						while ((line = bufferedReader.readLine()) != null) {
							/*
							 * ���Ѽ�¼��ѯ ����һ��ajax 1.ԭԭ������ԭ 12345>>
							 */
							/*
							 * 
							 * ΢������������ѽ�� 1.���������Ѳ�ѯ�ŵ���ά������ Ȼ����н��� Ȼ��ȡ����һ�����
							 */
							/*
							 * ͨ���������ݿ� ����΢�Ŷ�
							 *
							 * �����ݿ��ʱ��ȫ
							 *
							 * 1.ѧϰ������ssh 2.ѧϰjsoup 3.
							 */
							all += line;
			
						}
						httpUrlConnection.disconnect();
						return all;
					} catch (MalformedURLException e) {
						e.printStackTrace();
						return null;
					} catch (IOException e) {
						return null;
					}
			
				}
				public String Post_ConsumeInfo(String this_cookie, int __EVENTARGUMENT,
						String ctl00$ContentPlaceHolder1$txtStartDate, String ctl00$ContentPlaceHolder1$txtEndDate) {
			
					try {
						url = new URL("http://172.25.1.13/SelfSearchV2_User/User/ConsumeInfo.aspx");
						urlconnection = url.openConnection();
						StringBuffer params = new StringBuffer();
			//			System.out.println(this._EVENTVALIDATION);
						params.append("__EVENTTARGET").append("=").append("ctl00%24ContentPlaceHolder1%24AspNetPager1").append("&");
						params.append("__EVENTARGUMENT").append("=").append("" + __EVENTARGUMENT).append("&");
						params.append("__VIEWSTATE").append("=").append(this._VIEWSTATE).append("&");
						params.append("__EVENTVALIDATION").append("=").append(this._EVENTVALIDATION).append("&");
						params.append("ctl00%24ContentPlaceHolder1%24rbtnType").append("=").append("0").append("&");
						params.append("ctl00%24ContentPlaceHolder1%24txtStartDate").append("=")
								.append(ctl00$ContentPlaceHolder1$txtStartDate).append("&");
						params.append("ctl00%24ContentPlaceHolder1%24txtEndDate").append("=")
								.append(ctl00$ContentPlaceHolder1$txtEndDate).append("&");
						params.append("ctl00%24ContentPlaceHolder1%24btnSearch").append("=").append("%E6%9F%A5++%E8%AF%A2");
			//			System.out.println("Post_ConsumeInfo.Content-Length==" + params.length() + "\n");
			//			System.out.println(params + "\n");
						byte[] bypes = params.toString().getBytes();
						HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
						httpUrlConnection.setConnectTimeout(10000);
						httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
						httpUrlConnection.setRequestProperty("Connection", "keep-alive");
						httpUrlConnection.setRequestProperty("Content-Length", params.length() + "");
						httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
						httpUrlConnection.setRequestProperty("Accept",
								"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
						httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
						httpUrlConnection.setRequestProperty("User-Agent",
								"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
						httpUrlConnection.setRequestProperty("Referer",
								"http://172.25.1.13/SelfSearchV2_User/User/ConsumeInfo.aspx");
						httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
						httpUrlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
						httpUrlConnection.setRequestProperty("Cookie", this_cookie);
						httpUrlConnection.setRequestMethod("POST");
						httpUrlConnection.setDoOutput(true);
						httpUrlConnection.setDoInput(true);
						httpUrlConnection.getOutputStream().write(bypes);
						httpUrlConnection.connect();
						int responseCode = httpUrlConnection.getResponseCode();
						if (responseCode != 200) {
			//				System.out.println(" Error===" + responseCode);
							httpUrlConnection.disconnect();
			//				System.out.println("����һ��ͨϵͳʧ�ܣ�");
						} else {
			//				System.out.println("���Ӳ�ѯϵͳ�ɹ�");
						}
						BufferedReader bufferedReader = new BufferedReader(
								new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
						String line;
						String all = null;
						while ((line = bufferedReader.readLine()) != null) {
							if (line.contains("VIEWSTATE")) {
								// System.out.println(line);
								String VIEWSTATE = line;
								// System.out.println(line);
								this._VIEWSTATE = VIEWSTATE.substring(VIEWSTATE.indexOf("value=") + 7, VIEWSTATE.indexOf(">") - 3);
								this._VIEWSTATE = this._VIEWSTATE.replaceAll("/", "%2F");
								this._VIEWSTATE = this._VIEWSTATE.replaceAll("=", "%3D");
								this._VIEWSTATE = this._VIEWSTATE.replaceAll("\\+", "%2B");
								// System.out.println(_VIEWSTATE);
							}
							if (line.contains("EVENTVALIDATION")) {
								// System.out.println(line);
								String EVENTVALIDATION = line;
								// System.out.println(line);
								this._EVENTVALIDATION = EVENTVALIDATION.substring(EVENTVALIDATION.indexOf("value=") + 7,
										EVENTVALIDATION.indexOf(">") - 3);
								this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("/", "%2F");
								this._EVENTVALIDATION = this._EVENTVALIDATION.replaceAll("\\+", "%2B");
			
								// System.out.println(_EVENTVALIDATION);
							}
							all += line;
			
						}
						httpUrlConnection.disconnect();
						return all;
					} catch (MalformedURLException e) {
						e.printStackTrace();
						return null;
					} catch (IOException e) {
						return null;
					}
				}	
				//��ҳ��Ȧ����Ϣ
				public String Post_Page_BankInfo(String this_cookie, int __EVENTARGUMENT,
						String ctl00$ContentPlaceHolder1$txtStartDate, String ctl00$ContentPlaceHolder1$txtEndDate) {
					try {
						url = new URL("http://172.25.1.13/SelfSearchV2_User/User/BankInfo.aspx");
						urlconnection = url.openConnection();
						StringBuffer params = new StringBuffer();
			//			System.out.println(this._EVENTVALIDATION);
						params.append("__EVENTTARGET").append("=").append("ctl00%24ContentPlaceHolder1%24AspNetPager1").append("&");
						params.append("__EVENTARGUMENT").append("=").append("" + __EVENTARGUMENT).append("&");
						params.append("__VIEWSTATE").append("=").append(this._VIEWSTATE).append("&");
						params.append("__EVENTVALIDATION").append("=").append(this._EVENTVALIDATION).append("&");
						params.append("ctl00%24ContentPlaceHolder1%24rbtnType").append("=").append("0").append("&");
						params.append("ctl00%24ContentPlaceHolder1%24txtStartDate").append("=")
								.append(ctl00$ContentPlaceHolder1$txtStartDate).append("&");
						params.append("ctl00%24ContentPlaceHolder1%24txtEndDate").append("=")
								.append(ctl00$ContentPlaceHolder1$txtEndDate);
						//params.append("&").append("ctl00%24ContentPlaceHolder1%24btnSearch").append("=").append("%E6%9F%A5++%E8%AF%A2");
			//			System.out.println("Post_ConsumeInfo.Content-Length==" + params.length() + "\n");
			//			System.out.println(params + "\n");
						byte[] bypes = params.toString().getBytes();
						HttpURLConnection httpUrlConnection = (HttpURLConnection) urlconnection;
						httpUrlConnection.setConnectTimeout(10000);
						httpUrlConnection.setRequestProperty("Host", "172.25.1.13");
						httpUrlConnection.setRequestProperty("Connection", "keep-alive");
						httpUrlConnection.setRequestProperty("Content-Length", params.length() + "");
						httpUrlConnection.setRequestProperty("Cache-Control", "max-age=0");
						httpUrlConnection.setRequestProperty("Accept",
								"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
						httpUrlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
						httpUrlConnection.setRequestProperty("User-Agent",
								"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.104 Safari/537.36 Core/1.53.2372.400 QQBrowser/9.5.10548.400");
						httpUrlConnection.setRequestProperty("Referer",
								"http://172.25.1.13/SelfSearchV2_User/User/ConsumeInfo.aspx");
						httpUrlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
						httpUrlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
						httpUrlConnection.setRequestProperty("Cookie", this_cookie);
						httpUrlConnection.setRequestMethod("POST");
						httpUrlConnection.setDoOutput(true);
						httpUrlConnection.setDoInput(true);
						httpUrlConnection.getOutputStream().write(bypes);
						httpUrlConnection.connect();
						int responseCode = httpUrlConnection.getResponseCode();
						if (responseCode != 200) {
			//				System.out.println(" Error===" + responseCode);
							httpUrlConnection.disconnect();
			//				System.out.println("����һ��ͨϵͳʧ�ܣ�");
						} else {
			//				System.out.println("���Ӳ�ѯϵͳ�ɹ�");
						}
						BufferedReader bufferedReader = new BufferedReader(
								new InputStreamReader(httpUrlConnection.getInputStream(), "UTF-8"));
						String line;
						String all = null;
						while ((line = bufferedReader.readLine()) != null) {
							/*
							 * ���Ѽ�¼��ѯ ����һ��ajax 1.ԭԭ������ԭ 12345>>
							 */
							/*
							 * 
							 * ΢������������ѽ�� 1.���������Ѳ�ѯ�ŵ���ά������ Ȼ����н��� Ȼ��ȡ����һ�����
							 */
							/*
							 * ͨ���������ݿ� ����΢�Ŷ�
							 *
							 * �����ݿ��ʱ��ȫ
							 *
							 * 1.ѧϰ������ssh 2.ѧϰjsoup 3.
							 */
							all += line;
			
						}
						httpUrlConnection.disconnect();
						return all;
					} catch (MalformedURLException e) {
						e.printStackTrace();
						return null;
					} catch (IOException e) {
						return null;
					}
			
				}
		
			
}
