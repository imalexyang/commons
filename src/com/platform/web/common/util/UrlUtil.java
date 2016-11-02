package com.platform.web.common.util;

import javax.servlet.http.HttpServletRequest;
/**
 * 
 * @author: yangzhi
 * @Email: zhi19861117@126.com
 * @version:2012-10-31 上午10:00:51 
 * 类说明
 */
public class UrlUtil{
	 public static String buildRequestUrl(HttpServletRequest r)
	    {
	        return buildRequestUrl(r.getServletPath(), r.getRequestURI(), r.getContextPath(), r.getPathInfo(), r.getQueryString());
	    }

	    private static String buildRequestUrl(String servletPath, String requestURI, String contextPath, String pathInfo, String queryString)
	    {
	        StringBuilder url = new StringBuilder();
	        if(servletPath != null)
	        {
	            url.append(servletPath);
	            if(pathInfo != null)
	                url.append(pathInfo);
	        } else
	        {
	            url.append(requestURI.substring(contextPath.length()));
	        }
	        return url.toString();
	    }
}
