package com.haoliang.freshday.auth.feign;

import com.haoliang.common.utils.R;
import com.haoliang.freshday.auth.vo.UserLoginVo;
import com.haoliang.freshday.auth.vo.UserRegistVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhouhaoliang
 * @Description
 * @date 2021 年 04 月 14 日 17:27
 */
@FeignClient("freshday-member")
public interface MemberFeignService {
    //调用远程注册
    @PostMapping("/member/member/regist")
    R regist(@RequestBody UserRegistVo vo);

    //调用远程登录
    @PostMapping("/member/member/login")
    R login(@RequestBody UserLoginVo vo);
}
