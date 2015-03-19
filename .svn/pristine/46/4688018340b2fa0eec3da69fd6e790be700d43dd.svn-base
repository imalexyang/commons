package com.saohuobang.web.common.logging;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;




import org.apache.log4j.Logger;

import com.saohuobang.web.common.http.filter.HttpTraceFilter;
import com.saohuobang.web.common.json.JsonUtils;
import com.saohuobang.web.common.mp.LogCollection;


/**
 * 日志输出工具类
 * @author loenwang
 *
 */
public class UnifyLogger {

	private static Logger logger=Logger.getLogger("sysunifylog");
	private static String INFO_LOG_PATTERN="##[logId:%s]##[traceId:%s]##[refer:%s]##[url:%s]##[content:%s]";
	private static String ERR_LOG_PATTERN="##[logId:%s]##[errorId:%s]##[traceId:%s]##[refer:%s]##[url:%s]##[content:%s]";
	
	public static void info(String logId,String msg){
		
		if(HttpTraceFilter.getLocalRequest()==null)
			logger.info(String.format(INFO_LOG_PATTERN, logId,"","","",msg));
		else
		    logger.info(String.format(INFO_LOG_PATTERN,logId,HttpTraceFilter.getLocalRequest().getAttribute("traceId"),((HttpServletRequest)HttpTraceFilter.getLocalRequest()).getHeader("x-forwarded-for"),
				((HttpServletRequest)HttpTraceFilter.getLocalRequest()).getRequestURI(),msg));
	
	}
	
	public static void infoBean(String logId,Object obj){
		
			if(HttpTraceFilter.getLocalRequest()==null)
				logger.info(String.format(INFO_LOG_PATTERN,logId,"","","",JsonUtils.convertToStr(obj)));
			else
			   logger.info(String.format(INFO_LOG_PATTERN,logId,HttpTraceFilter.getLocalRequest().getAttribute("traceId"),((HttpServletRequest)HttpTraceFilter.getLocalRequest()).getHeader("x-forwarded-for"),
					((HttpServletRequest)HttpTraceFilter.getLocalRequest()).getRequestURI(),JsonUtils.convertToStr(obj)));
			
		
	}
	
	public static void error(String logId,String errorId,String msg){
		
		String logContent=null;
		
		if(HttpTraceFilter.getLocalRequest()==null){
			logContent=String.format(ERR_LOG_PATTERN,logId,errorId,"","","",msg);
			logger.error(logContent);
		    
		}else{
			logContent=String.format(ERR_LOG_PATTERN,logId,errorId,HttpTraceFilter.getLocalRequest().getAttribute("traceId"),((HttpServletRequest)HttpTraceFilter.getLocalRequest()).getHeader("x-forwarded-for"),
					((HttpServletRequest)HttpTraceFilter.getLocalRequest()).getRequestURI(),msg);
			logger.error(logContent);
		}
		//收集日志
		LogCollection.alarm(errorId,logContent);
	}
	
	
	
	public static void error(String logId,String errorId,Throwable e){
		
		String logContent=null;
		
		if(HttpTraceFilter.getLocalRequest()==null){
			logContent = String.format(ERR_LOG_PATTERN,logId,errorId,"","","",getTrace(e));
			logger.error(logContent);
		}
		else{
			logContent = String.format(ERR_LOG_PATTERN,logId,errorId,HttpTraceFilter.getLocalRequest().getAttribute("traceId"),((HttpServletRequest)HttpTraceFilter.getLocalRequest()).getHeader("x-forwarded-for"),
					((HttpServletRequest)HttpTraceFilter.getLocalRequest()).getRequestURI(),getTrace(e));
			logger.error(logContent);
		}
		
		//收集日志
		LogCollection.alarm(errorId,logContent);
	}
	
	private static String getTrace(Throwable t){
		
		StringWriter stringWriter=new StringWriter();
		PrintWriter writer=new PrintWriter(stringWriter);
		t.printStackTrace(writer);
		return stringWriter.getBuffer().toString();
	}
}
