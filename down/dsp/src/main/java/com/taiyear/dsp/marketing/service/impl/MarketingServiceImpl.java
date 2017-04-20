package com.taiyear.dsp.marketing.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
		if(-1 != marketing.getMarketingContent().indexOf("http") ){
			res.setMsg("彩信中必须含有链接!");
			return res;
		}
		if(null == marketing.getMarketingSize() || "".equals(marketing.getMarketingSize())){
			res.setMsg("图片的大小不能为空!");
			return res;
		}
		
		
		//判断客户发送测试短信是否达到上限
		int count = sendMarketrepository.findSendMarketByCompanyId(marketing.getCompanyId());
		String [] testMobiles = marketing.getSendAddress().split(",");
		if(count+testMobiles.length>50){
			res.setMsg("您发送的测试短信超过50条");
			return res;
		}
		
		int fileSizeSum = 0;
		//短信
		for(String fileSize : marketing.getMarketingSize().split(",")){
			fileSizeSum += Integer.parseInt(fileSize);
		}
		fileSizeSum = fileSizeSum * 1000;
		fileSizeSum += marketing.getMarketingContent().length();
		if(fileSizeSum > 1024*300){
			res.setMsg("彩信的数据不能大于300k");
			return res;
		}
		marketing.setMarketingType("4");
		marketing.setCreateTime(new Date());
		marketing.setUpdateTime(new Date());
//		marketing.getMarketingContent()
		String contents [] = marketing.getMarketingContent().split(",");
		String filePaths [] = marketing.getFilePath().split(",");
		String contentSum = "";
		
		//存储编译号码
		Marketing market = marketingRepository.save(marketing);
		String [] mobiles = marketing.getSendAddress().split(",");
		
		for (String mobile : mobiles) {
			//拼接短信内容
			for (int i = 0; i < contents.length; i++) {
				String suffix = filePaths[i].substring(filePaths[i].lastIndexOf(".") + 1);
				try {
					File file = new File(filePaths[i]);
					FileInputStream in = new FileInputStream(file);
					byte b [] = new byte[in.available()];
					in.read(b);
					in.close();
					String content =contents[i];
					String url = content.substring(content.indexOf("http"), content.length());
					String shortUrl = RemoteSendMessage.generateShortUrlSo(url + "?marketingId=" + market.getId() + "&companyId=" + marketing.getCompanyId());
					content	= content.replace(url, shortUrl);
					String contentStr = "3,txt" + "|" + new BASE64Encoder().encode((content.getBytes("GBK")));
					String fileP = suffix + "|" + new BASE64Encoder().encode(b);
					//拼彩信
					contentSum += contentStr +"," +fileP + ";";
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			String str =	RemoteSendMessage.sendMms(marketing.getMarketingName(),mobile, contentSum);
			String strs [] = str.split(":");
			// 存储当前手机号
			SendMarketing sendMarket = new SendMarketing();
			sendMarket.setMarketingId(market.getId());
			sendMarket.setMobile(mobile);
			sendMarket.setSendCount(mobiles.length);
			sendMarket.setSendTime(new Date());
			sendMarket.setSendType("4");
			if(strs.length == 2){
				sendMarket.setTaskId(strs[1]);
				res.setMsg("发送成功!");
				res.setSuccess(true);
			}else if(str.equals("6")){
				sendMarket.setTaskId(str);
				res.setMsg("您的账户余额不足");
				res.setSuccess(false);
			}else{
				sendMarket.setTaskId(str);
				res.setMsg("系统出现错误,请联系管理员!");
				res.setSuccess(false);
			}
			sendMarketrepository.save(sendMarket);
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
		if(-1 != marketing.getMarketingContent().indexOf("http") ){
			res.setMsg("短信中必须含有链接!");
			return res;
		}
		
		//判断客户发送测试短信是否达到上限
		int count = sendMarketrepository.findSendMarketByCompanyId(marketing.getCompanyId());
		String [] testMobiles = marketing.getSendAddress().split(",");
		if(count+testMobiles.length>50){
			res.setMsg("您发送的测试短信超过50条");
			return res;
		}
		
		marketing.setMarketingType("3");
		marketing.setCreateTime(new Date());
		marketing.setUpdateTime(new Date());
		Marketing market = marketingRepository.save(marketing);
		
		String [] mobiles = marketing.getSendAddress().split(",");
		
		
		for (String mobile : mobiles) {
			//长链接转短链接
			String content = marketing.getMarketingContent();
			String url = content.substring(content.indexOf("http"), content.length());
			String shortUrl = RemoteSendMessage.generateShortUrlSo(url + "?marketingId=" + market.getId() + "&companyId=" + marketing.getCompanyId());
			content	= content.replace(url, shortUrl);
			//发送短信
			int i = 0;
			String send_content = "";
			String result = "";
			while (i < content.length()/70) {
				if(i == content.length()/70){
					send_content = content.substring(i*3,content.length());
				}else{
					send_content = content.substring(i*3, (i+1)*3);
				}
				result = RemoteSendMessage.sendMessage(mobile, send_content);
				i ++ ;
			}
			Map<String, String> data = RemoteReceiverMessage.parseXml(result);
			if(data.get("returnstatus".toUpperCase()).equals("Success")){
			//存储编译号码
			// 存储当前手机号
				SendMarketing sendMarket = new SendMarketing();
				sendMarket.setMarketingId(market.getId());
				sendMarket.setMobile(mobile);
				sendMarket.setSendCount(mobiles.length);
				sendMarket.setSendTime(new Date());
				sendMarket.setSendType("3");
				sendMarket.setTaskId(data.get("taskID".toUpperCase()));
				sendMarketrepository.save(sendMarket);
				res.setSuccess(true);
				if(content.length() / 70 > 1){
					res.setObj("当前短信超出了70个字的范畴,被切割成了" + content.length() / 70+ "条短信发出!");
				}
				res.setMsg("发送成功!");
			}else{
				res.setMsg(data.get("message".toUpperCase()));
				res.setSuccess(false);
			}
		}
		return res;	
	}
	@Override
	public ResultJson findAll(int pageNo,int pageSize) {
		ResultJson res = new ResultJson();
		Page<Marketing> pages = marketingRepository.findAll(new PageRequest(pageNo,pageSize));
		if(pages.getSize() > 0){
			res.setSuccess(true);	
			res.setMsg("查询成功");
			res.setObj(pages);
		}else{
			res.setSuccess(false);
			res.setMsg("当前没有数据,请添加数据!");
		}
		return res;
	}

	@Override
	public ResultJson updateMarketingStatus(String[] ids, String status) {
		
		ResultJson res = new ResultJson();
		for(String id : ids){
			Marketing marketing = marketingRepository.findOne(id);
			marketing.setMarketingStatus(status);
			marketingRepository.save(marketing);
		}
	
		res.setMsg("批量修改成功");
		return res;
	}

	@Override
	public ResultJson delete(String[] ids) {
		ResultJson res = new ResultJson();
		for(String id : ids){
			marketingRepository.delete(id);
		}
		res.setMsg("批量删除成功");
		return res;
	}

}


