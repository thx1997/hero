package com.hero.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * 
 * @author public
 *
 */
@SpringBootApplication//表明这是一个配置类
public class MyConfig extends WebMvcConfigurerAdapter{
	@Autowired
	private LoginInterceptor loginInterceptor;
	/**
	 * 自定义拦截器
	 * 继承WebMvcConfigurerAdapter,重写addInterceptors方法
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
	}
}
