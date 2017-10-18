package com.ysk.databaseutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DataBaseUtils.GetConnection;

public class Set_Pwd {

	private GetConnection con= null;
	private Connection connection=null;
	private PreparedStatement pst = null;
	private ResultSet result = null;
	Query_User qu=new Query_User();
	String sql="UPDATE userdata SET  `pwd`=? where user=?";
	public void setpwd(String pwd,String uid){
		if(!qu.query_user(uid)){
			
		}
		con=new GetConnection();
		connection=con.getCon();
		try{
			pst = connection.prepareStatement(sql);
			pst.setString(1, pwd);
			pst.setString(2, uid);
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
