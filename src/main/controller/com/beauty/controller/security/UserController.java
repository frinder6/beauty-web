/**    
 * @Title: UserController.java  
 * @Package com.mvc.controller  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年4月1日 下午4:33:33 
 * @version V1.0   
 */
package com.beauty.controller.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauty.controller.security.util.ControllerUtil;
import com.beauty.entity.security2.User;
import com.beauty.entity.security2.UserReRole;
import com.beauty.redis.RedisService;
import com.beauty.security.UserInfo;
import com.beauty.service.base.IMapperService;
import com.beauty.util.CodeUtil;

/**
 * @ClassName: UserController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年4月1日 下午4:33:33
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name = "userService")
	private IMapperService userService;

	@Resource(name = "userReRoleService")
	private IMapperService userReRoleService;

	@Resource(name = "redisService")
	private RedisService redisService;

	/**
	 * 
	 * @Title: getLoginUser
	 * @Description: TODO(获取当前登陆用户)
	 * @author frinder_liu
	 * @return
	 * @return UserInfo
	 * @date 2015年5月28日 下午10:28:55
	 * @throws
	 */
	@RequestMapping("/log/user")
	@ResponseBody
	public UserInfo getLoginUser() {
		return ControllerUtil.getLoginUser();
	}

	/**
	 * 
	 * @Title: getCurrUserAuths
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @return
	 * @return List<?>
	 * @date 2015年5月28日 下午10:34:41
	 * @throws
	 */
	@RequestMapping("/log/user/auths")
	@ResponseBody
	public List<?> getCurrUserAuths() {
		List<String> list = new ArrayList<String>();
		if (null == ControllerUtil.getLoginUser()) {
			return list;
		}
		Collection<GrantedAuthority> authorities = ControllerUtil.getLoginUser().getAuthorities();
		for (GrantedAuthority ga : authorities) {
			list.add(ga.getAuthority());
		}
		return list;
	}

	/**
	 * 
	 * @Title: selectByPrimaryKey
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param id
	 * @return
	 * @return User
	 * @date 2015年4月1日 下午4:41:30
	 * @throws
	 */
	@RequestMapping("/query/id")
	@ResponseBody
	public User selectByPrimaryKey(@RequestParam("id") Long id) {
		User user = (User) this.userService.selectByPrimaryKey(id);
		return user;
	}

	/**
	 * 
	 * @Title: insert
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param user
	 * @return void
	 * @date 2015年4月1日 下午4:49:41
	 * @throws
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public String insert(HttpServletRequest request, User user) {
		user.setCreater("admin");
		user.setModifer("admin");
		user.setCreateTime(new Date());
		user.setLastModifyTime(new Date());
		this.userService.insertSelective(user);
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
		this.userService.deleteByPrimaryKey(id);
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
		this.userService.deleteByPrimaryKeys(list);
		return CodeUtil.DELETE_SUCCESS;
	}

	/**
	 * 
	 * @Title: update
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param user
	 * @return
	 * @return String
	 * @date 2015年4月10日 下午11:59:08
	 * @throws
	 */
	@RequestMapping("/modify")
	@ResponseBody
	public String update(User user) {
		user.setModifer("admin");
		user.setLastModifyTime(new Date());
		this.userService.updateByPrimaryKeySelective(user);
		return CodeUtil.EDIT_SUCCESS;
	}

	/**
	 * 
	 * @Title: selectByParams
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param user
	 * @return
	 * @return List<User>
	 * @date 2015年4月4日 下午9:19:45
	 * @throws
	 */
	@RequestMapping("/query/page")
	@ResponseBody
	public Map<String, Object> selectByPage(User user) {
		Map<String, Object> rets = new HashMap<String, Object>();
		int total = this.userService.selectByPageCount(user);
		List<?> users = this.userService.selectByPage(user);
		rets.put("rows", users);
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
	@RequestMapping("/query/role/table")
	@ResponseBody
	public List<?> selectRoleForTable(UserReRole userReRole) {
		List<?> roles = this.userReRoleService.selectByPage(userReRole);
		return roles;
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
	@RequestMapping("/reset/user")
	@ResponseBody
	public String resetRoleForUser(UserReRole userReRole) {
		// 删除资源
		this.userReRoleService.deleteByPrimaryKeys(userReRole);
		if (userReRole.getInserts().size() > 0) {
			// 新增资源
			this.userReRoleService.insertSelective(userReRole);
		}
		return CodeUtil.RESET_SUCCESS;
	}

}
