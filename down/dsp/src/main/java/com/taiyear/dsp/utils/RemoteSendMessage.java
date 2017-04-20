package com.taiyear.dsp.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.IDN;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class RemoteSendMessage {
	public static final String USERID = "184";
	public static final String ACCOUNT = "taiyetg";
	public static final String PAASSWORD = "888888";
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String url = "http://blog.csdn.net/czp11210/article/details/47022639";
		String url2 = RemoteSendMessage.generateShortUrlSo(url);
		JSONObject json = JSON.parseObject(url2);
		System.out.println(json.getString("message"));
	}
	
	public static String generateShortUrlSo(String url){
		Map<String, String> data = new HashMap<String, String>();
		data.put("url", url);
		data.put("signature",SortUrl.getSignature(url));
		data.put("app_id",SortUrl.APP_ID);
		try {
			return Jsoup.connect("http://bil.vc/shortUrl.php").data(data).get().text();
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
