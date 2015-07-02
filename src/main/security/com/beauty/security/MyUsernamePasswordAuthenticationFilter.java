package com.beauty.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 重写用户名密码验证部分，加入了验证码的验证
 */
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final Logger logger = Logger.getLogger(getClass());

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		logger.info("MyUsernamePasswordAuthenticationFilter.attemptAuthentication()............begin!");
		try {
			Authentication authentication = super.attemptAuthentication(request, response);
			return authentication;
		} catch (UsernameNotFoundException e) {
			throw new AuthenticationServiceException(e.getMessage());
		} catch (Exception e) {
			throw new AuthenticationServiceException("用户名或密码不正确！");
		}
	}
}
