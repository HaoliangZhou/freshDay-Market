package com.haoliang.freshday.cart.service.impl;

import com.haoliang.freshday.cart.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author zhouhaoliang
 * @Description
 * @date 2021 年 04 月 15 日 20:19
 */
@Slf4j
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    StringRedisTemplate redisTemplate;
}
