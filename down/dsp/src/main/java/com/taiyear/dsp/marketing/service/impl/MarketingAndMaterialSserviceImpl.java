package com.taiyear.dsp.marketing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taiyear.dsp.marketing.entity.MarketingAndMaterial;
import com.taiyear.dsp.marketing.repoDao.MarketingAndMaterialRepository;
import com.taiyear.dsp.marketing.service.MarketingAndMaterialSservice;
@Service("marketingAndMaterialSservice")
public class MarketingAndMaterialSserviceImpl implements MarketingAndMaterialSservice{
	
	@Autowired
	MarketingAndMaterialRepository marketingAndMaterialRepository;
	
	@Override
	public MarketingAndMaterial save(MarketingAndMaterial andMaterial) {
		return marketingAndMaterialRepository.save(andMaterial);
	}

}
