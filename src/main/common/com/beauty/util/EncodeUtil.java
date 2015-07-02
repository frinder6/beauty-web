/**    
 * @Title: EncodeUtil.java  
 * @Package com.beauty.util  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年6月4日 下午9:41:52 
 * @version V1.0   
 */
package com.beauty.util;

import java.security.MessageDigest;

import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.codec.Utf8;

/**
 * @ClassName: EncodeUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年6月4日 下午9:41:52
 * 
 */
public class EncodeUtil {

	/**
	 * 
	 * @Title: encryptPassword 
	 * @Description: TODO(MD5加密)  
	 * @author frinder_liu 
	 * @param strPasswd
	 * @return
	 * @return String
	 * @date 2015年6月4日 下午9:56:59
	 * @throws
	 */
	public static String encryptPassword(String strPasswd) {
		if (strPasswd == null || strPasswd.equals("")) {
			return "";
		}
		MessageDigest md;
		byte[] ebytes = { 0 };
		try {
			md = MessageDigest.getInstance("MD5", "SUN");
			md.update(strPasswd.getBytes());
			ebytes = md.digest();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new sun.misc.BASE64Encoder().encode(ebytes);
	}
	
	/**
	 * 
	 * @Title: encodePassword
	 * @Description: TODO(密码加密)
	 * @author frinder_liu
	 * @param rawPass
	 * @param salt
	 * @return
	 * @return String
	 * @date 2015年6月4日 下午9:47:40
	 * @throws
	 */
	public static String encodePassword(String rawPass, Object salt) {
		String encPass = rawPass + "_" + salt;
		return Utf8.decode(Base64.encode(encPass.getBytes()));
	}

}
