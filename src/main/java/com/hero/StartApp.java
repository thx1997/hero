package com.hero;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Spring Boot 应用启动类
 *123
 */
@SpringBootApplication//springboot应用的标识
@MapperScan("com.hero.repository")

public class StartApp 
{
    public static void main( String[] args )
    {
    	SpringApplication springApplication=new SpringApplication(StartApp.class);
    	//禁止命令行设置参数
    	springApplication.setAddCommandLineProperties(false);
    	springApplication.run(args);
    }
}
