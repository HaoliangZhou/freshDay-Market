package com.haoliang.freshday.member;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.testng.annotations.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class FreshdayMemberApplicationTests {

	@Test
	void contextLoads() {

		//		String s = DigestUtils.md2Hex("123456");
//		//MD5不能直接进行密码的加密存储
//			//会这样"123456"+System.currentTimeMills();
//		//所以用盐值加密；随机值
//		String s1 = Md5Crypt.md5Crypt("123456".getBytes(),"$1$qqqqqqqq");
//
//		System.out.println(s);
//		System.out.println(s1);

		//加密
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encode = passwordEncoder.encode("123456");

		//解析
		passwordEncoder.matches("明文123456","密文");
		System.out.println(encode);
	}

}
