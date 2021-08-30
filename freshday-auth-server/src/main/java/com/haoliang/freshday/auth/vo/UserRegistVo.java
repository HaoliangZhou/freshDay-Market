package com.haoliang.freshday.auth.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author zhouaholiang
 * @Description
 * @date 2021 年 04 月 14 日 14:59
 */

@Data
public class UserRegistVo {
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 6,max = 18,message = "用户名必须是6-18位字符")
    private String userName;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 6,max = 18,message = "密码必须是6-18位字符")
    private String password;

    @NotEmpty(message = "手机号不能为空")
    @Pattern(regexp="^[1][0-9]{10}$",message = "手机号格式不正确")
    private String phone;
}
//    @NotEmpty(message = "验证码不能为空")
//    private String code;

