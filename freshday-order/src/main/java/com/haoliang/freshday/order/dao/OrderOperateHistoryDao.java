package com.haoliang.freshday.order.dao;

import com.haoliang.freshday.order.entity.OrderOperateHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单操作历史记录
 * 
 * @author zhouhaoliang
 * @email 614136484@qq.com
 * @date 2021-04-06 15:38:28
 */
@Mapper
public interface OrderOperateHistoryDao extends BaseMapper<OrderOperateHistoryEntity> {
	
}
