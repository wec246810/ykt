package com.ysk.databaseutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DataBaseUtils.GetConnection;

public class Insert_Swzl {
	private GetConnection con= null;
	private Connection connection=null;
	private PreparedStatement pst = null;
	private ResultSet result = null;
	String sql="INSERT INTO `swzl` ( `time`, `contact`, `info`, `user`) VALUES (?,?,?,?)";
	public void insert_swzl(String time,String contact,String info,String user){
		con=new GetConnection();
		connection=con.getCon();
		try{
			pst = connection.prepareStatement(sql);
			pst.setString(1, time);
			pst.setString(2, contact);
			pst.setString(3, info);
			pst.setString(4, user);
			pst.execute();
			System.out.println("Ö´ÐÐÍê³É");
//			pst.executeQuery();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			con.closeCon();
		}
		
	}
}
