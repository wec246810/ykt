package com.ysk.databaseutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DataBaseUtils.GetConnection;

public class Set_Email {
	private GetConnection con= null;
	private Connection connection=null;
	private PreparedStatement pst = null;
	private ResultSet result = null;
	Query_User qu=new Query_User();
	String sql="UPDATE userdata SET  `email`=? where user=?";
	public void setemail(String email,String user){

		con=new GetConnection();
		connection=con.getCon();
		try{
			pst = connection.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, user);
			pst.execute();
			System.out.println("”√ªß” œ‰¥¢¥ÊÕÍ±œ~");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			con.closeCon();
		}
		
		
	
	}
}
