/**    
 * @Title: ISecurityService.java  
 * @Package com.beauty.service.security  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年6月7日 下午2:16:29 
 * @version V1.0   
 */
package com.beauty.service.base;

import java.util.List;

import com.beauty.entity.security2.Resource;
import com.beauty.entity.security2.User;

/**
 * @ClassName: ISecurityService
 * @Description: TODO(权限管理查询接口)
 * @author frinder_liu
 * @date 2015年6月7日 下午2:16:29
 * 
 */
public interface ISecurityService {

	public User queryByUsername(String username);

	public List<?> queryUserRoleAuths(String usercode);

	public List<?> queryAllResources(String cache);

	public List<?> queryMenus(Resource resource);

	public List<?> queryMenuCombo(Resource resource);
}
