/**
 * 
 */
package com.platform.web.common.util;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @author yubin
 *
 */
public class SignUtil {

	
	/**
	 * 获取32位随机字符串
	 * @return
	 */
	public static String random32Bit() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		return uuid;
	}
	
	/**
	 * 验证签名
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String signature, String timestamp, String nonce) {
		String[] arr = new String[] {AppConfig.getString("wx.msg.token"), timestamp, nonce };
		// 将token、timestamp、nonce三个参数进行字典排序
		Arrays.sort(arr);
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}
		MessageDigest md = null;
		String tmpStr = null;

		try {
			md = MessageDigest.getInstance("SHA-1");
			// 将三个参数字符串拼接成一个字符串进行sha1加密
			byte[] digest = md.digest(content.toString().getBytes());
			tmpStr = byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		content = null;
		// 将sha1加密后的字符串可与signature对比
		return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
	}
	
	/**
	 * 将字节数组转换为十六进制字符串
	 * 
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}
	
	/**
	 * 将字节转换为十六进制字符串
	 * 
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];

		String s = new String(tempArr);
		return s;
	}
	/**
	 * 将Map内数据进行排序，并转换为字符串(lijun)
	 * @param paraMap
	 * @param urlencode
	 * @return key=value&key=value形式
	 */
	public static String formatBizQueryParaMapQuery(SortedMap<String, Object> paraMap, boolean urlencode) {
		StringBuffer buff = new StringBuffer();
		try {
			//将Map转换为Set集合
			Set<Entry<String, Object>> keyset = paraMap.entrySet() ;
			//遍历Map信息
			for (Iterator<Entry<String, Object>> iterator = keyset.iterator(); iterator.hasNext();) {
				Entry<String, Object> entry = iterator.next();
				if (entry.getKey() != "") {
					String key = entry.getKey();
					String val = String.valueOf(entry.getValue());
					if (urlencode) {
						//将当前值进行转码，使用utf-8编码
						val = URLEncoder.encode(val, "utf-8");
					}
					buff.append(key.toLowerCase() + "=" + val + "&");
				}
			}
		} catch (Exception e) {
			e.printStackTrace() ;
		}
		if (buff.length() > 0)
			return buff.substring(0, buff.length() - 1);
		else
			return String.valueOf(buff);
	}

	/**
	 * 将接收到的推送XML转换为Map保存
	 * 
	 * <xml>
	 *    <OpenId><![CDATA[111222]]></OpenId>
	 *    <AppId><![CDATA[wwwwb4f85f3a797777]]></AppId>
	 *    <IsSubscribe>1</IsSubscribe> <ProductId><![CDATA[777111666]]></ProductId>
	 *    <TimeStamp>1369743908</TimeStamp>
	 *    <NonceStr><![CDATA[YvMZOX28YQkoU1i4NdOnlXB1]]></NonceStr>
	 *    <AppSignature><![CDATA[a9274e4032a0fec8285f147730d88400392acb9e]]></AppSignature>
	 *    <SignMethod><![CDATA[sha1]]></SignMethod>
	 * </xml>
	 * @param postData
	 * @return
	 */
	public static Map<String, String> parseHashMap(String data) throws Exception{
		Map<String, String> hashMap = new HashMap<String, String>() ;
		
		Document doc = DocumentHelper.parseText(data) ;
		Element rootEle = doc.getRootElement() ;
		
		//取得当前节点下所有子节点信息
		List<?> eleList = rootEle.elements() ;
		
		for (Iterator<?> iterator = eleList.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			hashMap.put(element.getName(), element.getTextTrim()) ;
		}

		return hashMap;
	}
	
	
	/**
	 * 将接收到的推送XML转换为Map保存
	 * 
	 * <xml>
	 *    <OpenId><![CDATA[111222]]></OpenId>
	 *    <AppId><![CDATA[wwwwb4f85f3a797777]]></AppId>
	 *    <IsSubscribe>1</IsSubscribe> <ProductId><![CDATA[777111666]]></ProductId>
	 *    <TimeStamp>1369743908</TimeStamp>
	 *    <NonceStr><![CDATA[YvMZOX28YQkoU1i4NdOnlXB1]]></NonceStr>
	 *    <AppSignature><![CDATA[a9274e4032a0fec8285f147730d88400392acb9e]]></AppSignature>
	 *    <SignMethod><![CDATA[sha1]]></SignMethod>
	 * </xml>
	 * @param postData
	 * @return
	 */
	public static SortedMap<String, Object> parseTreeMap(String data) throws Exception{
		SortedMap<String, Object> treeMap = new TreeMap<String, Object>() ;
		
		Document doc = DocumentHelper.parseText(data) ;
		Element rootEle = doc.getRootElement() ;
		
		//取得当前节点下所有子节点信息
		List<?> eleList = rootEle.elements() ;
		
		for (Iterator<?> iterator = eleList.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			treeMap.put(element.getName(), element.getTextTrim()) ;
		}

		return treeMap;
	}

	/**
	 * @author yubin
	 * 
	 * 将MAP转换为String类型的XML
	 * 				该XML满足微信端字符流格式
	 * @param map
	 * @return
	 */
	public static String parseStringXML(Map<String, Object> map) {
		StringBuffer strXML = new StringBuffer();
		strXML.append("<xml>");
		for(String key : map.keySet())
			strXML.append(key.equals("key") ? "" : "<" + key + "><![CDATA[" + map.get(key) + "]]></" + key + ">");
		strXML.append("</xml>");
		return String.valueOf(strXML);
	}
	
	
	
	
	public static boolean isEmpty(String charset) {
		return charset.isEmpty();
	}
	
}
