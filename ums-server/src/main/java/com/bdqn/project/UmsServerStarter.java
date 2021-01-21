package com.bdqn.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <b>用户信息管理注册中心启动类</b>
 * @author hsl
 * @version 5.0.0-final
 */
@EnableEurekaServer
@SpringBootApplication
public class UmsServerStarter {
	public static void main(String[] args) {
		SpringApplication.run(UmsServerStarter.class, args);
	}
}
