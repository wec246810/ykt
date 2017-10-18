package com.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.javafx.collections.SourceAdapterChange;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/*
 * 解析html
 */
public class JSOUP_Method {
	
	Document document = null;
	Elements links = null;
	public JSOUP_Method(String html) {
		document = Jsoup.parse(html);
//		System.out.println(html);
	}
	
//	public JSONArray Get_User_Base(boolean STATE){
//		JSONArray jsonArray =new JSONArray();
//		
//		links = document.select("ul").get(0).select("span");
//		
//		jsonArray.add(document.select("ul").get(0).select("li").get(4).text());
//		
//		for(int i=0;i<links.size();i++){
//			jsonArray.add(links.get(i).text());
//		}
//		System.out.println(jsonArray);
//		return jsonArray;
//	}
	//字符串分割取第二个
	public String[] splits(String s){
		String [] result=new String[10];
		 result = s.split("：");
		return result;
	}
	//基本信息取出字符串
	public JSONArray Get_User_Base(boolean STATE){
		JSONArray jsonArray =new JSONArray();
		JSONObject jo=new JSONObject();
		links = document.select("ul").get(0).select("span");
		String s1=document.select("ul").get(0).select("li").get(4).text();
//		System.out.println(splits(s1)[0]);
		jo.put(splits(s1)[0], splits(s1)[1]);
//		jsonArray.add(document.select("ul").get(0).select("li").get(4).text());
		for(int i=0;i<links.size();i++){
			jo.put(splits(links.get(i).text())[0],splits(links.get(i).text())[1]);
		}
//		System.out.println(jo);
		jsonArray.add(jo);
		System.out.println(jsonArray);
		return jsonArray;
	}
	//消费信息解析
	public JSONArray Get_User_ConsumeInfo(boolean STATE){
		JSONArray jsonArray =new JSONArray();
		JSONObject jo=new JSONObject();
		String[] s=new String[7];
		String[][] s1 =new String[100][7];
		links = document.select("table").get(0).select("tbody").get(0).select("tr");
//		jsonArray.add(document.select("ul").get(0).select("li").get(4).text());
		for(int i=0;i<links.get(3).select("th").size();i++){
//			jsonArray.add(links.get(3).select("th").get(i).text());
			s[i]=links.get(3).select("th").get(i).text();
		}
//		System.out.println(s[0]);
//		for(int i=4;i<links.get(3).select("td").size();i++){
////			System.out.println(links.get(i));
//				jsonArray.add(links.get(i).text());
//		}
//		System.out.println(links.size()-1);
		for(int i=4;i<links.size()-1;i++){
			for(int j=0;j<links.get(3).select("th").size();j++){
				try{
//					jsonArray.add(links.get(i).select("td").get(j).text());
					s1[i][j]=links.get(i).select("td").get(j).text();
//					System.out.println("i="+i+",j="+j+",s1["+i+"]["+j+"]="+s1[i][j]);
					jo.put(s[j], s1[i][j]);	
				}catch(Exception e){
					jsonArray.add(jo);
					System.out.println(jsonArray);
					return jsonArray;
				}finally{
					
				}

			}
			jsonArray.add(jo);
		}
		System.out.println(jsonArray);
		return jsonArray;
	}
	//交易汇总信息
	public JSONArray Get_User_CustStateInfo(boolean STATE) {
		// TODO Auto-generated method stub
		JSONArray jsonArray =new JSONArray();
		
		JSONObject jo=new JSONObject();
		String[] s=new String[4];
		String[][] s1=new String[100][4]; 
		links = document.select("table").get(0).select("tbody").get(0).select("tr");
//		System.out.println(links.get(3).select("th").size());
		for(int i=0;i<links.get(3).select("th").size();i++){
//			jsonArray.add(links.get(i).text());
			s[i]=links.get(3).select("th").get(i).text();
//			System.out.println(s[i]);
		}
//		System.out.println();
		for(int i=4;i<links.size()-1;i++){
			for(int j=0;j<links.get(3).select("th").size();j++){
//				jsonArray.add(links.get(i).select("td").get(j).text());
				try{
				s1[i][j]=links.get(i).select("td").get(j).text();
				jo.put(s[j], s1[i][j]);}
				catch (Exception e) {
					jsonArray.add(jo);
					System.out.println(jsonArray);
					return jsonArray;
				}
				finally{
					
				}
//				System.out.println(s1[i][j]);
//				System.out.println("i="+i+",j="+j+",s1["+i+"]["+j+"]="+s1[i][j]);
			}
			jsonArray.add(jo);
		}
		
	System.out.println(jo);
	return jsonArray;
	}
   //圈存信息
	public JSONArray Get_User_BankInfo(boolean b) {
		// TODO Auto-generated method stub
				JSONArray jsonArray =new JSONArray();
				JSONObject jo=new JSONObject();
				String[] s=new String[4];
				String[][] s1=new String[100][4]; 
				links = document.select("table").get(1).select("tbody").get(0).select("tr");
//				System.out.println(links.get(0).select("th").size());
				for(int i=0;i<links.get(0).select("th").size();i++){
//					jsonArray.add(links.get(i).text());
					s[i]=links.get(0).select("th").get(i).text();
//					System.out.println(s[i]);
				}
				for(int i=1;i<links.size()-1;i++){
					for(int j=0;j<links.get(0).select("th").size();j++){
//						jsonArray.add(links.get(i).select("td").get(j).text());
						try{
							s1[i][j]=links.get(i).select("td").get(j).text();
							System.out.println(s1[i][j]);
							jo.put(s[j], s1[i][j]);	
						}catch(Exception e){
							jsonArray.add(jo);
							System.out.println(jsonArray);
							return jsonArray;
						}finally{
							
						}
						
//						System.out.println("i="+i+",j="+j+",s1["+i+"]["+j+"]="+s1[i][j]);
					}
					jsonArray.add(jo);
				}
				
			System.out.println(jsonArray);
			return jsonArray;
	}
}
