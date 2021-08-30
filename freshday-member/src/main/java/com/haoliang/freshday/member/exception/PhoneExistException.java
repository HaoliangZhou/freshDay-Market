package com.haoliang.freshday.member.exception;

/**
 * @author zhouhaoliang
 * @Description
 * @date 2021 年 04 月 14 日 16:36
 */
public class PhoneExistException extends RuntimeException{

    public PhoneExistException() {
        super("手机号存在");
    }
}
