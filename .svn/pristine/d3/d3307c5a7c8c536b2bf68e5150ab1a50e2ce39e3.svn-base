package com.saohuobang.web.common.util;

import java.util.regex.Pattern;

/**
 * 字符串处理工具类
 * @author mjx
 *
 */
public final class StringUtil {
	/**
	 * 去除包名，传入com.abc.aaa返回aaa
	 * 
	 * @param str
	 *            类完整路径
	 * @return 类名
	 */
	public static String removePackageName(String str) {
		if (EmptyUtil.isEmpty(str)) {
			return "";
		} else if (str.indexOf(".") == -1) {
			return str;
		} else {
			return str.substring(str.lastIndexOf(".") + 1, str.length());
		}
	}

	
	/**
	 * 判断字符串是否是数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){ 
		Pattern pattern = Pattern.compile("[0-9]*"); 
		return pattern.matcher(str).matches(); 
	} 
	
	/**
	 * 字符串空转""
	 * @param str
	 * @return
	 */
	public static String null2String(String str){
		if(str == null){
			str = "";
		}
		return str;
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getContextClassLoader().getResource("").toString());
	}
}
