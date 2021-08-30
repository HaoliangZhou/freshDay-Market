package com.haoliang.freshday.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.haoliang.common.utils.PageUtils;
import com.haoliang.freshday.coupon.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author zhouhaoliang
 * @email 614136484@qq.com
 * @date 2021-04-06 15:11:54
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

