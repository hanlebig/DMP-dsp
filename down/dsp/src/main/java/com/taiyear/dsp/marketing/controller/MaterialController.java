package com.taiyear.dsp.marketing.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taiyear.dsp.marketing.entity.Material;
import com.taiyear.dsp.marketing.entity.thread.ResultJson;
import com.taiyear.dsp.marketing.service.MaterialService;

@RestController
@RequestMapping("/material")
@Api(value = "素材库", tags = "素材的存储,审核")
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
	@RequestMapping(value= "saveMaterial",method= RequestMethod.POST)
	@ApiOperation("保存一个素材")
	public ResultJson saveMaterial(@RequestBody Material material){
		return materialService.insertMaterial(material);
	}
	@RequestMapping(value= "findMaterialByAuditSuccess",method= RequestMethod.POST)
	@ApiOperation("查询上传成功的素材")
	public List<Material> findMaterialByAuditSuccess(){
		return materialService.findMaterialByAuditSuccess(Material.AUDIT_SATAUS_SUCCESS);
	}
	
}
