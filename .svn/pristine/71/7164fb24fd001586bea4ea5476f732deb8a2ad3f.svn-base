package com.saohuobang.web.common.util;




/**
 * AppException<br>
 * <li> 系统总异常类
 * <li>继承的子类必须捕获异常处理
 * @author hangk
 * 2014-4-26
 */
public class BenmuAppException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final int DEFAULT_LANG_ID =1;
	private String statusCode;
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	//异常编码，存储在参数表中
	private int code;
	//占位符值列表
	private Object[] placeHolderValues;
	//堆栈信息第一行
	private String stackTraceFirst;
	//全部信息：realCause+stackTraceFirst
	private String totalMessage;
	private Throwable realCause;
	private String mcname;
	public String getMcname() {
		return mcname;
	}
	public void setMcname(String mcname) {
		this.mcname = mcname;
	}
	public BenmuAppException(){
		super();
		this.code = 000000;
		this.placeHolderValues = new String[] {"-"};
	}
	public BenmuAppException(String message){
		super(message);
		this.code = 000000;
		this.placeHolderValues = new String[]{message};
	}

	public BenmuAppException(String message,Throwable cause){
		super(message,cause);
		this.code = 000000;
		this.placeHolderValues = new String[]{message};
	}
	public BenmuAppException(String message,Throwable cause,String stackTraceFirst){
		super(message,cause);
		this.code = 000000;
		if(null != cause){
			this.realCause = cause;
			if(null != cause.getCause()){
				this.realCause = cause.getCause();
			}
		}		
		this.placeHolderValues = new String[]{message};
		this.stackTraceFirst = stackTraceFirst;
		this.totalMessage = realCause+"\n at "+stackTraceFirst;
	}
	/**
	 * 异常处理WEB前端展示
	 * @param code
	 * @param cname
	 * @param message
	 * @param cause
	 * @param stackTraceFirst
	 */
	public BenmuAppException(String code,String cname,String message,Throwable cause,String stackTraceFirst){
		super(message,cause);
		this.statusCode = code;
		this.mcname=cname;
		this.placeHolderValues = new String[]{message};
		this.stackTraceFirst = stackTraceFirst;
		this.totalMessage = getCause()+"\n at "+stackTraceFirst;
	}
	/**
	 * 异常处理WEB前端展示
	 * @param code
	 * @param cname
	 * @param message
	 * @param cause
	 * @param stackTraceFirst
	 */
	public BenmuAppException(String cname,String message,Throwable cause,String stackTraceFirst){
		super(message,cause); 
		this.mcname=cname;
		this.placeHolderValues = new String[]{message};
		this.stackTraceFirst = stackTraceFirst;
		this.totalMessage = getCause()+"\n at "+stackTraceFirst;
	}
	public BenmuAppException(Throwable cause){
		super(cause);
		this.code = 000000;
		this.placeHolderValues = new String[]{"-"};
	}
	
	public BenmuAppException(int code){
		this.code = code;
	}
	
	public BenmuAppException(int code,Throwable cause){
		this.code = code;
	}
	
	public BenmuAppException(int code,Object[] placeHolderValuse){
		this.code = code;
		this.placeHolderValues = placeHolderValuse;
	}
	
	public BenmuAppException(int code,Object[] placeHolderValuse,Throwable cause){
		super(cause);
		this.code = code;
		this.placeHolderValues = placeHolderValuse;
	}
	
	public int getCode() {
		return code;
	}

	public Object[] getPlaceHolderValues() {
		return placeHolderValues;
	}

	public String getStackTraceFirst() {
		return stackTraceFirst;
	}
	
	public String getTotalMessage() {		
		return totalMessage;
	}
	
	public Throwable getRealCause() {		
		return realCause;
	}
	
	/**
	 * 将一个异常包装成AppException抛出
	 * @param originException
	 * @return
	 */
	public static Throwable getRealCause(Exception ex){
		
		Throwable realCause = null; 
		if(null != ex){
			if(null != ex.getCause()){
				realCause = ex.getCause();
				if(null != realCause.getCause()){
					realCause = realCause.getCause();
				}
			}			
		}
		return realCause;
	}
	
	/**
	 * 将一个异常包装成AppException抛出
	 * @param originException
	 * @return
	 */
	public static BenmuAppException transferPCITCException(Exception originException){
		if(originException == null){
			return null;
		} else if(originException instanceof BenmuAppException){
			return (BenmuAppException)originException;
		}else{
			return new BenmuAppException("App Transaction Rolledback.", originException);
		}
		
	}
	
	public String getErroMessage(){
		return "";
	}
	
	
}
