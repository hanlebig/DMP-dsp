/**
 * 
 */
package com.taiyear.dsp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.taiyear.dsp.marketing.entity.Marketing;
import com.taiyear.dsp.marketing.service.MarketingService;
import com.taiyear.dsp.simple.controller.SimpleController;

/**
 * @author liul
 * 
 *         可以在此处使用junit test 测试所有的controller service 直接Autowired就好
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = QuickStart.class)
public class QuickTest {

	@Autowired
	public MarketingService marketingService;
	@Before
	public void before() {
		System.out.println("开始之前要做一些事情");
	}

	@Test
	public void test() {
		Marketing marketing = new Marketing();
		marketing.setMarketingName("爱奇艺大促销");
		marketing.setSendAddress("18331596765");
		marketing.setFilePath("ddsadsa");
		marketing.setMarketingContent("爱奇艺大促销!");
		marketingService.saveSMMS(marketing);
	}

	@After
	public void after() {
		System.out.println("完成之后再做一些事情");
	}
}
