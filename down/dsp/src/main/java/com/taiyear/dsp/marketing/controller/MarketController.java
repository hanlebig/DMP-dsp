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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.yaml.snakeyaml.constructor.BaseConstructor;

import com.taiyear.dsp.base.AbstractEntity;
import com.taiyear.dsp.base.BaseController;
import com.taiyear.dsp.marketing.entity.Marketing;
import com.taiyear.dsp.marketing.entity.SpecialList;
import com.taiyear.dsp.marketing.entity.thread.ResultJson;
import com.taiyear.dsp.marketing.service.MarketingService;
import com.taiyear.dsp.marketing.service.SpecialListService;

/**
 * @author hanle
 * @Time：2017年4月6日 上午9:46:44
 * @version 1.0
 */


@RestController
@RequestMapping("/market")
@Api(value = "发送短信(彩信)", tags = "发送短信或者彩信")
public class MarketController extends BaseController{
	
	@Autowired
	MarketingService marketingService;
	
	@Autowired
	SpecialListService specialListService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ApiOperation("转发测试页面")
	public ModelAndView index(){
		return new ModelAndView("index");
	}
	
	@RequestMapping("/sendSMS")
	@ApiOperation("发送短信")
	public ResultJson sendSMS(@RequestParam("marketing")Marketing marketing){
		return marketingService.saveSMS(marketing);
	}
	@RequestMapping("/sendMMS")
	@ApiOperation("发送彩信")
	public ResultJson sendMMs(@RequestParam("marketing")Marketing marketing){
		return marketingService.saveSMMS(marketing);
	}
	
	@RequestMapping("deleteImageFile")
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
	
	@RequestMapping("/handleImageUpload")
	@ApiOperation("上传图片")
	public ResultJson handleImageUpload(@RequestParam("imageFile")MultipartFile imageFile,HttpServletRequest request){
		ResultJson res = super.upload(1024 * 45, imageFile, request);
		//上传图片
		if(res.isSuccess()){
			Marketing marketing = new Marketing();
			marketing.setFilePath(res.getObj().toString());
			marketing.setMarketingSize(String.valueOf(imageFile.getSize()));
			res.setObj(marketing);
		}
		return res;
	}
	
	
	@RequestMapping("/handleExcelUpload")
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
}