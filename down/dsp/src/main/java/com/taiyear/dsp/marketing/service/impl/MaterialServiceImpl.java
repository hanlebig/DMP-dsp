package com.taiyear.dsp.marketing.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taiyear.dsp.marketing.entity.Material;
import com.taiyear.dsp.marketing.entity.thread.ResultJson;
import com.taiyear.dsp.marketing.repoDao.MaterialRepository;
import com.taiyear.dsp.marketing.service.MaterialService;

@Service("materialService")
public class MaterialServiceImpl implements MaterialService {
	
	@Autowired
	MaterialRepository materialRepository; 
	
	@Override
	public ResultJson insertMaterial(Material material) {
		ResultJson res = new ResultJson();
		res.setSuccess(false);
		if(null == material.getAuditStatus() || "".equals(material.getAuditStatus())){
			res.setMsg("审核状态不能为空!");
			return res;
		}
		if(null == material.getImgPath() || "".equals(material.getImgPath())){
			res.setMsg("图片路径不能为空,请填写图片路径!");
			return res;
		}
		File file = new File(material.getImgPath());
		if(!file.exists()){
			res.setMsg("该图片不存在,请重新填写图片路径!");
			return res;
		}
		material.setCreateTime(new Date());
		material.setUpdateTime(new Date());
		materialRepository.save(material);
		res.setSuccess(true);
		res.setMsg("素材上传成功");
		return res;
	}

	@Override
	public List<Material> findMaterialByAuditSuccess(String auditStatus) {
		List<Material> materials = materialRepository.findMaterialByAuditSuccess(auditStatus);
		return materials;
	}

}
