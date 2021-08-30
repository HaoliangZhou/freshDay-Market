package com.haoliang.freshday.member.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author zhouhaoliang
 * @Description
 * @date 2021 年 04 月 14 日 16:13
 */

@Data
public class MemberRegistVo {

    private String userName;
    private String password;
    private String phone;


}
