package com.taiyear.dsp.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class RemoteSendMessage {
	public static final String USERID = "184";
	public static final String ACCOUNT = "taiyetg";
	public static final String PAASSWORD = "888888";
	
	public RemoteSendMessage(){
		
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
