package com.haoliang.freshday.product.web;

import com.haoliang.freshday.product.entity.CategoryEntity;
import com.haoliang.freshday.product.service.CategoryService;
import com.haoliang.freshday.product.vo.Catelog2Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author LYJ
 * @Description
 * @date 2021 年 04 月 13 日 16:19
 */
@Controller
public class IndexController {

    @Autowired
    CategoryService categoryService;

    @GetMapping({"/","/index.html"})
    public String indexPage(Model model){

        //TODO 1、查出所有一级分类
        List<CategoryEntity> categoryEntities = categoryService.getLevel1Categorys();
        //视图解析器进行拼串
        // 默认前缀 classpath:/templates/  + 返回值index +  默认后缀 .html
        model.addAttribute("categorys",categoryEntities);
        return "index";
    }

    //index/catalog.json

    @ResponseBody
    @GetMapping("/index/catalog.json")
    public Map<String, List<Catelog2Vo>> getCatelogJson(){
        Map<String, List<Catelog2Vo>> catelogJson = categoryService.getCatelogJson();
        return catelogJson;
    }
}
