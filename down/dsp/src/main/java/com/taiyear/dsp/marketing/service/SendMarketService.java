package com.taiyear.dsp.marketing.service;

import com.taiyear.dsp.marketing.entity.thread.ResultJson;

public interface SendMarketService {
	public ResultJson sendSMS(String mobiles,String marketingId);
	ResultJson sendSMMS(String mobiles, String marketingId)throws Exception;
}
