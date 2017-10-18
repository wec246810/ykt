package com.ysk.Utils;

public class Vemail {
	public Boolean vemail(String email){
		String rules="\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
		if(!email.matches(rules)){
			
			System.out.println("ÓÊÏäÆ¥Åä´íÎó");
			return false;
		}
		System.out.println("ÓÊÏäÆ¥ÅäÕıÈ·");
		return true;
	}
}
