package com.haoliang.freshday.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**1、想要远程调用别的服务
 * 	1）、引入open-feign
 * 	2）、编写一个接口，告诉springcloud这个接口需要调用远程服务
 * 		1、声明接口的每一个方法都是调用哪个服务的哪个请求
 * 	3）、开启远程调用功能 @EnableFeignClients,
 * 	如本页@EnableFeignClients(basePackages = "com.haoliang.freshday.member.feign")
 * 	会扫描com.haoliang.freshday.member.feign包里的所有@FeignClient，现在我们去看那个feign包的
 * 	的 @CouponFeignService。。。
 */
@EnableFeignClients(basePackages = "com.haoliang.freshday.member.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class FreshdayMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreshdayMemberApplication.class, args);
	}

}
