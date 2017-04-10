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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.taiyear.dsp.marketing.entity.Marketing;
import com.taiyear.dsp.marketing.entity.thread.ResultJson;
import com.taiyear.dsp.marketing.repoDao.MarketingRepository;
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
	@Autowired
	public MarketingRepository marketingRepository;
	@Before
	public void before() {
		System.out.println("开始之前要做一些事情");
	}

	@Test
	public void test() {
//		Pageable pageable = new PageRequest(1, 3);
//		Page<Marketing> pages = marketingRepository.findAll(pageable);
//		System.out.println(pages.getSize());
		//==============================================
		
		
		//================================================
		Marketing marketing = new Marketing();
		marketing.setMarketingName("爱奇艺大促销");
		marketing.setSendAddress("18331596765");
		marketing.setFilePath("C:\\Users\\Administrator\\Desktop\\DMP-dsp\\down\\dsp\\src\\main\\webapp\\upload_files\\2017\\04\\07\\cd28c55c-8a4a-4362-b6b8-13f3b05248e5.jpg");
		marketing.setMarketingContent("爱奇艺大促销!http://www.xdns.cn/html/20170407519.html");
		marketing.setMarketingSize("653");
		ResultJson res= marketingService.saveSMMS(marketing);
		System.out.println(res.getMsg());
	}

	@After
	public void after() {
		System.out.println("完成之后再做一些事情");
	}
}
