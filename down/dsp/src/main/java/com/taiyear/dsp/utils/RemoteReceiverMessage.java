package com.taiyear.dsp.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class RemoteReceiverMessage {
	//解析xml
	public static Map<String, String> parseXml(String results){
		System.out.println(results);
		Map<String, String> data = new HashMap<String, String>();
		Document doc = null;
		 try {
//			 Document doc = reader.read("E:\\ziliao\\dsp\\src\\main\\resources\\22.xml");
			 doc = DocumentHelper.parseText(results);
			 Element element = doc.getRootElement();
			 List<Element> elements = element.elements();
			 for (Element obj : elements) {
				 data.put(obj.getName().toString().trim().toUpperCase(),obj.getData().toString().trim());
			 }
		 } catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	} 
	
	
}
