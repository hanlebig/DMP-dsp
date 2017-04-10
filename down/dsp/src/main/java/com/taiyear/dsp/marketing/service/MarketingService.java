package com.taiyear.dsp.marketing.service;

import com.taiyear.dsp.marketing.entity.Marketing;
import com.taiyear.dsp.marketing.entity.thread.ResultJson;

public interface MarketingService {
	
	public ResultJson saveSMS(Marketing marketing);

	public ResultJson saveSMMS(Marketing marketing);
	
	public ResultJson findAll(int pageNo,int pageSize);
}
