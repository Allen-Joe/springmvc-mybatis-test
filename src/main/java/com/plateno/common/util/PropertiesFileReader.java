package com.plateno.common.util;

import java.io.IOException;
import java.util.Properties;

/**
 * 负责应用程序属性文件app.properties的读取。
 * */
public class PropertiesFileReader {
	
	private static final String PROPERTY_FILE = "/app.properties";

	private PropertiesFileReader() {
	}

	private static Properties properties = new Properties();

	public static String get(String key, String propertyFile) {
		if (key == null)
			return null;
		try {
			properties.load(PropertiesFileReader.class
					.getResourceAsStream(propertyFile));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.print("加载属性文件错误");
		}
		return properties.getProperty(key);
	}
	
	public static String getByKey(String key) {
		if (key == null)
			return null;
		try {
			properties.load(PropertiesFileReader.class
					.getResourceAsStream(PROPERTY_FILE));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.print("加载属性文件错误");
		}
		return properties.getProperty(key);
	}
	
	public static void main(String[] args) {
		System.out.println(PropertiesFileReader.getByKey("xingeApp.ios.accessId"));
	}
}
