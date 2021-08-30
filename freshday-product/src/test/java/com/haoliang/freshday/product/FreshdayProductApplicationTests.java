package com.haoliang.freshday.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.haoliang.freshday.product.entity.BrandEntity;
import com.haoliang.freshday.product.service.BrandService;
//import org.junit.jupiter.api.Test;
import com.haoliang.freshday.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
class FreshdayProductApplicationTests {

	@Autowired
	BrandService brandService;

	@Autowired
	CategoryService categoryService;

	@Test
	public void testFindPath(){
		Long[] catelogPath = categoryService.findCatelogPath(225L);
		log.info("完整路径:{}", Arrays.asList(catelogPath));
	}

	@Test
	void contextLoads() {

//测试：插入在pms_Brand中插入“华为”
//		BrandEntity brandEntity = new BrandEntity();
//		brandEntity.setName("华为");
//		brandService.save(brandEntity);
//		System.out.println("保存成功....");

//测试：修改某字段的“描述”
//		BrandEntity brandEntity = new BrandEntity();
//		brandEntity.setBrandId(1L);
//		brandEntity.setDescript("华为手机");
//		brandService.updateById(brandEntity);

//测试：查询
		List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id",1L));
		list.forEach((item)->{
			System.out.println(item);
		});
	}

}
