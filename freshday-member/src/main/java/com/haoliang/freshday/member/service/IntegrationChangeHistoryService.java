package com.haoliang.freshday.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.haoliang.common.utils.PageUtils;
import com.haoliang.freshday.member.entity.IntegrationChangeHistoryEntity;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author zhouhaoliang
 * @email 614136484@qq.com
 * @date 2021-04-06 15:26:40
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

