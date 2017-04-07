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
	SimpleController sc;

	// @Autowired PlanService planService;

	@Before
	public void before() {
		System.out.println("开始之前要做一些事情");
	}

	@Test
	public void test() {
		System.out.println("测试的时候要做一些事情");
		// sc.save();
		// sc.index("");
		// sc.index1("");
		// sc.index2("");
		// sc.index3("7e49f974-493e-47ab-a4ba-ab9e8cc9c731");
		// sc.index4("1", "9fbb7f0f-f08a-4023-8fee-3314d41a8818");
		// sc.delete("c6af8a57-f3cb-4d4e-8d6c-bff0a3f1b61f");

		// sc.queryfuzzy("a");
		// sc.plancount();
		sc.paged();
		// System.out.println( H3rdProperties.getProperty("MMS_PRICE"));
	}

	@After
	public void after() {
		System.out.println("完成之后再做一些事情");
	}
}
