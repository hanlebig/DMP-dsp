package com.taiyear.dsp.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class H3rdProperties {
	private static Properties properties;
	static {
		try {
			loadProperties(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void loadProperties(boolean force) throws IOException {
		if (force || properties == null) {
			properties = new Properties();
			InputStream fis = H3rdProperties.class.getClassLoader()
					.getResourceAsStream("3rd.properties");
			properties.load(fis);
		}

	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}
}
