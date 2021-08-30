package com.haoliang.freshday.cart.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhouhaoliang
 * @Description
 * @date 2021 年 04 月 15 日 15:22
 *
 * 购物车内容
 * 需要计算的属性 必须重写他的get方法，保证每次获取属性都会进行计算
 */
public class Cart {
    List<CartItem> items;

    private Integer countNum;//商品数量 如：两种商品
    private Integer countType;//商品类型数量 如：两个种类
    private BigDecimal totalAmount;//商品总价
    private BigDecimal reduce = new BigDecimal("0.00");//减免价格

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public Integer getCountNum() {
        int count=0;
        if(items!=null && items.size()>0){
            for (CartItem item : items) {
                count += item.getCount();
            }
        }
        return count;
    }

    public Integer getCountType() {
        int count=0;
        if(items!=null && items.size()>0){
            for (CartItem item : items) {
                count += 1;
            }
        }
        return count;
    }

    public BigDecimal getTotalAmount() {
        BigDecimal amount = new BigDecimal("0");
        //1、计算购物项总价
        if(items!=null && items.size()>0){
            for (CartItem item : items) {
                BigDecimal totalPrice = item.getTotalPrice();
                amount = amount.add(totalPrice);
            }
        }
        //2、减去优惠总价
        BigDecimal subtract = amount.subtract(getReduce());
        //3、最终总价
        return subtract;
    }

    public BigDecimal getReduce() {
        return reduce;
    }

    public void setReduce(BigDecimal reduce) {
        this.reduce = reduce;
    }
}
