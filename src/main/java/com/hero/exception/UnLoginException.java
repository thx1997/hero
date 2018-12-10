package com.hero.exception;
/**
 * 自定义异常
 * @Description:   无Token用户未登录异常
	@author         public     
 */
public class UnLoginException extends Exception {
	
	
	public UnLoginException(){
		super("用户未登录异常");
	}
	
	public UnLoginException(String info){
		super(info);
	}

}
