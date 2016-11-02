package com.platform.web.common.http;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


/**
 * http�����װ��
 * @author loenwang
 *
 */

@SuppressWarnings("deprecation")
public class HttpUtils {

	private static int CON_TIME_OUT=3000;//default  max connect time
	private static int SO_TIME_OUT=2000; //default  wait time 
	
	

	/**
	 * �������ó�ʱʱ��
	 * @param url
	 * @param map
	 * @param conTimeout
	 * @param soTimeout
	 * @return
	 * @throws Exception
	 */
	 
	public static String postWithMap(String url,Map<String,Object> map,int conTimeout,int soTimeout)throws Exception{
		
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		
		if(map!=null)
			for(String key : map.keySet()){
				
				params.add(new BasicNameValuePair(key,map.get(key).toString()));
				
			}
		
		HttpPost httpPost=new HttpPost(url);
		httpPost.setConfig(RequestConfig.custom().setConnectTimeout(conTimeout==0?CON_TIME_OUT:conTimeout).setSocketTimeout(soTimeout==0?SO_TIME_OUT:soTimeout).build());
		
		HttpEntity entity=null;
		HttpResponse response=null;
		String result=null;
		
		try{
		
			httpPost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
		    response=new DefaultHttpClient().execute(httpPost);
		    
		    if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
		    	
		        entity=response.getEntity();
		    	result=EntityUtils.toString(entity);
		    	
		    }else
		    	throw new HttpException(url+"##resStatus is "+response.getStatusLine().getStatusCode());
		    	
		    return result;
		    
		}finally{
			
			if(httpPost!=null){
			
				httpPost.abort();
				
				entity=null;
				response=null;
			    httpPost=null;
				
			}
			
		}
		
	}
	
	
	/**
	 * Ĭ�ϵĳ�ʱʱ��
	 * @param url
	 * @param map
	 * @return
	 * @throws Exception
	 */
     
	public static String postWithMap(String url,Map<String,Object> map) throws Exception{
		
        List<NameValuePair> params=new ArrayList<NameValuePair>();
		
		if(map!=null)
			for(String key : map.keySet()){
				
				params.add(new BasicNameValuePair(key,map.get(key).toString()));
				
			}
		
		HttpPost httpPost=new HttpPost(url);
		
		HttpEntity entity=null;
		CloseableHttpResponse response=null;
		String result=null;
		
		try{
		
			httpPost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
			httpPost.setConfig(RequestConfig.custom().setConnectTimeout(CON_TIME_OUT).setSocketTimeout(SO_TIME_OUT).build());
			
		    response=HttpClients.createDefault().execute(httpPost);
		    
		    if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
		    	
		        entity=response.getEntity();
		    	result=EntityUtils.toString(entity);
		    	
		    }else
		    	throw new HttpException(url+"##resStatus is "+response.getStatusLine().getStatusCode());
		    	
		    return result;
		    
		}finally{
			
			if(httpPost!=null){
			
				httpPost.abort();
				
			    httpPost=null;
				
			}
			if(response!=null){
				
				response.close();
			}
			
		}
		
	}
    
	 
    
}
