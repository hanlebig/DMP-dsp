package com.taiyear.dsp.marketing.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sun.misc.BASE64Encoder;

import com.taiyear.dsp.marketing.entity.Marketing;
import com.taiyear.dsp.marketing.entity.MarketingAndMaterial;
import com.taiyear.dsp.marketing.entity.Material;
import com.taiyear.dsp.marketing.entity.SendMarketing;
import com.taiyear.dsp.marketing.entity.thread.ResultJson;
import com.taiyear.dsp.marketing.repoDao.MarketingAndMaterialRepository;
import com.taiyear.dsp.marketing.repoDao.MarketingRepository;
import com.taiyear.dsp.marketing.repoDao.MaterialRepository;
import com.taiyear.dsp.marketing.repoDao.SendMarketrepository;
import com.taiyear.dsp.marketing.service.SendMarketService;
import com.taiyear.dsp.utils.RemoteReceiverMessage;
import com.taiyear.dsp.utils.RemoteSendMessage;
@Service("sendMarketService")
public class SendMarketServiceImpl implements SendMarketService {
	@Autowired
	SendMarketrepository sendMarketrepository;
	@Autowired
	MarketingRepository marketingRepository;
	@Autowired
	MarketingAndMaterialRepository marketingAndMaterialRepository;
	@Autowired
	MaterialRepository materialRepository;
	@Override
	public ResultJson sendSMS(String mobiles, String marketingId) {
		ResultJson res = new ResultJson();
		res.setSuccess(false);
		if(null == marketingId || "".equals(marketingId)){
			res.setMsg("marketId不能为空,请填写marketId");
			return res;
		}
		if(null == mobiles || "".equals(mobiles)){
			res.setMsg("电话号码不能为空,请填写电话号码");
			return res;
		}
		String [] mobiless = mobiles.split(",");
		Marketing marketing = marketingRepository.findOne(marketingId);
		SendMarketing sendMarketing = new SendMarketing();
		sendMarketing.setSendCount(mobiless.length);
		sendMarketing.setSendTime(new Date());
		sendMarketing.setSendType("4");
		sendMarketing.setMarketingId(marketingId);
		if(null != marketing.getStrategyId()){
			sendMarketing.setStrategyId(marketing.getStrategyId());
		}
		if(null != marketing.getPlanId()){
			sendMarketing.setPlanId(marketing.getPlanId());
		}
		//发送短信
		int i = 0;
		String send_content = "";
		String content = marketing.getMarketingContent();
		List<String> results = new ArrayList<String>();
		while (i < content.length()/70) {
			if(i == content.length()/70){
				send_content = content.substring(i*3,content.length());
			}else{
				send_content = content.substring(i*3, (i+1)*3);
			}
			String result = RemoteSendMessage.sendMessage(mobiles, send_content);
			results.add(result);
			i ++ ;
		}
		List<ResultJson> ress = new ArrayList<ResultJson>();
		for (String result : results) {
			ResultJson resF = new ResultJson();
			Map<String, String> data = RemoteReceiverMessage.parseXml(result);
			if(data.get("returnstatus".toUpperCase()).equals("Success")){
				sendMarketing.setTaskId(data.get("taskID".toUpperCase()));
				res.setSuccess(true);
				if(content.length() / 70 > 1){
					resF.setObj("当前短信超出了70个字的范畴,被切割成了" + content.length() / 70+ "条短信发出!");
				}
				sendMarketing.setSendStatus("1");
				resF.setMsg("发送成功!");
			}else{
				sendMarketing.setSendStatus("0");
				resF.setMsg(data.get("message".toUpperCase()));
				resF.setSuccess(false);
			}
			sendMarketrepository.save(sendMarketing);
			ress.add(resF);
		}
		res.setObj(ress);
		res.setSuccess(true);
		res.setMsg("短信发送成功!");
		return res;
	}

	@Override
	public ResultJson sendSMMS(String mobiles, String marketingId) throws Exception {
		ResultJson res = new ResultJson();
		res.setSuccess(false);
		if(null == mobiles || "".equals(mobiles)){
			res.setMsg("电话号码不能为空,请填写电话号码");
			return res;
		}
		Marketing marketing = marketingRepository.findOne(marketingId);
		SendMarketing sendMarketing = new SendMarketing();
		String [] mobiless = mobiles.split(",");
		sendMarketing.setSendCount(mobiless.length);
		sendMarketing.setSendTime(new Date());
		sendMarketing.setSendType("4");
		sendMarketing.setMarketingId(marketingId);	
		if(null != marketing.getStrategyId()){
			sendMarketing.setStrategyId(marketing.getStrategyId());
		}
		if(null != marketing.getPlanId()){
			sendMarketing.setPlanId(marketing.getPlanId());
		}
		String [] contents = marketing.getMarketingContent().split(",");
		String contentSum = "";
		List<MarketingAndMaterial> andMaterials = marketingAndMaterialRepository.findByMarketingId(marketingId);
		for (int i = 0; i < andMaterials.size(); i++) {
			Material material = materialRepository.findOne(andMaterials.get(i).getMaterialId());
			File file = new File(material.getImgPath());
			String suffix = material.getImgPath().substring(material.getImgPath().lastIndexOf(".") + 1);
			FileInputStream in = new FileInputStream(file);
			byte b [] = new byte[in.available()];
			in.read(b);
			in.close();
			String contentStr = "3,txt" + "|" + new BASE64Encoder().encode((contents[i].getBytes("GBK")));
			String fileP = suffix + "|" + new BASE64Encoder().encode(b);
			contentSum += contentStr +"," +fileP + ";";
		}
		String str =	RemoteSendMessage.sendMms(marketing.getMarketingName(),mobiles, contentSum);
		String strs [] = str.split(":");
		if(strs.length == 2){
			sendMarketing.setSendStatus("1"); 
			sendMarketing.setTaskId(strs[1]);
			res.setMsg("发送成功!");
			res.setSuccess(true);
		}else if(str.equals("6")){
			sendMarketing.setSendStatus("0"); 
			sendMarketing.setTaskId(str);
			res.setMsg("您的账户余额不足");
			res.setSuccess(false);
		}else{
			sendMarketing.setSendStatus("0"); 
			sendMarketing.setTaskId(str);
			res.setMsg("系统出现错误,请联系管理员!");
			res.setSuccess(false);
		}
		sendMarketrepository.save(sendMarketing);
		return res;
	}
}
