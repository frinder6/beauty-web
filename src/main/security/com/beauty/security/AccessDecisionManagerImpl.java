/**    
 * @Title: AccessDecisionManagerImpl.java  
 * @Package com.mvc.security  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年3月28日 下午9:26:57 
 * @version V1.0   
 */
package com.beauty.security;

import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName: AccessDecisionManagerImpl
 * @Description: TODO(权限认证核心处理类)
 * @author frinder_liu
 * @date 2015年3月28日 下午9:26:57
 * 
 */
@Component("accessDecisionManager")
public class AccessDecisionManagerImpl implements AccessDecisionManager {

	private final Logger logger = Logger.getLogger(getClass());

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.AccessDecisionManager#decide(org.
	 * springframework.security.core.Authentication, java.lang.Object,
	 * java.util.Collection)
	 */
	/**
	 * @param authentication
	 *            登陆的角色所具有的权限列表
	 * @param object
	 *            访问的url
	 * @param configAttributes
	 *            访问这个url所需要的权限列表
	 */
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
		// TODO Auto-generated method stub
		logger.info("AccessDecisionManagerImpl.decide() --> url : [ " + object + " ]");
		logger.info("users auths : [ " + JSON.toJSONString(authentication.getAuthorities()) + " ]");
		logger.info("visit need auths : [ " + configAttributes + " ]");
		if (null == configAttributes) {
			return;
		}
		// 权限列表
		Iterator<ConfigAttribute> it = configAttributes.iterator();
		while (it.hasNext()) {
			// 权限
			ConfigAttribute ca = it.next();
			// 相应的权限
			String needRole = ((SecurityConfig) ca).getAttribute();

			// ga 为用户所被赋予的权限
			// needRole 为访问相应的资源应该具有的权限。
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				if (needRole.trim().equals(ga.getAuthority().trim())) {
					return;
				}
			}
		}
		throw new AccessDeniedException("no right...");
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

}
