package com.taiyear.dsp.marketing.service;

import java.util.List;

import com.taiyear.dsp.marketing.entity.Material;
import com.taiyear.dsp.marketing.entity.thread.ResultJson;

public interface MaterialService {

	ResultJson insertMaterial(Material material);

	List<Material> findMaterialByAuditSuccess(String auditStatus);

}
