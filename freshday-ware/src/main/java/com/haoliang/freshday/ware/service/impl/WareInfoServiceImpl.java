package com.haoliang.freshday.ware.service.impl;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haoliang.common.utils.PageUtils;
import com.haoliang.common.utils.Query;

import com.haoliang.freshday.ware.dao.WareInfoDao;
import com.haoliang.freshday.ware.entity.WareInfoEntity;
import com.haoliang.freshday.ware.service.WareInfoService;
import org.springframework.util.StringUtils;


@Service("wareInfoService")
public class WareInfoServiceImpl extends ServiceImpl<WareInfoDao, WareInfoEntity> implements WareInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        //仓库号的模糊检索
        QueryWrapper<WareInfoEntity> wareInfoEntityQueryWrapper = new QueryWrapper<>();
        String key = (String) params.get("key");
        //首先判断
        if(!StringUtils.isEmpty(key)){
            wareInfoEntityQueryWrapper.eq("id",key)
                    .or().like("name",key)
                    .or().like("address",key);
        }
        //检索
        IPage<WareInfoEntity> page = this.page(
                new Query<WareInfoEntity>().getPage(params),
                wareInfoEntityQueryWrapper
        );

        return new PageUtils(page);
    }

}