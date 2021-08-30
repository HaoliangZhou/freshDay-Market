package com.haoliang.freshday.member.dao;

import com.haoliang.freshday.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author zhouhaoliang
 * @email 614136484@qq.com
 * @date 2021-04-06 15:26:40
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {

    static void selectOne() {
    }
}
