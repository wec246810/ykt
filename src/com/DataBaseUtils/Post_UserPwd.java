package com.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Post_UserPwd {
	private GetConnection con= null;
	private Connection connection=null;
	private String sql = "INSERT INTO userdata( `UserName`, `Password`) VALUES ( ?, ?)";
	private PreparedStatement pst = null;
	/*
	 *΢���û���Ψһid��Ҫ����д�����ݿ⣬���½���
	 */

	public boolean do_Post(String User,String Pwd){
		con=new GetConnection();
		connection=con.getCon();
		try {
			pst = connection.prepareStatement(sql);
			pst.setString(1, User);
			pst.setString(2, Pwd);
		    pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.closeCon();
		}
		
		

		return false;
		
	}
}
