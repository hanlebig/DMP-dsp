package com.taiyear.dsp.marketing.controller;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taiyear.dsp.marketing.entity.thread.ResultJson;
import com.taiyear.dsp.marketing.service.SendMarketService;

@RestController
@RequestMapping("sendMarket")
public class SendMarketController {
	@Autowired
	SendMarketService sendMarketService;
	
	@RequestMapping(value="/sendSMS",method = RequestMethod.POST)
	@ApiOperation("发送短信")
	public ResultJson sendSMS(String mobiles,String marketingId){
		return sendMarketService.sendSMS(mobiles, marketingId);
	}
	@RequestMapping(value="/sendMMS", method = RequestMethod.POST)
	@ApiOperation("发送彩信")
	public ResultJson sendMMs(String mobiles,String marketingId) throws Exception{
		return sendMarketService.sendSMMS(mobiles, marketingId);
	}
}
