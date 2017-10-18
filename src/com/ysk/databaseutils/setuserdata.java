package com.ysk.databaseutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DataBaseUtils.GetConnection;

public class setuserdata {
	private GetConnection con= null;
	private Connection connection=null;
	private PreparedStatement pst = null;
	private ResultSet result = null;
	Query_User qu=new Query_User();
	String sql="UPDATE userdata SET  `name`=?,`classes`=?,`sex`=? where user=?";
	public void setuserdata(String user,String name,String classes,String sex){
		con=new GetConnection();
		connection=con.getCon();
		try{
			pst = connection.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, classes);
			pst.setString(3, sex);
			pst.setString(4, user);
			pst.execute();
			System.out.println("用户基本信息执行完成");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			con.closeCon();
		}
		
		
	}
}
