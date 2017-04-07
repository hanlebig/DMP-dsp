/**
 * 
 */
package com.taiyear.dsp.simple.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taiyear.dsp.simple.entity.PageBean;
import com.taiyear.dsp.simple.entity.Plan;
import com.taiyear.dsp.simple.entity.SendMarketingTest;
import com.taiyear.dsp.simple.service.SimpleService;

/**
 * @author liul
 * 
 */
@Controller
@RequestMapping("/simple")
@Api(value = "测试类", tags = "测试接口")
public class SimpleController {

	@Autowired
	SimpleService simpleService;

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	@ApiOperation("测试controller")
	public @ResponseBody
	void index(
			@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
		Plan plan = new Plan();
		plan.setPlanName("aaa");
		simpleService.savePlan(plan);
	}

	@ApiOperation("测试1controller")
	public @ResponseBody
	Plan index1(
			@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
		SendMarketingTest sendmarketing = new SendMarketingTest();

		sendmarketing.setPlanId("1");

		return simpleService.queryPlan(sendmarketing.getPlanId());
	}

	@ApiOperation("测试1controller")
	public @ResponseBody
	double index2(
			@ApiParam(name = "id", value = "id", required = true) @RequestParam String id) {
		SendMarketingTest sendmarketing = new SendMarketingTest();

		sendmarketing.setPlanId("1");

		return simpleService.queryConsume(sendmarketing.getPlanId());
	}

	@ApiOperation("测试1controller")
	public @ResponseBody
	boolean index3(
			@ApiParam(name = "id", value = "id", required = true) @RequestParam String planId) {

		return simpleService.updatePlan(planId);
	}

	@ApiOperation("测试1controller")
	public @ResponseBody
	boolean index4(String putStatus, String planId) {

		return simpleService.updatePutStatus(putStatus, planId);
	}

	@ApiOperation("测试1controller")
	public @ResponseBody
	void delete(String planId) {

		simpleService.deletePlan(planId);
	}

	@ApiOperation("测试1controller")
	public @ResponseBody
	List<Plan> queryfuzzy(String keyWord) {

		return simpleService.queryFuzzy(keyWord);
	}

	@ApiOperation("测试1controller")
	public @ResponseBody
	int plancount() {

		return simpleService.queryPlanNum();

	}

	@ApiOperation("测试1controller")
	public @ResponseBody
	List<Plan> paged() {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(2);
		return simpleService.paged(pageBean);

	}

}
