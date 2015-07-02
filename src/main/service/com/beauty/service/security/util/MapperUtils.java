/**    
 * @Title: MapperUtils.java  
 * @Package com.mvc.service  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年5月21日 下午10:23:41 
 * @version V1.0   
 */
package com.beauty.service.security.util;

/**
 * @ClassName: MapperUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年5月21日 下午10:23:41
 * 
 */
public class MapperUtils {

	// 查询用户权限
	public static final String _SECURITY_QUERY_USER_ROLE_AUTHS = "Security.queryUserRoleAuths";

	// 查询登陆用户
	public static final String _SECURITY_QUERY_LOGIN_USER = "Security.queryUserByUsercode";

	// 查询用户所有管理资源
	public static final String _SECURITY_QUERY_ALL_RESOURCES = "Security.queryAllResources";

	// 查询未配置权限的资源
	public static final String _SECURITY_QUERY_UN_CONF_AUTH_RESOURCES = "Security.queryUnConfigAuthResources";

	// 查询菜单
	public static final String _RESOURCE_QUERY_MENU = "com.beauty.dao.security2.ResourceMapper.selectMenus";

	// 菜单下拉框
	public static final String _RESOURCE_MENU_COMBO = "com.beauty.dao.security2.ResourceMapper.selectMenuCombo";

}
