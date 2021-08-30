package com.haoliang.freshday.member.service.impl;

import com.haoliang.freshday.member.dao.MemberLevelDao;
import com.haoliang.freshday.member.entity.MemberLevelEntity;
import com.haoliang.freshday.member.exception.PhoneExistException;
import com.haoliang.freshday.member.exception.UsernameExistException;
import com.haoliang.freshday.member.vo.MemberLoginVo;
import com.haoliang.freshday.member.vo.MemberRegistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.haoliang.common.utils.PageUtils;
import com.haoliang.common.utils.Query;

import com.haoliang.freshday.member.dao.MemberDao;
import com.haoliang.freshday.member.entity.MemberEntity;
import com.haoliang.freshday.member.service.MemberService;


@Service("memberService")
public class MemberServiceImpl extends ServiceImpl<MemberDao, MemberEntity> implements MemberService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MemberEntity> page = this.page(
                new Query<MemberEntity>().getPage(params),
                new QueryWrapper<MemberEntity>()
        );

        return new PageUtils(page);
    }

    //注册 写数据
    @Autowired
    MemberLevelDao memberLevelDao;
    @Override
    public void regist(MemberRegistVo vo) {
        MemberDao memberDao = this.baseMapper;
        MemberEntity entity = new MemberEntity();
        //设置默认等级
        MemberLevelEntity levelEntity = memberLevelDao.getDefaultLevel();
        entity.setLevelId(levelEntity.getId());
        //开始设置写入
        //检查用户名手机号是否唯一
        checkPhoneUnique(vo.getPhone());
        checkUsernameUnique(vo.getUserName());
        entity.setMobile(vo.getPhone());
        entity.setUsername(vo.getUserName());
        //加密存储。加盐
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode(vo.getPassword());
        entity.setPassword(encode);
        //其他的用户信息，以后设置
        //插入保存
        memberDao.insert(entity);
    }
    //抛出手机号 用户名已存在的异常
    @Override
    public void checkPhoneUnique(String phone) throws PhoneExistException {
        MemberDao memberDao = this.baseMapper;
        Integer mobile = memberDao.selectCount(new QueryWrapper<MemberEntity>().eq("mobile",phone));
        if(mobile>0){//计数>0
            throw new PhoneExistException();
        }
    }
    @Override
    public void checkUsernameUnique(String username) throws UsernameExistException{
        MemberDao memberDao = this.baseMapper;
        Integer count = memberDao.selectCount(new QueryWrapper<MemberEntity>().eq("username", username));
        if(count>0) {
            throw new UsernameExistException();
        }
    }


    //    登录查数据
    @Override
    public MemberEntity login(MemberLoginVo vo) {

        String loginacct = vo.getLoginacct();
        String password = vo.getPassword();// 比如123456

//      //1、去数据库查询 SELECT * FROM ums_member where username=? or mobile=?
        MemberDao memberDao = this.baseMapper;
        MemberEntity entity = memberDao.selectOne(new QueryWrapper<MemberEntity>().eq("username", loginacct)
                .or().eq("mobile", loginacct));

        if (entity == null){
            //没有账号登录失败
            return null;
        }else{
            //1、获取到数据库额度password
            String passwordDb = entity.getPassword();
            //2.1、盐值解码
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            //2.2、并匹配（明文，密文）
            boolean matches = passwordEncoder.matches(password, passwordDb);
            if(matches){//匹配成功
                return entity;
            }else{
                return null;
            }
        }
    }


}