package com.taiyear.dsp.marketing.repoDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.taiyear.dsp.marketing.entity.SendMarketing;

public interface SendMarketrepository extends JpaRepository<SendMarketing, String> {
	
	
	@Query(value="select count(*) from send_market sm inner join marketing mk on sm.marketing_id = mk.id where mk.company_id = 'companyid'",nativeQuery = true)
	int findSendMarketByCompanyId(String companyId);

}
