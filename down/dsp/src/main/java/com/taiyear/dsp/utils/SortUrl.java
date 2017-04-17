package com.taiyear.dsp.utils;

import java.net.IDN;
import java.security.NoSuchAlgorithmException;

import com.alibaba.fastjson.JSONObject;



/**
 * @author hanle
 * @Time：2017年4月17日 上午11:01:11
 * @version 1.0
 */
public class SortUrl {
	
	public static final PropertiesLoader prop = new PropertiesLoader("application.properties");

	public static final String SECRET_KEY;
	
	public static final String APP_ID;
	
	static{
		APP_ID = prop.getProperty("APP_ID");
		SECRET_KEY = prop.getProperty("SECRET_KEY");
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
//		System.out.println(getSignature("http://www.qq.com"));
	}
	public static String getSignature(String urlLong){
		JSONObject object=new JSONObject();
		object.put("app_id",APP_ID);  
		object.put("url_long",urlLong);  
		String str = object.toString();
		try {
			String md5 = MD5Util.MD5(sort(str)).toLowerCase();
			String signature = MD5Util.MD5(md5+SECRET_KEY).toLowerCase();
			return signature;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String sort(String str){
        //利用toCharArray可将字符串转换为char型的数组
		char[] s1 = str.toCharArray();
		for(int i=0;i<s1.length;i++){
			for(int j=0;j<i;j++){
				if(s1[i]<s1[j]){
					char temp = s1[i];
					s1[i] = s1[j];
					s1[j] = temp;
				}
			}
		}
		//再次将字符数组转换为字符串，也可以直接利用String.valueOf(s1)转换
		String st = new String(s1);
		return st;
    }
}
