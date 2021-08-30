package com.haoliang.freshday.product.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author LYJ
 * @Description
 * @date 2021 年 04 月 13 日 17:09
 */


//2级分类vo
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Catelog2Vo {
    private String catalog1Id;//1级父分类id
    private List<Catelog3Vo> catalog3List;//3级子分类
    private String id;
    private String name;

    /**
     * 3级分类vo
     *  "catalog2Id":"1",
     *                     "id":"1",
     *                     "name":"电子书"
     *                 },
     */
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Catelog3Vo {
        private String catalog2Id;//2级父分类id
        private String id;
        private String name;
    }
}
