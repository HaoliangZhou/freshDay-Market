package com.haoliang.freshday.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhouhaoliang
 * @Description
 * @date 2021 年 04 月 13 日 20:56
 */

@Configuration
public class FreshdayWebConfig implements WebMvcConfigurer {


    /**
     * 视图映射
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry){

        /**
         * 原来要这样写
         * @GetMapping("/login.html")
         *     public String loginPage(){
         *         return "login";
         *     }
         */

        /**
         * 现在
         */
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/reg.html").setViewName("reg");
    }
}
