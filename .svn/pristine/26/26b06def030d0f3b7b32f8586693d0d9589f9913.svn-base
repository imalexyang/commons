package com.saohuobang.web.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

public class RequestJsonHelper {
	
	public static String requestJsonByPost(String urlString, String charset, String data) {
		InputStream is = null;
		PostMethod postMethod = null;
		StringBuffer html = new StringBuffer();
		
		try {
//			HttpClient httpclient = new HttpClient(getConnectionManager());
			HttpClient httpclient = new HttpClient();
			httpclient.getParams().setParameter("http.protocol.content-charset", "UTF-8");
			httpclient.getParams().setBooleanParameter("http.protocol.expect-continue", false);   
			postMethod = new PostMethod(urlString); 
			postMethod.addRequestHeader("Connection", "Keep-Alive");
			postMethod.addRequestHeader("ContentType", "application/json; charset=utf-8");
			postMethod.setRequestEntity(new StringRequestEntity(data, "application/json", "utf-8"));
			int result = httpclient.executeMethod(postMethod);
			if (result == HttpStatus.SC_OK) {
				is = postMethod.getResponseBodyAsStream();
				InputStreamReader isReader = new InputStreamReader(is, charset);
				BufferedReader bf = new BufferedReader(isReader);
                String temp;
                while ((temp = bf.readLine()) != null) {
                	html.append(temp);
                }
                isReader.close();
                isReader = null;
                bf.close();
                bf = null;
			} else {
				System.out.println("result of function getHtml(" + urlString + ", " + charset + ") is " + result);
			}
		} catch (Exception e) {
			System.out.println("getHtml(" + urlString + ", " + charset + ") occur exception: " + e);
			return null;
		} finally {
			if (is != null) {
				try {
					is.close();
					is = null;
				} catch (IOException e) {
					System.out.println("finally-->IOException-->" + e);
				}
			}
			if (postMethod != null) {
				postMethod.releaseConnection();
				postMethod = null;
			}
		}
		
		return html.toString();
	}

}
