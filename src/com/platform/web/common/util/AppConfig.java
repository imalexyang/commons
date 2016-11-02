/**
 * 
 */
package com.platform.web.common.util;

import java.util.ResourceBundle;


/**
 * 应用参数工具类，获得config配置文件中定义的参数
 * @author yubin
 *
 */
public class AppConfig {

	private static final String BUNDLE_NAME = "config/config";
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	
	private AppConfig() {
	}
	
	public static String getString(String key) {
		try {
			String messager = RESOURCE_BUNDLE.getString(key);
			return messager;
		} catch (Exception e) {
			String messager = "不能在配置文件" + BUNDLE_NAME + "中发现参数：" + '!' + key
					+ '!';
			throw new RuntimeException(messager);
		}
		
	}
}
