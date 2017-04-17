package com.taiyear.dsp.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSON;


public class RemoteSendMessage {
	public static final String USERID = "184";
	public static final String ACCOUNT = "taiyetg";
	public static final String PAASSWORD = "888888";
	public static void main(String[] args) {
		Map<String, String> data = new HashMap<String, String>();
		String url = "http://blog.csdn.net/czp11210/article/details/47022639";
		data.put("url", url);
//		data.put("signature", "su2dn2nx3s2f4e12ewdcx4dx3xe3xsd3f");
		data.put("app_id", "100001");
		String d = JSON.toJSONString(data);
		List<String> list = new ArrayList<String>();
		for (int j = 0; j < d.length(); j++) {
			list.add(String.valueOf(d.charAt(j)));
		} 
//		System.out.println(Arrays.sort(list));	
		//		String url = RemoteSendMessage.generateShortUrlSo("http://blog.csdn.net/czp11210/article/details/47022639");
//		System.out.println(url);
	}
	public static String generateShortUrlSo(String url){
		Map<String, String> data = new HashMap<String, String>();
		data.put("url", url);
		data.put("signature", "su2dn2nx3s2f4e12ewdcx4dx3xe3xsd3f");
		data.put("app_id", "100001");
		try {
			return Jsoup.connect("http://bil.vc/shortUrl.php").data(data).post().text();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String sendMms(String title,String mobile,String content){
		Document doc = null;
		Map<String, String> data = new HashMap<String, String>();
		data.put("action", "send");
		data.put("userid", USERID);
		data.put("account", ACCOUNT);
		data.put("password", PAASSWORD);
		data.put("starttime","");
		data.put("content", content);
		data.put("mobile", mobile);
		data.put("title", title);
		try {
			doc = Jsoup.connect("http://101.201.54.221:8888/sendmms.aspx").ignoreContentType(false).data(data).post();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(doc.text());
		return doc.text();
	} 
	public static String sendMessage(String mobile,String content){
		Map<String, String> data = new HashMap<String, String>();
		data.put("action", "send");
		data.put("userid", USERID);
		data.put("account", ACCOUNT);
		data.put("password", PAASSWORD);
		data.put("mobile", mobile);
		data.put("content", content);
		data.put("sendTime", "");
		data.put("extno", "");
		Document document = null;
		try {
			document = Jsoup.connect("http://101.201.54.221:8888/sms.aspx").data(data).post();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document.html();
	};

}
