package com.haoliang.freshday.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1、如何使用Nacos作为配置中心统一管理配置，记得首先开启nacos服务
 * 	1）、引入依赖，直接在common的pom里
 *         <dependency>
 *             <groupId>com.alibaba.cloud</groupId>
 *             <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
 *         </dependency>
 *  2）、创建一个bootstrap.properties文件，添加2个内容
 *  		spring.application.name=“xxx”
 * 			spring.cloud.nacos.config.server-addr=127.0.0.1:8848
 * 	3）、需要给配置中心默认添加一个名为“xxx.properties”的数据集（即DataID)
 * 	4）、在Nacos的配置列表里找到“xxx.properties”，并可以写入配置
 * 	5）、动态获取配置。
 * 		1、@RefreshScope 动态刷新配置
 * 		2、@Value("${coupon.user.name}") 动态获取某个配置的值
 * 	6）、tips:如果nacos配置中心和本地配置的项目相同的话，优先使用配置中心的哦。
 * 		比如配置中心是“zhangsan”，本地application.properties里是“zhangsan1”.
 * 		==> 优先使用“zhangsan”
 *
 * 2、细节
 * 	1）、命名空间：配置隔离
 * 		默认public(保留空间)：默认新增的所有配置都在public空间
 * 		例：1、建立dev、test、prop各种空间 来做环境隔离,通过修改bootstrap.properties
 * 			  的namespace=60192e0c-6111-4130-aa72-f28cb0ac6223
 * 			 （注意：namespace后面必须写唯一id不能写比如“prop”这样的名字）
 * 			2、每一个微服务之间相互隔离配置，每一个微服务都创建自己的命名空间，只加载自己命名空间下的所有配置
 *
 * 	2）、配置集：所有配置的集合
 *
 * 	3）、配置集ID：类似于文件名。nacos中就是“Data ID”类似于文件名
 *
 * 	4）、配置分组
 * 		默认所有的配置集都属于“DEFAULT_GROUP”
 * 		通过修改bootstrap.properties中的spring.cloud.nacos.config.group=1111
 *
 *每个微服务创建自己的命名空间，使用配置分组区分环境，dec、test、prod
 *
 * 3、同时加载多个配置集
 * 	1）、微服务任何配置信息，任何配置文件都可以放在配置中心里
 * 	2）、只需在bootstrap.properties中说明加载配置中心的哪些配置文件即可
 * 	3）、@value,@configurationProperties等。。。
 * 	以前SpringBoot任何方式从配置文件中获取值都能使用。
 * 	配置中心有的，优先使用配置中心里的
 *
 */

@EnableDiscoveryClient
@SpringBootApplication
public class FreshdayCouponApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreshdayCouponApplication.class, args);
	}

}
