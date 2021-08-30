package com.haoliang.freshday.coupon.dao;

import com.haoliang.freshday.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author zhouhaoliang
 * @email 614136484@qq.com
 * @date 2021-04-06 15:11:54
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
