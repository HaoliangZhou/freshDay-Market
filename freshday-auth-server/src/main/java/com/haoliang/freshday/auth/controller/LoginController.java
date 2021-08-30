package com.haoliang.freshday.auth.controller;

import com.haoliang.common.utils.R;
import com.haoliang.freshday.auth.feign.MemberFeignService;
import com.haoliang.freshday.auth.vo.UserLoginVo;
import com.haoliang.freshday.auth.vo.UserRegistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhouhaoliang
 * @Description
 * @date 2021 年 04 月 13 日 20:20
 */

@Controller
public class LoginController {

    @Autowired
    MemberFeignService memberFeignService;

    /**
     * 发送一个请求直接跳转到一个页面
     * SpringMVC viewcontroller；将请求和页面映射过来，
     *
     *
     */


//    @GetMapping("/login.html")
//    public String loginPage(){
//        return "login";
//    }
//
//    @GetMapping("/reg.html")
//    public String regPage(){
//        return "reg";
//    }


//    //注册请求
    @PostMapping("/regist")
    public String regist(@Valid UserRegistVo vo, Model model
                         ) {
        //校验信息放到BindingResult result中，如果发生错误，转发到注册页
        //RedirectAttributes redirectAttributes模拟重定向携带数据
//        if(result.hasErrors()){
            /**
             * .map(fieldError -> {
             *                 String field = fieldError.getField();
             *                 String defaultMessage = fieldError.getDefaultMessage();
             *                 errors.put(field,defaultMessage);
             *                 return
             *             });
             */
            //key value的map
//            Map<String, String> errors = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage));
//            model.addAttribute("errors",errors);
//            redirectAttributes.addFlashAttribute("errors",errors);
            //Request method 'POST' not supported
            //用户注册->/regist[post]->转发reg.html（post发goet 所以不支持）
            //校验出错转发到注册页
//            return "redirect:http://localhost:20000/reg.html";

        //前面校验没问题，开始真正注册，调用远程服务
        R r = memberFeignService.regist(vo);

        //注册成功回到首页、登录页
        return "redirect:/login.html";
    }



    //登录请求
    @PostMapping("/login")
    public String login(UserLoginVo vo){

        //远程登录
        R login = memberFeignService.login(vo);


        return "redirect:http://localhost:12000/index.html";
    }
    /**
     * 发送一个请求直接跳转到一个页面
     * SpringMVC viewcontroller；将请求和页面映射过来，
     *
     *
     */


//    @GetMapping("/login.html")
//    public String loginPage(){
//        return "login";
//    }
//
//    @GetMapping("/reg.html")
//    public String regPage(){
//        return "reg";
//    }


}
