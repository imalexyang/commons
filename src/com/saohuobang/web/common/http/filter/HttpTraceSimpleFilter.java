package com.saohuobang.web.common.http.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.saohuobang.web.common.http.TraceUtils;

/**
 * filter for trace
 * @author loenwang
 *
 */
public class HttpTraceSimpleFilter extends RequestTrace implements Filter {

	
	@Override
	public void destroy() {
		
		localRequest.remove(); 
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {

		localRequest.set(arg0);
		
		TraceUtils.manuplateTraceId(arg0);
		
		arg2.doFilter(arg0, arg1);
		
        localRequest.remove();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

      localRequest.set(null);

	}

	public static ServletRequest getLocalRequest(){
		
		return localRequest.get();
	}
}
