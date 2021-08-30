package com.haoliang.freshday.product.dao;

import com.haoliang.freshday.product.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 * 
 * @author zhouhaoliang
 * @email 614136484@qq.com
 * @date 2021-04-05 23:17:03
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {
	
}
