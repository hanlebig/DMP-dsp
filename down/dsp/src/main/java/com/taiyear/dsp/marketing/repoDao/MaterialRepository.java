package com.taiyear.dsp.marketing.repoDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.taiyear.dsp.marketing.entity.Material;

public interface MaterialRepository  extends JpaRepository<Material, String>{
	
	@Query("from Material ma where ma.auditStatus=?")
	List<Material> findMaterialByAuditSuccess(String auditSatausSuccess);
	
}
