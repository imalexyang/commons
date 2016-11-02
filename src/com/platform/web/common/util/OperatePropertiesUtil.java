package com.platform.web.common.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 操作properties文件工具类
 * 
 * @author: yangzhi
 * @Email: zhi19861117@126.com
 * @version:2012-10-18 上午8:57:57 类说明
 */
public class OperatePropertiesUtil {
	// 根据key读取value
	public static String readValue(String filePath, String key) {
		Properties props = new Properties();
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(getFilePath(filePath)));
			props.load(in);
			String value = props.getProperty(key);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 读取properties的全部信息
	private static Map<String, String> map = null;

	@SuppressWarnings("rawtypes")
	public static Map<String, String> readProperties(String filePath) {
		if (null == map) {
			Properties props = new Properties();
			map = new HashMap<String, String>();
			InputStream in = null;
			try {
				in = new BufferedInputStream(new FileInputStream(getFilePath(filePath)));
				props.load(in);
				Enumeration en = props.propertyNames();
				while (en.hasMoreElements()) {
					String key = (String) en.nextElement();
					String Property = props.getProperty(key);
					map.put(key, Property);

				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}
			}
		}
		return map;
	}

	// 写入properties信息
	public static void writeProperties(String filePath, String parameterName, String parameterValue) throws Exception {
		Properties prop = new Properties();
		InputStream fis = null;
		try {
			fis = new FileInputStream(getFilePath(filePath));
			// 从输入流中读取属性列表（键和元素对）
			prop.load(fis);
			// 调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
			// 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
			OutputStream fos = new FileOutputStream(filePath);
			prop.setProperty(parameterName, parameterValue);
			// 以适合使用 load 方法加载到 Properties 表中的格式，
			// 将此 Properties 表中的属性列表（键和元素对）写入输出流
			prop.store(fos, "Update '" + parameterName + "' value");
		} catch (IOException e) {
			System.err.println("Visit " + filePath + " for updating " + parameterName + " value error");
		} finally {
			fis.close();
		}
	}

	public static String getFilePath(String _sResourceName) throws Exception {
		URL url = Thread.currentThread().getContextClassLoader().getResource(_sResourceName);
		if (url == null) {
			throw new Exception("资源文件[" + _sResourceName + "]没有找到！");
		}

		// 匹配绝对路径
		String sAbsolutePath = null;
		try {
			sAbsolutePath = url.getFile();
			if (sAbsolutePath.indexOf("%") >= 0) {
				String sEncoding = System.getProperty("file.encoding", "UTF-8");
				sAbsolutePath = URLEncoder.encode(sAbsolutePath, sEncoding);
			}
		} catch (Exception ex) {
			throw new Exception("转换文件[" + url.getFile() + "]的编码失败！", ex);
		}
		return sAbsolutePath;
	}

}
