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
		//��ȡ�û����������Ϊ�գ���׼�������û�����
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
					System.out.println("��ȡuser���"+user);
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			con.closeCon();
		}
		return user;
	}
}
