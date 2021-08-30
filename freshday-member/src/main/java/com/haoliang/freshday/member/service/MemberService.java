package com.haoliang.freshday.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.haoliang.common.utils.PageUtils;
import com.haoliang.freshday.member.entity.MemberEntity;
import com.haoliang.freshday.member.exception.PhoneExistException;
import com.haoliang.freshday.member.exception.UsernameExistException;
import com.haoliang.freshday.member.vo.MemberLoginVo;
import com.haoliang.freshday.member.vo.MemberRegistVo;

import java.util.Map;

/**
 * 会员
 *
 * @author zhouhaoliang
 * @email 614136484@qq.com
 * @date 2021-04-06 15:26:40
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);


    void regist(MemberRegistVo vo);

    void checkPhoneUnique(String phone) throws PhoneExistException;

    void checkUsernameUnique(String username) throws UsernameExistException;

    MemberEntity login(MemberLoginVo vo);

}

