package com.hero.exception;

/**
 * 自定义异常
 * @Description:   没有访问权限异常
     @author         public         
 */
public class NoPermissionException extends Exception{
	
	public NoPermissionException(){
		super("没有访问权限异常");
	}
	
	public NoPermissionException(String info){
		super(info);
	}

}
