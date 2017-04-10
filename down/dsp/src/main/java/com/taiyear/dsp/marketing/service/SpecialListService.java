package com.taiyear.dsp.marketing.service;

import com.taiyear.dsp.marketing.entity.SpecialList;

public interface SpecialListService {
	
	public SpecialList findById(String id);
	
	public SpecialList findByMobile(String mobile);

	public SpecialList save(SpecialList specialList);
}
