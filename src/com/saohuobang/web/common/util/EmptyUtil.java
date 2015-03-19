package com.saohuobang.web.common.util;

import java.util.Collection;
import java.util.Map;
/**
 * 判断对象是否为空的工具类
 * @author mjx
 *
 */

@SuppressWarnings("unchecked")
public class EmptyUtil {
	public static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;
		if (obj instanceof Collection)
			return ((Collection) obj).size() == 0;
		if (obj instanceof Map)
			return ((Map) obj).size() == 0;
		if (obj instanceof Object[])
			return ((Object[]) obj).length == 0;
		return obj.toString().trim().length() == 0;
	}
	
}
