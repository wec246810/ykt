package com.ysk.databaseutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DataBaseUtils.GetConnection;
/*
 * 根据uid获得cookies
 * 根据前者得到后者
 */
public class Get_Cookies {
	private GetConnection con= null;
	private Connection connection=null;
	private PreparedStatement pst = null;
	private ResultSet result = null;
	String sql="SELECT Cookie FROM userdata WHERE user=?";
	public String get_cookies(String uid){
		String cookies="";
		con=new GetConnection();
		connection=con.getCon();
		try{
			pst = connection.prepareStatement(sql);
			pst.setString(1, uid);
			result = pst.executeQuery();
			 while (result.next()) {
					cookies=result.getString("Cookie");
					System.out.println("获取cookies完毕");
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			con.closeCon();
		}
		
		return cookies;
		
	}
}
