package com.haoliang.freshday.cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhouhaoliang
 * @Description
 * @date 2021 年 04 月 15 日 20:35
 */

@Controller
public class CartController {

    @GetMapping("/cart")
    //等到用户信息
    public String cartListPage(){
        return "cartList";
    }

    //添加商品到购物车
    @GetMapping("/addToCart")
    public String addToCart() {
        return "success";
    }
}
