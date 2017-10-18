package com.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Post_UpdateUserData {
	private GetConnection con= null;
	private Connection connection=null;
	private String sql = "UPDATE userdata SET  `UserName`=?, `Password`=? WHERE `UID`=?";
	private PreparedStatement pst = null;
	public void do_Updata(String WeChatId,String USerName,String UserPwd){
		con=new GetConnection();
		connection=con.getCon();
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, USerName);
			pst.setString(2, UserPwd);
			pst.setString(3, WeChatId);
			/*
			 * 需要判断数据更新结果
			 * 
			 * 回去设置
			 * 
			 * boolean
			 */
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.closeCon();
		}

	}
}
