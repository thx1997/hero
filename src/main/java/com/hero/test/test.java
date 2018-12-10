package com.hero.test;

import com.hero.util.PasswordEncoder;

public class test {

	public static void main(String[] args) {
		PasswordEncoder encoder=null;
		encoder = new PasswordEncoder("admin", "Md5");	
		String pwd=encoder.encode("ysd123", 5);
		System.out.println("加密后的密码："+pwd);
	}

}
