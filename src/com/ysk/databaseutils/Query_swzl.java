package com.ysk.databaseutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DataBaseUtils.GetConnection;
import com.google.gson.JsonArray;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Query_swzl {
	  private GetConnection con= null;
		private Connection connection=null;
		private PreparedStatement pst = null;
		private ResultSet result = null;
		String sql="SELECT * FROM swzl";
  public JSONArray query_swzl(){
	  JSONArray ja = new JSONArray();
	  JSONObject jo =new JSONObject();
			con=new GetConnection();
			connection=con.getCon();
			try{
				pst = connection.prepareStatement(sql);
//				pst.setString(1, user);
				result = pst.executeQuery();
				 while(result.next()) {
//					 System.out.println(result.getString("time"));
//					 System.out.println(result.getString("contact"));
//					 System.out.println(result.getString("info"));
					 jo.put("时间", result.getString("time"));
					 jo.put("联系方式", result.getString("contact"));
					 jo.put("信息", result.getString("info"));
					 ja.add(jo);
					 System.out.println("查询完毕，存在");
					}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				
				con.closeCon();
			}
//			System.out.println("查询完毕，不存在");
			return ja;
		}
  		
  }

