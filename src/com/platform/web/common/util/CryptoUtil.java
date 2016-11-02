package com.platform.web.common.util;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 加密解密工具类
 * 
 * @author yanqiang
 * 
 */
public class CryptoUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CryptoUtil.class);

    /**
     * AES加密
     * 
     * @param content
     * @param password
     * @return
     */
    public static final byte[] encryptAES(final String content, final String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(password.getBytes());
            kgen.init(128, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes("UTF-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * AES解密
     * 
     * @param content
     * @param password
     * @return
     */
    public static final String decryptAES(final byte[] content, final String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(password.getBytes());
            kgen.init(128, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
            return new String(result, "UTF-8"); // 解密
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * Base64编码
     * 
     * @param input
     * @return
     */
    public static final String encryptBase64(final byte[] input) {
        String str = Base64.encodeBase64String(input);
        if (str != null) {
            return str.replaceAll("\n|\r\n", "");
        }
        return str;
    }

    /**
     * Base64解码
     * 
     * @param input
     * @return
     */
    public static final byte[] decryptBase64(final String input) {
        return Base64.decodeBase64(input);
    }

    public static byte[] hexStringToBytes(final String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    public static final String bytesToHexString(final byte[] buf) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    private static byte toByte(final char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static void main(String[] args) {
        String content = "!#$!@$@!ASDFASqwer153145PUIH";
        String password = "abcdefghijkl";
        String result = encryptBase64(encryptAES(content, password));
        System.out.println("加密后："+ result);
        System.out.println("解码后："+decryptAES(decryptBase64(result), password));
    }

}
