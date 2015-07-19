/**    
 * @Title: RoleController.java  
 * @Package com.mvc.controller  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年4月1日 下午4:33:33 
 * @version V1.0   
 */
package com.beauty.controller.security;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauty.entity.security2.Role;
import com.beauty.entity.security2.RoleReAuthority;
import com.beauty.service.base.IMapperService;
import com.beauty.util.CodeUtil;

/**
 * @ClassName: RoleController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年4月1日 下午4:33:33
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
@RequestMapping("/role")
public class RoleController {

	@Resource(name = "roleService")
	private IMapperService roleService;

	@Resource(name = "roleReAuthorityService")
	private IMapperService roleReAuthorityService;

	/**
	 * 
	 * @Title: selectByPrimaryKey
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param id
	 * @return
	 * @return Role
	 * @date 2015年4月1日 下午4:41:30
	 * @throws
	 */
	@RequestMapping("/query/id")
	@ResponseBody
	public Role selectByPrimaryKey(@RequestParam("id") Long id) {
		Role role = (Role) this.roleService.selectByPrimaryKey(id);
		return role;
	}

	/**
	 * 
	 * @Title: insert
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param role
	 * @return void
	 * @date 2015年4月1日 下午4:49:41
	 * @throws
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public String insert(HttpServletRequest request, Role role) {
		role.setCreater("admin");
		role.setModifer("admin");
		role.setCreateTime(new Date());
		role.setLastModifyTime(new Date());
		this.roleService.insertSelective(role);
		return CodeUtil.ADD_SUCCESS;
	}

	/**
	 * 
	 * @Title: delete
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param id
	 * @return void
	 * @date 2015年4月10日 下午11:38:48
	 * @throws
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam("id") Long id) {
		this.roleService.deleteByPrimaryKey(id);
		return CodeUtil.DELETE_SUCCESS;
	}

	/**
	 * 
	 * @Title: deletes
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param list
	 * @return void
	 * @date 2015年4月20日 下午3:42:38
	 * @throws
	 */
	@RequestMapping("/deletes")
	@ResponseBody
	public String deletes(@RequestParam("ids") String ids) {
		List<String> list = Arrays.asList(ids.split("\\,"));
		this.roleService.deleteByPrimaryKeys(list);
		return CodeUtil.DELETE_SUCCESS;
	}

	/**
	 * 
	 * @Title: update
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param role
	 * @return
	 * @return String
	 * @date 2015年4月10日 下午11:59:08
	 * @throws
	 */
	@RequestMapping("/modify")
	@ResponseBody
	public String update(Role role) {
		role.setModifer("admin");
		role.setLastModifyTime(new Date());
		this.roleService.updateByPrimaryKeySelective(role);
		return CodeUtil.EDIT_SUCCESS;
	}


	/**
	 * 
	 * @Title: selectByParams
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param role
	 * @return
	 * @return List<Role>
	 * @date 2015年4月4日 下午9:19:45
	 * @throws
	 */
	@RequestMapping("/query/page")
	@ResponseBody
	public Map<String, Object> selectByPage(Role role) {
		Map<String, Object> rets = new HashMap<String, Object>();
		int total = this.roleService.selectByPageCount(role);
		List<?> roles = this.roleService.selectByPage(role);
		rets.put("rows", roles);
		rets.put("total", total);
		return rets;
	}

	/**
	 * 
	 * @Title: selectResourceForTable 
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @author frinder_liu 
	 * @param roleReAuthority
	 * @return
	 * @return List<?>
	 * @date 2015年5月18日 下午11:25:43
	 * @throws
	 */
	@RequestMapping("/query/auth/table")
	@ResponseBody
	public List<?> selectAuthorityForTable(RoleReAuthority roleReAuthority) {
		List<?> resources = this.roleReAuthorityService.selectByPage(roleReAuthority);
		return resources;
	}

	
	/**
	 * 
	 * @Title: resetResourceForAuth 
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @author frinder_liu 
	 * @param roleReAuthority
	 * @return
	 * @return String
	 * @date 2015年5月18日 下午11:25:46
	 * @throws
	 */
	@RequestMapping("/reset/role")
	@ResponseBody
	public String resetAuthorityForRole(RoleReAuthority roleReAuthority) {
		// 删除资源
		this.roleReAuthorityService.deleteByPrimaryKeys(roleReAuthority);
		if (roleReAuthority.getInserts().size() > 0) {
			// 新增资源
			this.roleReAuthorityService.insertSelective(roleReAuthority);
		}
		return CodeUtil.RESET_SUCCESS;
	}

}
