package com.haoliang.freshday.member.feign;

import com.haoliang.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhouhaoliang
 * @Description
 * @date 2021 年 04 月 10 日 13:57
 */


/**
 * 这是一个声明式的远程调用
 * 这里说明了远程调用了“freshday-coupon”服务的“/coupon/coupon/member/list”请求
 */
@FeignClient("freshday-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();
}
