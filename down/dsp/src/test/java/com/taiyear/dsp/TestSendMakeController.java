package com.taiyear.dsp;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.MultipartFile;

import com.taiyear.dsp.marketing.controller.MarketController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = QuickStart.class)
public class TestSendMakeController {
	@Autowired
	MarketController marketController;
	
	
	@Before
	public void before() {
		System.out.println("开始之前要做一些事情");
	}

	@Test
	public void test() {
		File file = new File("C:\\Users\\Administrator\\Desktop\\323.xml.txt"); 
		MultipartFile multipartFile = (MultipartFile)file; 
		System.out.println(multipartFile.getName());
//		marketController.handleFileUpload(file);
		System.out.println("测试的时候要做一些事情");
	}

	@After
	public void after() {
		System.out.println("完成之后再做一些事情");
	}
}
