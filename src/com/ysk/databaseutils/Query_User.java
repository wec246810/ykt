package com.ysk.databaseutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DataBaseUtils.GetConnection;

public class Query_User {
	private GetConnection con= null;
	private Connection connection=null;
	private PreparedStatement pst = null;
	private ResultSet result = null;
	String sql="SELECT * FROM userdata WHERE user=?";
	public Boolean query_user(String user){
		String cookies=null;
		con=new GetConnection();
		connection=con.getCon();
		try{
			pst = connection.prepareStatement(sql);
			pst.setString(1, user);
			result = pst.executeQuery();
			 if (result.next()) {
				 
				 System.out.println("��ѯ��ϣ�����");
				 return true;
				}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			con.closeCon();
		}
		System.out.println("��ѯ��ϣ�������");
		return false;
	}
}
