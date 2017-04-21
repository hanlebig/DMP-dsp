package com.taiyear.dsp.marketing.repoDao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.taiyear.dsp.marketing.entity.Marketing;

public interface MarketingRepository extends JpaRepository<Marketing, String>{
	Page findAll(Pageable pageable);
}

