/**    
 * @Title: ResourceController.java  
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

import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauty.controller.security.util.ControllerUtil;
import com.beauty.entity.security2.Resource;
import com.beauty.service.base.IMapperService;
import com.beauty.service.base.ISecurityService;
import com.beauty.service.security.util.MapperUtils;
import com.beauty.util.CodeUtil;

/**
 * @ClassName: ResourceController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年4月1日 下午4:33:33
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
@RequestMapping("/resource")
@RemoteProxy
public class ResourceController {

	@javax.annotation.Resource(name = "resourceService")
	private IMapperService resourceService;

	@javax.annotation.Resource(name = "securityService")
	private ISecurityService securityService;

	/**
	 * 
	 * @Title: selectByPrimaryKey
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param id
	 * @return
	 * @return Resource
	 * @date 2015年4月1日 下午4:41:30
	 * @throws
	 */
	@RequestMapping("/query/id")
	@ResponseBody
	public Resource selectByPrimaryKey(@RequestParam("id") Long id) {
		Resource resource = (Resource) this.resourceService.selectByPrimaryKey(id);
		return resource;
	}

	/**
	 * 
	 * @Title: loadMenu
	 * @Description: TODO(加载菜单)
	 * @author frinder_liu
	 * @param resource
	 * @return
	 * @return String
	 * @date 2015年4月17日 下午5:31:47
	 * @throws
	 */
	@RequestMapping(value = "/load/menu", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<?> loadMenu(Resource resource) {
		resource.setUsercode(ControllerUtil.getLoginUserCode());
		List<?> combos = this.securityService.queryMenus(resource);
		return combos;
	}

	/**
	 * 
	 * @Title: insert
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param resource
	 * @return void
	 * @date 2015年4月1日 下午4:49:41
	 * @throws
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public String insert(HttpServletRequest request, Resource resource) {
		resource.setCreater("admin");
		resource.setModifer("admin");
		resource.setCreateTime(new Date());
		resource.setLastModifyTime(new Date());
		this.resourceService.insertSelective(resource);
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
		this.resourceService.deleteByPrimaryKey(id);
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
		this.resourceService.deleteByPrimaryKeys(list);
		return CodeUtil.DELETE_SUCCESS;
	}

	/**
	 * 
	 * @Title: update
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param resource
	 * @return
	 * @return String
	 * @date 2015年4月10日 下午11:59:08
	 * @throws
	 */
	@RequestMapping("/modify")
	@ResponseBody
	public String update(Resource resource) {
		resource.setModifer("admin");
		resource.setLastModifyTime(new Date());
		this.resourceService.updateByPrimaryKeySelective(resource);
		return CodeUtil.EDIT_SUCCESS;
	}

	/**
	 * 
	 * @Title: selectByParams
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param resource
	 * @return
	 * @return List<Resource>
	 * @date 2015年4月4日 下午9:19:45
	 * @throws
	 */
	@RequestMapping("/query/page")
	@ResponseBody
	public Map<String, Object> selectByPage(Resource resource) {
		Map<String, Object> rets = new HashMap<String, Object>();
		int total = this.resourceService.selectByPageCount(resource);
		List<?> resources = this.resourceService.selectByPage(resource);
		rets.put("rows", resources);
		rets.put("total", total);
		return rets;
	}

	/**
	 * 
	 * @Title: selectForCombo
	 * @Description: TODO(查询菜单下拉框)
	 * @author frinder_liu
	 * @param resource
	 * @return
	 * @return String
	 * @date 2015年4月20日 下午6:23:18
	 * @throws
	 */
	@RequestMapping(value = "/load/combo", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<?> selectForCombo(Resource resource) {
		resource.setUsercode(ControllerUtil.getLoginUserCode());
		return this.securityService.queryMenuCombo(resource);
	}

	/**
	 * 
	 * @Title: queryNoconfigAuthResources
	 * @Description: TODO(查询未配置权限的资源)
	 * @author frinder_liu
	 * @return
	 * @return List<?>
	 * @date 2015年5月26日 下午10:58:31
	 * @throws
	 */
	@RequestMapping(value = "/noconfig/resources", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<?> queryNoconfigAuthResources() {
		return this.resourceService.query(MapperUtils._SECURITY_QUERY_UN_CONF_AUTH_RESOURCES);
	}

}
