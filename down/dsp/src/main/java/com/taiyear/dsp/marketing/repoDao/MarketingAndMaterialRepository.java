package com.taiyear.dsp.marketing.repoDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taiyear.dsp.marketing.entity.MarketingAndMaterial;

public interface MarketingAndMaterialRepository extends JpaRepository<MarketingAndMaterial, String> {

	List<MarketingAndMaterial> findByMarketingId(String marketingId);

}
