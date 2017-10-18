package com.Jsoup;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JsoupMethod {
	
	Document doc = null;
	Elements links = null;
	String Data = null;
	String Value = null;

	public void  setDoc(String html){
		doc = Jsoup.parse(html);
	}
	public int GetPage() {
		String page = "1";

		String html = doc.toString();
		
		String regEx = "'(?<page>\\d+)'";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(html);
		while (matcher.find()) {
			page = matcher.group(1);
		}
//		System.out.println("This is Page  " + page);

		return Integer.parseInt(page);
	}

	public String[] GetInfo() {
		String [] re=new String[10];
        return re;
	}
	//对存款信息数据进行正则表达式取出
	public void Get_depositinfo_List(){
		System.out.println("共计多少页："+this.GetPage());
		links = doc.select("tbody");
		List<String> List=new ArrayList<>();
		boolean stop=false;
		links = links.get(1).select("td");
		//操作时间	科目描述	主钱包交易金额	主钱包余额	工作站	终端名称
		//共计6组数据
		for (int i = 0; i < links.size()&&!stop; i++) {
			Data = links.get(i).text();
			if(Data.contains("抱歉，没有发现符合条件")||Data.contains("?")){
				stop=true;
			}else{
				List.add(Data);
			}
		}
		if(List.size()!=0){
			
		
			for (int i = 0; i < List.size(); i+=6) {
				System.out.println(List.get(i));
			}	
		}else{
			System.out.println("没有圈存数据");
		}
	}
	//取出消费信息页面的内容
	//操作时间	科目描述	钱包交易金额	钱包余额	操作员	工作站	终端名称
	public void Get_ConsumeInfo_List(){
		Elements trs = doc.select("tbody").select("tbody");
		System.out.println(trs.size());
		if(trs.size()>=2){
		for(int i=0;i<trs.size();i++){
		}
		List<String> List=new ArrayList<>();
		//用for循环来取
		trs=trs.get(2).select("td");
		boolean stop=false;
		for(int i=0;i<trs.size();i++){
			Data = trs.get(i).text();
//			System.out.println(trs.get(i).text());
			if(Data.contains("抱歉，没有发现符合条件")||Data.contains("?")){
				stop=true;
			}else{
				List.add(Data);
			}
		}
		if(List.size()!=0){
			
			
			for (int i = 0; i < List.size(); i+=7) {
				System.out.println(List.get(i));
			}	
		}else{
			System.out.println("没有消费记录");
		}
		}
	}
	//取出总消费信息页面的内容
	//交易科目代码	交易科目描述	钱包交易总额	钱包管理费总额
	public void Get_CustStateInfo_List(){
		Elements trs = doc.select("tbody").select("tbody");
//		System.out.println(trs.size());
		if(trs.size()>=2){
		List<String> List=new ArrayList<>();
		//用for循环来取
		trs=trs.get(2).select("td");
		boolean stop=false;
		for(int i=0;i<trs.size()&&!stop;i++){
			Data = trs.get(i).text();
//			System.out.println(trs.get(i).text());
//			System.out.println(trs.get(i));
			if(Data.contains("抱歉，没有发现符合条件")||trs.get(i).toString().contains("&nbsp;")){
				stop=true;
			}else{
				List.add(Data);
			}
		}
		if(List.size()!=0){
			
			
			for (int i = 0; i < List.size(); i++) {
				System.out.println(List.get(i));
			}	
		}else{
			System.out.println("没有总消费数据");
		}
		}
	}
}
