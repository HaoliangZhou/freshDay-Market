package com.haoliang.freshday.member.controller;

import java.util.Arrays;
import java.util.Map;

import com.haoliang.freshday.member.exception.PhoneExistException;
import com.haoliang.freshday.member.exception.UsernameExistException;
import com.haoliang.freshday.member.feign.CouponFeignService;
import com.haoliang.freshday.member.vo.MemberLoginVo;
import com.haoliang.freshday.member.vo.MemberRegistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.haoliang.freshday.member.entity.MemberEntity;
import com.haoliang.freshday.member.service.MemberService;
import com.haoliang.common.utils.PageUtils;
import com.haoliang.common.utils.R;



/**
 * 会员
 *
 * @author zhouhaoliang
 * @email 614136484@qq.com
 * @date 2021-04-06 15:26:40
 */
@RestController
@RequestMapping("member/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    CouponFeignService couponFeignService;

    @RequestMapping("/coupons")
    public R test(){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname("张三");

        R membercoupons = couponFeignService.membercoupons();

//      前面put的本地的“张三”，后面put的是远程调用的“优惠券信息”,来源于“Coupon模块下面CouponController.java文件”
        return R.ok().put("member",memberEntity).put("coupons",membercoupons.get("coupons"));
    }

    //注册
    @PostMapping("/regist")
    public R regist(@RequestBody MemberRegistVo vo){

        try{
            memberService.regist(vo);
        }catch (PhoneExistException e){
            return R.ok();
        }catch (UsernameExistException e){
            return R.ok();
        }
        return R.ok();
    }

    //登录功能
    @PostMapping("/login")
    public R login(@RequestBody MemberLoginVo vo){

        MemberEntity entity = memberService.login(vo);
        if(entity!=null){
            return R.ok();
        }else {
            return R.error();
        }

    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:member:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:member:info")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:member:save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:member:update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:member:delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
