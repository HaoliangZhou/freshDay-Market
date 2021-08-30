package com.haoliang.freshday.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1、整合MyBatis-Plus
 * 		1)、导入依赖
 * 	 	   <dependency>
 *             <groupId>com.baomidou</groupId>
 *             <artifactId>mybatis-plus-boot-starter</artifactId>
 *             <version>3.2.0</version>
 *         </dependency>
 *      2）、配置
 *      	1、配置数据源
 *      		1)、导入数据库的驱动。
 *      		2)、在application.yml里配置数据源相关信息
 *      	2、配置Mybatis-Plus
 *      		1)、使用@MapperScan
 *      		2)、告诉MyBatis-plus,sql映射文件位置
 * 2、逻辑删除
 *	 1)、配置全局的逻辑删除规则（可省略）
 *		global-config:
 *     		db-config:
 *       		id-type: auto
 *       		logic-delete-value: 1
 *       		logic-not-delete-value: 0
 *   2）、配置逻辑删除的组件Bean（可省略）
 *   3）、给Bean加上逻辑删除注解 @TableLogic
 *
 * 5、模板引擎
 * 	 1）、thymeleaf-starter：关闭缓存
 * 	 2）、静态资源都放在static文件夹下就可以按照路径直接访问
 * 	 3）、页面都放在templates下，直接访问
 * 	 	Springboot，访问项目时 默认会找index页面
 * 	 4)、不重启服务器的情况下 实时更新页面
 * 	 	1、引入dev-tools
 * 	    2、修改完页面用 ctrl+shift+F9重新编译页面
 * 	    （但如果是代码配置修改 还是建议重新启动服务）
 */
@EnableDiscoveryClient
@MapperScan("com/haoliang/freshday/product/dao")
@SpringBootApplication
public class FreshdayProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreshdayProductApplication.class, args);
	}

}
