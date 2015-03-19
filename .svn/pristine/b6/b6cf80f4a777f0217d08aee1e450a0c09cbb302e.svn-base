package com.saohuobang.web.common.http;

import java.util.UUID;

import javax.servlet.ServletRequest;

import com.saohuobang.web.common.http.filter.RequestTrace;

/**
 * use for trace the http request
 * @author loenwang
 *
 */
public class TraceUtils {

	public static String generateTraceId(){
		
		return UUID.randomUUID().toString();
		
	}
	
	public static void manuplateTraceId(ServletRequest request){
		
		String traceId=request.getParameter("traceId");
		
		  if(traceId==null){
			  
			  request.setAttribute("traceId",generateTraceId());
			  
		  }else
			  
			  request.setAttribute("traceId",traceId);
	}  
	
	public static String getTraceId(){
		
		return (String) RequestTrace.getLocalRequest().getAttribute("traceId");
	}
}
