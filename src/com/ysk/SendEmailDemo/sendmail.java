package com.ysk.SendEmailDemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendmail extends Thread{
	 	private String from = "1176971130@qq.com";  

	    //授权�? 从QQ上获�?
	    private String password = "nnytdbyjzawojcia";    

	    //收件�?
	    private String to="1176971130@qq.com";
	    public String getTo() {
			return to;
		}

		public void setTo(String to) {
			this.to = to;
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	    private String toady=df.format(new Date());// new Date()为获取当前系统时�?
	    

	    /* 重写run方法的实现，在run方法中发送邮件给指定的用�? 
	     * @see java.lang.Thread#run() 
	     */  
	    @Override
	    public void run() {  
	        try{  

	            Properties prop = new Properties();   

	            prop.setProperty("mail.transport.protocol", "smtp");  

	            prop.setProperty("mail.smtp.host", "smtp.qq.com");

	            prop.setProperty("mail.smtp.auth", "true");  

	            final String smtpPort = "465";

	            prop.setProperty("mail.smtp.port", smtpPort);

	            prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

	            prop.setProperty("mail.smtp.socketFactory.fallback", "false");

	            prop.setProperty("mail.smtp.socketFactory.port", smtpPort);




	            prop.setProperty("mail.debug", "true"); 

	            Session session = Session.getDefaultInstance(prop);

	            session.setDebug(true);

	            MimeMessage message = createMimeMessage(session, from, to);


	            Transport transport = session.getTransport();

	            transport.connect( from, password);  

	            transport.sendMessage(message, message.getAllRecipients());

	            transport.close();  
	        }catch (Exception e) {  
	            throw new RuntimeException(e);  
	        }  
	    }  

	    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
	    	
	        // 1. 创建�?封邮�?
	        MimeMessage message = new MimeMessage(session);

	        // 2. From: 发件�?
	        message.setFrom(new InternetAddress(sendMail, "一卡通服务中心", "UTF-8"));

	        // 3. To: 收件人（可以增加多个收件人�?�抄送�?�密送）
	        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "用户�?", "UTF-8"));

	        // 4. Subject: 邮件主题
	        message.setSubject("一卡通测试邮件", "UTF-8");

	        // 5. Content: 邮件正文（可以使用html标签�?
	        message.setContent("这是一封测试邮件，确定您可以正常使用这项服务。欢迎关注公众号ysk_0513，以便接收最新消息。", "text/html;charset=UTF-8");

	        // 6. 设置发件时间
	        message.setSentDate(new Date());

	        // 7. 保存设置
	        message.saveChanges();

	        return message;
	    }
}
