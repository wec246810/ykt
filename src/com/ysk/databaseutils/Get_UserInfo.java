package com.ysk.databaseutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DataBaseUtils.GetConnection;

public class Get_UserInfo {
	private GetConnection con= null;
	private Connection connection=null;
	private PreparedStatement pst = null;
	private ResultSet result = null;
	Query_User qu=new Query_User();
	String sql="SELECT * FROM userdata WHERE Cookie=?";
	public String getuserinfo(String Cookie){
		String user=null;
		//获取用户姓名，如果为空，则准备设置用户数据
		String name="";
		con=new GetConnection();
		connection=con.getCon();
		try{
			pst = connection.prepareStatement(sql);
			pst.setString(1, Cookie);
			result = pst.executeQuery();
			 while (result.next()) {
					user=result.getString("user");
					name=result.getString("name");
					System.out.println("获取user完毕"+user);
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			con.closeCon();
		}
		return user;
	}
}
