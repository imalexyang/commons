package com.platform.web.common.util;

import java.io.Serializable;
/**
 * 返回对象的封装
 * @author caomei
 *
 */
@SuppressWarnings("serial")
public class CFReturnObject implements Serializable{
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";
	public static final String WARNING = "warning";
	private String status;
	private String message;
	private Object obj;
	
	public CFReturnObject() {
		
	}
	
	public CFReturnObject(String status) {
		this.status = status;
	}
	
	public CFReturnObject(String status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public CFReturnObject(String status, String message, Object obj) {
		this.status = status;
		this.message = message;
		this.obj = obj;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
}
