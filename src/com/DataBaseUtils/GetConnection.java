package com.DataBaseUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	private Connection connection =null;
	public static final String url = "jdbc:mysql://localhost:3306/wechatwx?useUnicode=true&characterEncoding=utf8&useSSL=true"; 
//	public static final String url = "jdbc:mysql://111.67.201.142:3306/zjwdb_6163988";
	public static final String name = "com.mysql.jdbc.Driver";  
	public static final String user = "root";  
	public static final String password = "";  
	public Connection getCon(){
		try{
			Class.forName(name);

			connection=DriverManager.getConnection(url,user,password);
//			System.out.println(connection.getMetaData().getURL());
			
			return connection;
		}catch(Exception e){
			System.out.println("创建连接失败");
			e.printStackTrace();
		}
		return null;
	}
	public void closeCon(){
			try { 
				this.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("关闭连接失败");
				e.printStackTrace();
			}
	}
}
