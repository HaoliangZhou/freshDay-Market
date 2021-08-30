package com.haoliang.freshday.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhouhaoliang
 * @Description
 * @date 2021 年 04 月 16 日 20:45
 */
@Controller
public class TraceResultController {
    @GetMapping("/traceResult.html")
    public String traceSourcePage(){
        return "traceResult";
    }
}
