/**    
 * @Title: UserDetailServiceImpl.java  
 * @Package com.mvc.security  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年3月25日 下午11:03:45 
 * @version V1.0   
 */
package com.beauty.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.beauty.base.ISecurityService;
import com.beauty.entity.security2.User;

/**
 * @ClassName: UserDetailServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年3月25日 下午11:03:45
 * 
 */
@Component("myUserDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

	private final Logger logger = Logger.getLogger(getClass());

	@Resource(name = "securityService")
	private ISecurityService securityService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("UserDetailServiceImpl.loadUserByUsername...................................begin !");
		User user = this.securityService.queryByUsername(username);
		if (null == user) {
			throw new UsernameNotFoundException("账号名:" + username + " 不存在！");
		}
		// 权限集合
		List<?> auths = this.securityService.queryUserRoleAuths(user.getUsercode());
		// 保存权限集合
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		//
		Map<String, String> map;
		String authorityCode;
		for (Object obj : auths) {
			map = (Map<String, String>) obj;
			authorityCode = map.get("authority_code");
			authorities.add(new SimpleGrantedAuthority(authorityCode));
		}
		logger.info("the current user : [ " + username + "'s ] authorities : [ " + JSON.toJSONString(authorities) + " ]");
		// 构建登陆用户
		UserInfo userinfo = new UserInfo(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
		logger.info("UserDetailServiceImpl.loadUserByUsername.....................................end !");
		return userinfo;
	}
}
