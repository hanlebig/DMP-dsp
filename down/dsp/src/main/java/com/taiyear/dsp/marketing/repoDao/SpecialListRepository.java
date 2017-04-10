package com.taiyear.dsp.marketing.repoDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taiyear.dsp.marketing.entity.SpecialList;

@Repository
public interface SpecialListRepository extends JpaRepository<SpecialList, String> {
	
	SpecialList findById(String id);
	
	SpecialList findByMobile(String mobile);

}
