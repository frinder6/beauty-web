/**    
 * @Title: InvocationSecurityMetadataSourceServiceImpl.java  
 * @Package com.mvc.security  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年3月29日 下午11:56:06 
 * @version V1.0   
 */
package com.beauty.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.beauty.service.base.ISecurityService;

/**
 * @ClassName: InvocationSecurityMetadataSourceServiceImpl
 * @Description: TODO(获取所有权限、资源，并封装为url:auths格式)
 * @author frinder_liu
 * @date 2015年3月29日 下午11:56:06
 * 
 */
@Component("securityMetadataSource")
public class InvocationSecurityMetadataSourceServiceImpl implements FilterInvocationSecurityMetadataSource {

	private final Logger logger = LogManager.getLogger(getClass());

	@Resource(name = "securityService")
	private ISecurityService securityService;

	// 保存权限
	private static Map<String, Collection<ConfigAttribute>> authorityMap = new ConcurrentHashMap<String, Collection<ConfigAttribute>>();

	/**
	 * 
	 */
	public InvocationSecurityMetadataSourceServiceImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.SecurityMetadataSource#getAttributes
	 * (java.lang.Object)
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		logger.info("InvocationSecurityMetadataSourceServiceImpl.getAttributes() --> args : [ " + object + " ]");
		if (authorityMap.isEmpty()) {
			// 初始化权限
			this.loadResources();
		}
		// object 是一个URL，用户请求的url。
		String url = ((FilterInvocation) object).getRequestUrl();
		int len = url.indexOf("\\?");
		if (len > -1) {
			// 截取参数之前的url
			url = url.substring(0, len);
		}
		Collection<ConfigAttribute> attributes = this.getAuths(url);
		logger.info("InvocationSecurityMetadataSourceServiceImpl.getAttributes() --> auths : [ " + JSON.toJSONString(attributes) + " ]");
		return attributes;
	}

	/**
	 * 
	 * @Title: getAuths
	 * @Description: TODO(获取资源对应权限集合)
	 * @author frinder_liu
	 * @param url
	 * @return
	 * @return Collection<ConfigAttribute>
	 * @date 2015年5月23日 下午1:13:36
	 * @throws
	 */
	private Collection<ConfigAttribute> getAuths(String url) {
		Iterator<String> keys = authorityMap.keySet().iterator();
		String key;
		while (keys.hasNext()) {
			key = keys.next();
			if ("/".equals(key)) {
				continue;
			}
			if (url.indexOf(key) > -1) {
				return authorityMap.get(key);
			}
		}
		return null;
	}

	/**
	 * 
	 * @Title: loadResources
	 * @Description: TODO(加载资源-权限集合到 authorityMap)
	 * @author frinder_liu
	 * @return void
	 * @date 2015年5月23日 下午1:03:47
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	private void loadResources() {
		List<?> resources = this.securityService.queryAllResources("load_resources");
		// 临时变量
		Map<String, String> map;
		String resourceValue, authorityCode;
		for (Object obj : resources) {
			map = (Map<String, String>) obj;
			resourceValue = map.get("resource_value");
			authorityCode = map.get("authority_code");
			if (authorityMap.containsKey(resourceValue)) {
				authorityMap.get(resourceValue).add(new SecurityConfig(authorityCode));
			} else {
				// 权限集合
				Collection<ConfigAttribute> attributes = new HashSet<ConfigAttribute>();
				attributes.add(new SecurityConfig(authorityCode));
				authorityMap.put(resourceValue, attributes);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.access.SecurityMetadataSource#
	 * getAllConfigAttributes()
	 */
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.SecurityMetadataSource#supports(java
	 * .lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}
