package com.taiyear.dsp.marketing.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sun.misc.BASE64Encoder;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.taiyear.dsp.marketing.entity.Marketing;
import com.taiyear.dsp.marketing.entity.SendMarketing;
import com.taiyear.dsp.marketing.entity.thread.ResultJson;
import com.taiyear.dsp.marketing.repoDao.MarketingRepository;
import com.taiyear.dsp.marketing.repoDao.SendMarketrepository;
import com.taiyear.dsp.marketing.service.MarketingService;
import com.taiyear.dsp.utils.RemoteReceiverMessage;
import com.taiyear.dsp.utils.RemoteSendMessage;
@Service
public class MarketingServiceImpl implements MarketingService{
	@Autowired
	MarketingRepository marketingRepository;
	@Autowired
	SendMarketrepository sendMarketrepository;
	
	@Override
	public ResultJson saveSMMS(Marketing marketing) {
		ResultJson res = new ResultJson();
		res.setSuccess(false);
		if(null == marketing.getMarketingName() || "".equals(marketing.getMarketingName())){
			res.setMsg("营销名字不能为空!");
			return res;	
		}
		if(null == marketing.getFilePath() || "".equals(marketing.getFilePath())){
			res.setMsg("要发送的图片不能为空!");
			return res;	
		}
		if(null == marketing.getMarketingSize() || "".equals(marketing.getMarketingSize())){
			res.setMsg("图片的大小不能为空!");
			return res;	
		}
		if(marketing.getMarketingName().length() > 14){
			res.setMsg("主题名称必须小于14个汉字!");
			return res;	
		}
		if(null == marketing.getSendAddress() || "".equals(marketing.getSendAddress())){
			res.setMsg("发送的地址不能为空!");
			return res;	
		}
		if(null == marketing.getMarketingContent() || "".equals(marketing.getMarketingContent())){
			res.setMsg("营销内容不能为空!");
			return res;	
		}
		String contents [] = marketing.getMarketingContent().split(",");
		String filePaths [] = marketing.getFilePath().split(",");
		
		String contentSum = "";
		//拼接短信内容
		for (int i = 0; i < contents.length; i++) {
			if(contents[i].length() > 70){
				res.setMsg("短信内容在70个汉字以内!");
				return res;	
			}
			String suffix = filePaths[i].substring(filePaths[i].lastIndexOf(".") + 1);
			try {
				File file = new File(filePaths[i]);
				FileInputStream in = new FileInputStream(file);
				byte b [] = new byte[in.available()];
				in.read(b);
				in.close();
				
				String contentStr = "3,txt" + "|" + new BASE64Encoder().encode((contents[i].getBytes("GBK")));
				String fileP = suffix + "|" + new BASE64Encoder().encode(b);
				//拼彩信
				contentSum += ( contentStr +"," +fileP + ";");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		marketing.setMarketingType("4");
		marketing.setCreateTime(new Date());
		marketing.setUpdateTime(new Date());
		String str =	RemoteSendMessage.sendMms(marketing.getMarketingName(), marketing.getSendAddress(), contentSum);
		String strs [] = str.split(":");
		//存储编译号码
		Marketing market = marketingRepository.save(marketing);
		// 存储当前手机号
		String [] mobiles = market.getSendAddress().split(",");
		if(strs.length == 2){
			for (String mobile : mobiles) {
				SendMarketing sendMarket = new SendMarketing();
				sendMarket.setMarketingId(market.getId());
				sendMarket.setMobile(mobile);
				sendMarket.setSendCount(mobiles.length);
				sendMarket.setSendTime(new Date());
				sendMarket.setSendType("4");
				sendMarket.setTaskId(strs[1]);
				sendMarketrepository.save(sendMarket);
			}
			res.setMsg("发送成功!");
			res.setSuccess(true);
		}else if(str.equals("6")){
			res.setMsg("您的账户余额不足");
			res.setSuccess(false);
		}else{
			res.setMsg("系统出现错误,请联系管理员!");
			res.setSuccess(false);
		}
		return res;	
	}
	
	@Override
	public ResultJson saveSMS(Marketing marketing) {
		ResultJson res = new ResultJson();
		res.setSuccess(false);
		if(null == marketing.getMarketingName() || "".equals(marketing.getMarketingName())){
			res.setMsg("营销名字不能为空!");
			return res;	
		}
		if(marketing.getMarketingName().length() > 14){
			res.setMsg("主题名称必须小于14个汉字!");
			return res;	
		}
		if(null == marketing.getSendAddress() || "".equals(marketing.getSendAddress())){
			res.setMsg("发送的地址不能为空!");
			return res;	
		}
		if(null == marketing.getMarketingContent() || "".equals(marketing.getMarketingContent())){
			res.setMsg("营销内容不能为空!");
			return res;	
		}
		if(marketing.getMarketingContent().length() > 70){
			res.setMsg("短信内容在70个汉字以内!");
			return res;	
		}
		//短信
		marketing.setMarketingType("3");
		marketing.setCreateTime(new Date());
		marketing.setUpdateTime(new Date());
		String result = RemoteSendMessage.sendMessage(marketing.getSendAddress(), marketing.getMarketingContent());
		Map<String, String> data = RemoteReceiverMessage.parseXml(result);
		if(data.get("returnstatus".toUpperCase()).equals("Success")){
			//存储编译号码
			Marketing market = marketingRepository.save(marketing);
			// 存储当前手机号
			String [] mobiles = market.getSendAddress().split(",");
			for (String mobile : mobiles) {
				SendMarketing sendMarket = new SendMarketing();
				sendMarket.setMarketingId(market.getId());
				sendMarket.setMobile(mobile);
				sendMarket.setSendCount(mobiles.length);
				sendMarket.setSendTime(new Date());
				sendMarket.setSendType("3");
				sendMarket.setTaskId(data.get("taskID".toUpperCase()));
				sendMarketrepository.save(sendMarket);
			}
			res.setSuccess(true);
			res.setMsg("发送成功!");
		}else{
			res.setMsg(data.get("message".toUpperCase()));
			res.setSuccess(false);
		}
		return res;	
	}
}
