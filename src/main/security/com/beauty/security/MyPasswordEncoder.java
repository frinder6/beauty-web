/**
 * Copyright: Copyright (c) 2012
 * Company:深圳市海乐淘电子商务有限公司
 * @author frinder(liujunhui)
 * @date 2013-5-24 下午3:21:40
 * @version V1.0
 *
 * @Description: TODO
 */
package com.beauty.security;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.beauty.util.EncodeUtil;

/**
 * 
 */
@SuppressWarnings("deprecation")
@Component("passwordEncoder")
public class MyPasswordEncoder implements PasswordEncoder {

	private final Logger logger = Logger.getLogger(getClass());

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		logger.info("MyPasswordEncoder.isPasswordValid... encPass : " + encPass + ", rawPass : " + rawPass + ", salt : " + salt);
		// TODO Auto-generated method stub
		String inputPass = encodePassword(rawPass, salt);
		return inputPass.equals(encPass);
	}

	@Override
	public String encodePassword(String rawPass, Object salt) {
		logger.info("MyPasswordEncoder.encodePassword... rawPass : " + rawPass + ", salt : " + salt);
		// TODO Auto-generated method stub
		return EncodeUtil.encryptPassword(rawPass);
	}

}
