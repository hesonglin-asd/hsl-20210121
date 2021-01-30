package com.bdqn.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b>用户信息管理 Provider 项目启动类</b>
 * @author hsl
 * @version 5.0.0-final
 */
@MapperScan("com.bdqn.project.dao")
@EnableEurekaClient
@SpringBootApplication
public class UmsProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(UmsProviderStarter.class, args);
	}
}
