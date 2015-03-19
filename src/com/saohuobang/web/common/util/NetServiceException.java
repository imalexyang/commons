/**
 * 
 */
package com.saohuobang.web.common.util;

/**
 * @author yubin
 *
 */
public class NetServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -32125162498474633L;

	/**
	 * 
	 */
	public NetServiceException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public NetServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public NetServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NetServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NetServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
