package com.ysk.databaseutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DataBaseUtils.GetConnection;

public class Get_email {
	  private GetConnection con= null;
			private Connection connection=null;
			private PreparedStatement pst = null;
			private ResultSet result = null;
			String sql="SELECT * FROM userdata WHERE Cookie=?";
	public String getemail(String cookies){
		String res="";
		con=new GetConnection();
		connection=con.getCon();
		try{
			pst = connection.prepareStatement(sql);
			pst.setString(1, cookies);
			result = pst.executeQuery();
			 while (result.next()) {
					res=result.getString("email");
					System.out.println("ªÒ»°” œ‰ÕÍ±œ");
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			con.closeCon();
		}
		return res;
	}
}
