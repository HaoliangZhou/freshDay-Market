package com.haoliang.freshday.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhouhaoliang
 * @Description
 * @date 2021 年 04 月 16 日 14:33
 */

@Controller
public class ItemController {

    @GetMapping("/item.html")
    public String skuItem(){
        return "item";
    }
}
