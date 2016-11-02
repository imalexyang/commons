package com.platform.web.common.util;

/**
 * @author yanqiang
 */
import java.security.Key;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DESUtils {
	
	private static Logger logger = LoggerFactory.getLogger(DESUtils.class);
	
	private final static byte[] keyiv = "12345678".getBytes();
	
    /**
     * CBC加密
     * @param key 密钥
     * @param keyiv IV
     * @param data 明文
     * @return Base64编码的密文
     * @throws Exception
     */
    public static String encryptDES(final String data, final String key) {
        try {
			DESedeKeySpec spec = new DESedeKeySpec(key.getBytes());
			SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
			Key deskey = keyfactory.generateSecret(spec);
			Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
			IvParameterSpec ips = new IvParameterSpec(keyiv);
			cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
			byte[] bOut = cipher.doFinal(data.getBytes("UTF-8"));
			return new String(Base64.encodeBase64(bOut));
		} catch (Exception e) {
			logger.error("加密出错,key:" + key + ",data:" + data, e);
		}
		return null;
    }
    /**
     * CBC解密
     * @param key 密钥
     * @param keyiv IV
     * @param data Base64编码的密文
     * @return 明文
     * @throws Exception
     */
    public static String decryptDES(final String data, final String key) {
        try {
			DESedeKeySpec spec = new DESedeKeySpec(key.getBytes());
			SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
			Key deskey = keyfactory.generateSecret(spec);
			Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
			IvParameterSpec ips = new IvParameterSpec(keyiv);
			cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
			byte[] bOut = cipher.doFinal(Base64.decodeBase64(data));
			return new String(bOut, "UTF-8");
		} catch (Exception e) {
			logger.error("解密出错, key:" + key + ",data:" + data, e);
		}
		return null;
    }
    
    /**
     * 把字节数组转换成16进制字符串
     * 
     * @param bArray
     * @return
     */
    public static final String bytesToHexString(final byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (byte element : bArray) {
            sTemp = Integer.toHexString(0xFF & element);
            if (sTemp.length() < 2) {
                sb.append(0);
            }
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * MD5加密字符串，返回加密后的16进制字符串
     * 
     * @param origin
     * @return
     */
    public static String encryptMD5(final String origin) {
        return bytesToHexString(encodeMD5(origin));
    }
    
    /**
     * MD5加密字符串，返回加密后的字节数组
     * 
     * @param origin
     * @return
     */
    private static byte[] encodeMD5(final String origin) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            return md.digest(origin.getBytes());
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
        }
        return new byte[0];
    }

}
