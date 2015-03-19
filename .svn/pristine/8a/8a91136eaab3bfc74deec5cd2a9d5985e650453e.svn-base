package com.saohuobang.web.common.http.filter;

import javax.servlet.ServletRequest;

public class RequestTrace {

	protected final static ThreadLocal<ServletRequest> localRequest=new ThreadLocal<ServletRequest>();
	
    public static ServletRequest getLocalRequest(){
		
		return localRequest.get();
	}
}
