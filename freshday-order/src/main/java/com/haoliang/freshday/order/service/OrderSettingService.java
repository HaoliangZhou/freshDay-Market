package com.haoliang.freshday.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.haoliang.common.utils.PageUtils;
import com.haoliang.freshday.order.entity.OrderSettingEntity;

import java.util.Map;

/**
 * 订单配置信息
 *
 * @author zhouhaoliang
 * @email 614136484@qq.com
 * @date 2021-04-06 15:38:28
 */
public interface OrderSettingService extends IService<OrderSettingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

