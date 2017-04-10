package com.taiyear.dsp.marketing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taiyear.dsp.marketing.entity.SpecialList;
import com.taiyear.dsp.marketing.repoDao.SpecialListRepository;
import com.taiyear.dsp.marketing.service.SpecialListService;
@Service("specialListService")
public class SpecialListServiceImpl implements SpecialListService{
	@Autowired
	SpecialListRepository specialListRepository;
	
	@Override
	public SpecialList findById(String id){
		return specialListRepository.findById(id);
	}

	@Override
	public SpecialList findByMobile(String mobile) {
		return specialListRepository.findByMobile(mobile);
	}

	@Override
	public SpecialList save(SpecialList specialList) {
		
		//查询电话号码是否存在
		SpecialList oldSpecialList = this.findByMobile(specialList.getMobile());
		
		if(oldSpecialList != null){
			return specialListRepository.save(specialList);
		}
		return null;
	}

}
