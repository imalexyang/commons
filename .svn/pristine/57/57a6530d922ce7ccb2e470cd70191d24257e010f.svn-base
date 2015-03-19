package com.saohuobang.web.common.logging;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

import com.saohuobang.web.common.json.JsonUtils;
import com.saohuobang.web.common.mp.LogCollection;


/**
 * RPC日志打印
 * @author loenwang
 *
 */
public class RPCLogger {

	private static Logger logger=Logger.getLogger("sysunifylog");
	private static String INFO_LOG_PATTERN="##[logId:%s]##[traceId:%s]##[refer:%s]##[url:%s]##[content:%s]";
	private static String ERR_LOG_PATTERN="##[logId:%s]##[errorId:%s]##[traceId:%s]##[refer:%s]##[url:%s]##[content:%s]";
	
	/**
	 * info日志打印
	 * @param logId
	 * @param traceId
	 * @param refer
	 * @param url
	 * @param msg
	 */
	public static void info(String logId,String traceId,String refer,String url,String msg){
		
			logger.info(String.format(INFO_LOG_PATTERN, logId,traceId,refer,url,msg));
		 
	}
	
	public static void infoBean(String logId,String traceId,String refer,String url,Object obj){
		
			logger.info(String.format(INFO_LOG_PATTERN,logId,traceId,refer,url,JsonUtils.convertToStr(obj)));	
		
	}
	
	public static void error(String logId,String errorId,String traceId,String refer,String url,String msg){
		
		String logContent=String.format(ERR_LOG_PATTERN,logId,errorId,traceId,refer,url,msg);
		
	 	logger.error(logContent);
	 	
	 	//收集日志
	 	LogCollection.alarm(errorId, logContent);
	 	
	}
	
	
	
	public static void error(String logId,String errorId,String traceId,String refer,String url,Throwable e){
		
		String logContent=String.format(ERR_LOG_PATTERN,logId,errorId,traceId,refer,url,getTrace(e));
		 
		logger.error(logContent);
		
		//收集日志
		LogCollection.alarm(errorId, logContent);
	 
	}
	
	private static String getTrace(Throwable t){
		
		StringWriter stringWriter=new StringWriter();
		PrintWriter writer=new PrintWriter(stringWriter);
		t.printStackTrace(writer);
		return stringWriter.getBuffer().toString();
	}
}
