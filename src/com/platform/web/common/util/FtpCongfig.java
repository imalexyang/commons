package com.platform.web.common.util;

/**
 * 
 * 标题：WMall
 * 
 * 作者：孙静 2014-04-25
 * 
 * 描述：取得Ftp配置信息
 * 
 * 说明:
 */
public class FtpCongfig {

	/**
	 * 服务器IP地址
	 */
	private String ftpServer ;
	
	/**
	 * 服务器端口号
	 */
	private Integer port ;
	
	/**
	 * 登录名
	 */
	private String ftpUserName ;
	
	/**
	 * 登陆密码
	 */
	private String ftpPassword ;
	
	/**
	 * Ftp目录
	 */
	private String ftpRoot ;
	
	/**
	 * 
	 */
	private String ftpUrl ;
	
	/**
	 * 最大连接数
	 */
	private Integer dirMaxCnt ;

	public String getFtpServer() {
		return ftpServer;
	}

	public void setFtpServer(String ftpServer) {
		this.ftpServer = ftpServer;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getFtpUserName() {
		return ftpUserName;
	}

	public void setFtpUserName(String ftpUserName) {
		this.ftpUserName = ftpUserName;
	}

	public String getFtpPassword() {
		return ftpPassword;
	}

	public void setFtpPassword(String ftpPassword) {
		this.ftpPassword = ftpPassword;
	}

	public String getFtpRoot() {
		return ftpRoot;
	}

	public void setFtpRoot(String ftpRoot) {
		this.ftpRoot = ftpRoot;
	}

	public String getFtpUrl() {
		return ftpUrl;
	}

	public void setFtpUrl(String ftpUrl) {
		this.ftpUrl = ftpUrl;
	}

	public Integer getDirMaxCnt() {
		return dirMaxCnt;
	}

	public void setDirMaxCnt(Integer dirMaxCnt) {
		this.dirMaxCnt = dirMaxCnt;
	}
}