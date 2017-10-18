package com.ysk.databaseutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DataBaseUtils.GetConnection;

public class Add_User {
	private GetConnection con= null;
	private Connection connection=null;
	private PreparedStatement pst = null;
	private ResultSet result = null;
	Query_User qu=new Query_User();
	String sql="insert into userdata(UID,user,pwd) values(?,?,?)";
	public void adduser(String user,String pwd){
		con=new GetConnection();
		connection=con.getCon();
		try{
			pst = connection.prepareStatement(sql);
			pst.setString(1, user);
			pst.setString(2, user);
			pst.setString(3, pwd);
			pst.execute();
			System.out.println("Ö´ÐÐÍê³É");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			con.closeCon();
		}
		
		
	}
}
