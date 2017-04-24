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
import com.taiyear.dsp.marketing.entity.Marketing;
import com.taiyear.dsp.marketing.entity.thread.ResultJson;

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
	public void add(){
		Marketing market = new Marketing();
		market.setMarketingType("3");
		market.setMarketingName("爱奇艺会员日");
		market.setMarketingStatus("1");
		//market.setMarketingSize(marketingSize);
		market.setCompanyId("24c2410f-025a-4eb7-8e90-1ee3fb33fea3");
		market.setMarketingContent("【爱奇艺】爱奇艺会员春季大放送7折起，推荐新人更有好礼送，点击：http://www.dianxiaomi.net/home/index/buy");
		market.setSendAddress("sssss");
		ResultJson res = marketController.saveSMS(market);
		System.out.println(res);
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
