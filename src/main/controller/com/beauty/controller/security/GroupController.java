/**    
 * @Title: GroupController.java  
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

import com.beauty.base.IMapperService;
import com.beauty.entity.security2.Group;
import com.beauty.util.CodeUtil;

/**
 * @ClassName: GroupController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年4月1日 下午4:33:33
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
@RequestMapping("/group")
public class GroupController {

	@Resource(name = "groupService")
	private IMapperService groupService;

	/**
	 * 
	 * @Title: selectByPrimaryKey
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param id
	 * @return
	 * @return Group
	 * @date 2015年4月1日 下午4:41:30
	 * @throws
	 */
	@RequestMapping("/query/id")
	@ResponseBody
	public Group selectByPrimaryKey(@RequestParam("id") Long id) {
		Group group = (Group) this.groupService.selectByPrimaryKey(id);
		return group;
	}

	/**
	 * 
	 * @Title: insert
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param group
	 * @return void
	 * @date 2015年4月1日 下午4:49:41
	 * @throws
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public String insert(HttpServletRequest request, Group group) {
		group.setCreater("admin");
		group.setModifer("admin");
		group.setCreateTime(new Date());
		group.setLastModifyTime(new Date());
		this.groupService.insertSelective(group);
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
		this.groupService.deleteByPrimaryKey(id);
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
		this.groupService.deleteByPrimaryKeys(list);
		return CodeUtil.DELETE_SUCCESS;
	}

	/**
	 * 
	 * @Title: update
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param group
	 * @return
	 * @return String
	 * @date 2015年4月10日 下午11:59:08
	 * @throws
	 */
	@RequestMapping("/modify")
	@ResponseBody
	public String update(Group group) {
		group.setModifer("admin");
		group.setLastModifyTime(new Date());
		this.groupService.updateByPrimaryKeySelective(group);
		return CodeUtil.EDIT_SUCCESS;
	}


	/**
	 * 
	 * @Title: selectByParams
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param group
	 * @return
	 * @return List<Group>
	 * @date 2015年4月4日 下午9:19:45
	 * @throws
	 */
	@RequestMapping("/query/page")
	@ResponseBody
	public Map<String, Object> selectByPage(Group group) {
		Map<String, Object> rets = new HashMap<String, Object>();
		int total = this.groupService.selectByPageCount(group);
		List<?> groups = this.groupService.selectByPage(group);
		rets.put("rows", groups);
		rets.put("total", total);
		return rets;
	}

}
