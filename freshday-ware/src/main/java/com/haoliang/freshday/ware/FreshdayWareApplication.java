package com.haoliang.freshday.ware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.haoliang.freshday.ware.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class FreshdayWareApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreshdayWareApplication.class, args);
	}

}
