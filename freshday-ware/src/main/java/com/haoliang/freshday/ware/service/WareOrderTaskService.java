package com.haoliang.freshday.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.haoliang.common.utils.PageUtils;
import com.haoliang.freshday.ware.entity.WareOrderTaskEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author zhouhaoliang
 * @email 614136484@qq.com
 * @date 2021-04-06 15:43:36
 */
public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

