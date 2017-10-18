package com.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Get_UserPwd {
	private GetConnection con= null;
	private Connection connection=null;
	private PreparedStatement pst = null;
	private ResultSet result = null;
	List<String> User=null;
	private String sql = "SELECT * FROM userdata  where UID=?";
	public List<String> Get_WeChatData(String WeChatId){
		con=new GetConnection();
		connection=con.getCon();
		User=new  ArrayList<String>();
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, WeChatId);
			result = pst.executeQuery();
		    while (result.next()) {
				String UserName = result.getString("UserName");
				String UserPwd = result.getString("Password");
				User.add(UserName);
				User.add(UserPwd);
				/*
				 * 存在多个用户名和密码需要处理
				 */
			}
		    return User;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.closeCon();
		}
		return null;
	}
}
