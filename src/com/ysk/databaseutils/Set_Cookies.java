package com.ysk.databaseutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DataBaseUtils.GetConnection;
/*
 * 根据传入的cookies和uid更新uid对应的cookies
 */
public class Set_Cookies {
	
		private GetConnection con= null;
		private Connection connection=null;
		private PreparedStatement pst = null;
		private ResultSet result = null;
		Query_User qu=new Query_User();
		String sql="UPDATE userdata SET  `Cookie`=? where user=?";
		public void setcookie(String cookies,String uid){
			if(!qu.query_user(uid)){
				
			}
			con=new GetConnection();
			connection=con.getCon();
			try{
				pst = connection.prepareStatement(sql);
				pst.setString(1, cookies);
				pst.setString(2, uid);
				pst.execute();
				System.out.println("执行完成");
//				pst.executeQuery();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				con.closeCon();
			}
			
			
		}
	}

