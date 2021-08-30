package com.haoliang.freshday.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.haoliang.common.utils.PageUtils;
import com.haoliang.freshday.product.entity.ProductAttrValueEntity;

import java.util.Map;

/**
 * spu属性值
 *
 * @author zhouhaoliang
 * @email 614136484@qq.com
 * @date 2021-04-05 23:17:03
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

