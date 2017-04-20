package com.taiyear.dsp.marketing.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.taiyear.dsp.base.BaseController;
import com.taiyear.dsp.marketing.entity.Marketing;
import com.taiyear.dsp.marketing.entity.Material;
import com.taiyear.dsp.marketing.entity.thread.ResultJson;
import com.taiyear.dsp.marketing.service.MarketingService;
import com.taiyear.dsp.marketing.service.MaterialService;

/**
 * 上传广告相关的Controller
 * @author hanle
 * @Time：2017年4月6日 上午9:46:44
 * @version 1.0
 */


@RestController
@RequestMapping("/market")
@Api(value = "发送短信(彩信)", tags = "发送短信或者彩信")
public class MarketController extends BaseController{
	
	@Autowired
	private MarketingService marketingService;
	
//	@Autowired
//	private SpecialListService specialListService;
	@Autowired
	MaterialService materialService;
	
	@RequestMapping("MessageList")
	public ResultJson MessageList(int pageNo,int pageSize){
		return marketingService.findAll(pageNo, pageSize);
	} 
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ApiOperation("转发测试页面")
	public ModelAndView index(){
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/sendSMS",method = RequestMethod.POST)
	@ApiOperation("发送短信")
	public ResultJson sendSMS(@RequestBody Marketing marketing){
		System.out.println("------------");
		return marketingService.saveSMS(marketing);
	}
	@RequestMapping(value="/sendMMS", method = RequestMethod.POST)
	@ApiOperation("发送彩信")
	public ResultJson sendMMs(@RequestBody  Marketing marketing){
		return marketingService.saveSMMS(marketing);
	}
	
	@RequestMapping(value="deleteImageFile",method = RequestMethod.GET)
	@ApiOperation("删除文件")
	public ResultJson deleteImageFile(@RequestParam("imageFile")String imageFile){
		ResultJson res = new ResultJson();
		File file = new File(imageFile);
		if(file.exists()){
			file.delete();
			res.setSuccess(true);
			res.setMsg("图片删除成功!");
		}else{
			res.setSuccess(false);
			res.setMsg("当前图片不存在!");
		}
		return res;
	}
	
	@RequestMapping(value = "/handleImageUpload",method = RequestMethod.GET)
	@ApiOperation("上传图片")
	public ResultJson handleImageUpload(@RequestParam("imageFile")MultipartFile imageFile,HttpServletRequest request){
		ResultJson res = super.upload(1024 * 45, imageFile, request);
		//上传图片
		if(res.isSuccess()){
			Material material = new Material();
			material.setImgPath(res.getObj().toString());
			material.setAuditStatus(Material.AUDIT_SATAUS_WAIT_SUCCESS);
			material.setImgSize(String.valueOf(imageFile.getSize()));
			res = materialService.insertMaterial(material);
		}
		return res;
	}
	
	
	@RequestMapping(value = "/handleExcelUpload", method = RequestMethod.GET)
	@ApiOperation("上传excel")
	public ResultJson handleExcelUpload(@RequestParam("file")MultipartFile file){
		ResultJson res = new ResultJson();
		try{
			if(null != file){
				XSSFWorkbook xss = new XSSFWorkbook(file.getInputStream());
				XSSFSheet xssfSheet =  xss.getSheetAt(0); 
				int len = xssfSheet.getLastRowNum(); 
				List<String> mobiles = new ArrayList<String>();
				for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
	                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
	                int intCell= xssfRow.getLastCellNum(); 
	                if( 2 == intCell){
		            	if (xssfRow != null) {
		            		for (int i = 0; i < intCell; i++) {
		                		switch (i) {
									case 0:
										break;
									case 1:
										if(null != xssfRow.getCell(i).getRawValue() && xssfRow.getCell(i).getRawValue().matches("^\\d{11}$")){
											mobiles.add(xssfRow.getCell(i).getRawValue());
										}
									default:
										break;
								}
		                	} 
		                }
	                }
	            }
				res.setSuccess(true);
				res.setMsg("电话列表上传成功!");
				res.setObj(mobiles);
			}else{
				res.setSuccess(false);
				res.setMsg("您上传的excel不存在,请您重新上传!");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;	
	}
	
	
	@RequestMapping(value = "/updateMarketingStatus",method = RequestMethod.POST)
	@ApiOperation("批量更新广告状态")
	public ResultJson updateMarketingStatus(@RequestParam("ids")String [] ids,@RequestParam("status")String status){
		return marketingService.updateMarketingStatus(ids,status);

	}
	
	@RequestMapping(value = "/deleteMarketing",method = RequestMethod.GET)
	@ApiOperation("批量删除广告状态")
	public ResultJson deleteMarketing(@RequestParam("ids")String [] ids){
		return marketingService.delete(ids);
	}
}
