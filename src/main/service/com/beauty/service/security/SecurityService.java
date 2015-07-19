/**    
 * @Title: SecurityService.java  
 * @Package com.mvc.service  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年5月17日 下午8:20:16 
 * @version V1.0   
 */
package com.beauty.service.security;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.beauty.entity.security2.Resource;
import com.beauty.entity.security2.User;
import com.beauty.service.base.BaseService;
import com.beauty.service.base.ISecurityService;
import com.beauty.service.security.util.MapperUtils;
import com.beauty.service.security.util.RedisCacheKey;

/**
 * @ClassName: SecurityService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年5月17日 下午8:20:16
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@Service("securityService")
public class SecurityService extends BaseService implements ISecurityService {

	/**
	 * 
	 * @Title: queryByUsername
	 * @Description: TODO(根据用户名查询登陆用户)
	 * @author frinder_liu
	 * @param username
	 * @return
	 * @return User
	 * @date 2015年6月7日 下午1:44:46
	 * @throws
	 */
	@Override
	public User queryByUsername(String username) {
		return (User) super.queryOne(MapperUtils._SECURITY_QUERY_LOGIN_USER, username);
	}

	/**
	 * 
	 * @Title: queryUserRoleAuths
	 * @Description: TODO(登陆用户角色-权限)
	 * @author frinder_liu
	 * @param usercode
	 * @return
	 * @return List<?>
	 * @date 2015年6月7日 下午1:47:41
	 * @throws
	 */
	@Cacheable(value = RedisCacheKey._REDIS_CACHE_VALUE, key = "'_LOGIN_USER_ROLE_AUTHS_KEY.' + #usercode.toUpperCase()")
	@Override
	public List<?> queryUserRoleAuths(String usercode) {
		return super.query(MapperUtils._SECURITY_QUERY_USER_ROLE_AUTHS, usercode);
	}

	/**
	 * 
	 * @Title: queryUserResources
	 * @Description: TODO(查询所有资源)
	 * @author frinder_liu
	 * @return
	 * @return List<?>
	 * @date 2015年6月7日 下午1:52:32
	 * @throws
	 */
	@Cacheable(value = RedisCacheKey._REDIS_CACHE_VALUE, key = "'_ALL_RESOURCES_KEY.' + #cache.toUpperCase()")
	@Override
	public List<?> queryAllResources(String cache) {
		return super.query(MapperUtils._SECURITY_QUERY_ALL_RESOURCES);
	}

	/**
	 * 
	 * @Title: queryMenus
	 * @Description: TODO(加载当前用户菜单)
	 * @author frinder_liu
	 * @param usercode
	 * @return
	 * @return List<?>
	 * @date 2015年6月7日 下午3:24:07
	 * @throws
	 */
	@Cacheable(value = RedisCacheKey._REDIS_CACHE_VALUE, key = "'_LOGIN_USER_MENU_KEY.' + #resource.getUsercode().toUpperCase() + #resource.getParentId().toString() + #resource.getType().toString() + #resource.getLevel().toString()")
	@Override
	public List<?> queryMenus(Resource resource) {
		return super.query(MapperUtils._RESOURCE_QUERY_MENU, resource);
	}

	/**
	 * 
	 * @Title: queryMenuCombo
	 * @Description: TODO(查询用户下拉框)
	 * @author frinder_liu
	 * @param usercode
	 * @return
	 * @return List<?>
	 * @date 2015年6月7日 下午4:12:54
	 * @throws
	 */
	@Cacheable(value = RedisCacheKey._REDIS_CACHE_VALUE, key = "'_LOGIN_USER_MENU_COMBO_KEY.' + #resource.getUsercode().toUpperCase()")
	@Override
	public List<?> queryMenuCombo(Resource resource) {
		return super.query(MapperUtils._RESOURCE_MENU_COMBO, resource);
	}
}
