package com.bdqn.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b>用户信息管理 Consumer 项目启动类</b>
 * @author hsl
 * @version 5.0.0-final
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class UmsConsumerStarter {
	public static void main(String[] args) {
		SpringApplication.run(UmsConsumerStarter.class, args);
	}
}
