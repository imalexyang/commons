package com.saohuobang.web.common.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;







import org.apache.commons.fileupload.FileItem;



/**
 * 文件系统门面类
 * 
 * @author yubin
 * 
 */
public interface BenmuFileFacade {

	/**
	 * 是否允许该文件上传
	 * 
	 * @return
	 */
	public boolean isAbleUploadImg(FileItem file);
	
	/**
	 * 是否允许该文件上传
	 * 
	 * @return
	 */
	public boolean isAbleUploadImg(File file,String fileName) throws BenmuAppException;

	/**
	 * 是否允许该文件上传, 支持限制大小
	 * 
	 * @return
	 */	
	public boolean isAbleUploadImg(File file, String fileName, long maxSizeMB) throws BenmuAppException;
	
}
