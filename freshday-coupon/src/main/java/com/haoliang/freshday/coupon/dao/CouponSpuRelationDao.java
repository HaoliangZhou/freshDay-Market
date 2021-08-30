package com.haoliang.freshday.coupon.dao;

import com.haoliang.freshday.coupon.entity.CouponSpuRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券与产品关联
 * 
 * @author zhouhaoliang
 * @email 614136484@qq.com
 * @date 2021-04-06 15:11:54
 */
@Mapper
public interface CouponSpuRelationDao extends BaseMapper<CouponSpuRelationEntity> {
	
}
