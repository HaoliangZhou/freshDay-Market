package com.haoliang.freshday.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1、开启服务的注册发现 @EnableDiscoveryClient
 * 	1）、配置nacos注册中心地址
 */

@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FreshdayGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreshdayGatewayApplication.class, args);
	}

}
