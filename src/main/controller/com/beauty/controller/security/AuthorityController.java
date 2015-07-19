/**    
 * @Title: AuthorityController.java  
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.beauty.entity.security2.Authority;
import com.beauty.entity.security2.AuthorityReResource;
import com.beauty.service.base.IMapperService;
import com.beauty.util.CodeUtil;

/**
 * @ClassName: AuthorityController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年4月1日 下午4:33:33
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
@RequestMapping("/authority")
public class AuthorityController {

	@Resource(name = "authorityService")
	private IMapperService authorityService;

	@Resource(name = "authorityReResourceService")
	private IMapperService authorityReResourceService;

	/**
	 * 
	 * @Title: selectById
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param id
	 * @return
	 * @return ModelAndView
	 * @date 2015年4月26日 下午7:52:49
	 * @throws
	 */
	@RequestMapping("/query/{id}")
	public ModelAndView selectById(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("htmls/iframe-authorities-manager");
		Authority authority = (Authority) this.authorityService.selectByPrimaryKey(id);
		mv.addObject("auth", authority);
		return mv;
	}

	/**
	 * 
	 * @Title: selectByPrimaryKey
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param id
	 * @return
	 * @return Authority
	 * @date 2015年4月1日 下午4:41:30
	 * @throws
	 */
	@RequestMapping("/query/id")
	@ResponseBody
	public Authority selectByPrimaryKey(@RequestParam("id") Long id) {
		Authority authority = (Authority) this.authorityService.selectByPrimaryKey(id);
		return authority;
	}

	/**
	 * 
	 * @Title: insert
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param authority
	 * @return void
	 * @date 2015年4月1日 下午4:49:41
	 * @throws
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public String insert(HttpServletRequest request, Authority authority) {
		authority.setCreater("admin");
		authority.setModifer("admin");
		authority.setCreateTime(new Date());
		authority.setLastModifyTime(new Date());
		this.authorityService.insertSelective(authority);
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
		this.authorityService.deleteByPrimaryKey(id);
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
		this.authorityService.deleteByPrimaryKeys(list);
		return CodeUtil.DELETE_SUCCESS;
	}

	/**
	 * 
	 * @Title: update
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param authority
	 * @return
	 * @return String
	 * @date 2015年4月10日 下午11:59:08
	 * @throws
	 */
	@RequestMapping("/modify")
	@ResponseBody
	public String update(Authority authority) {
		authority.setModifer("admin");
		authority.setLastModifyTime(new Date());
		this.authorityService.updateByPrimaryKeySelective(authority);
		return CodeUtil.EDIT_SUCCESS;
	}


	/**
	 * 
	 * @Title: selectByParams
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param authority
	 * @return
	 * @return List<Authority>
	 * @date 2015年4月4日 下午9:19:45
	 * @throws
	 */
	@RequestMapping("/query/page")
	@ResponseBody
	public Map<String, Object> selectByPage(Authority authority) {
		Map<String, Object> rets = new HashMap<String, Object>();
		int total = this.authorityService.selectByPageCount(authority);
		List<?> resources = this.authorityService.selectByPage(authority);
		rets.put("rows", resources);
		rets.put("total", total);
		return rets;
	}

	/**
	 * 
	 * @Title: selectResourceByPage
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param authorityid
	 * @param _SELECT_KEY
	 * @return
	 * @return Map<String,Object>
	 * @date 2015年5月14日 下午10:20:45
	 * @throws
	 */
	@RequestMapping("/query/res/page")
	@ResponseBody
	public Map<String, Object> selectResourceByPage(AuthorityReResource authorityReResource) {
		Map<String, Object> rets = new HashMap<String, Object>();
		int total = this.authorityReResourceService.selectByPageCount(authorityReResource);
		List<?> resources = this.authorityReResourceService.selectByPage(authorityReResource);
		rets.put("rows", resources);
		rets.put("total", total);
		return rets;
	}

	/**
	 * 
	 * @Title: selectResourceForTable
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param authorityReResource
	 * @return
	 * @return List<?>
	 * @date 2015年5月14日 下午10:55:11
	 * @throws
	 */
	@RequestMapping("/query/res/table")
	@ResponseBody
	public List<?> selectResourceForTable(AuthorityReResource authorityReResource) {
		List<?> resources = this.authorityReResourceService.selectByPage(authorityReResource);
		return resources;
	}

	/**
	 * 
	 * @Title: resetResourceForAuth
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param authorityReResource
	 * @return
	 * @return String
	 * @date 2015年5月16日 上午11:21:31
	 * @throws
	 */
	@RequestMapping("/reset/auth")
	@ResponseBody
	public String resetResourceForAuth(AuthorityReResource authorityReResource) {
		// 删除资源
		this.authorityReResourceService.deleteByPrimaryKeys(authorityReResource);
		if (authorityReResource.getInserts().size() > 0) {
			// 新增资源
			this.authorityReResourceService.insertSelective(authorityReResource);
		}
		return CodeUtil.RESET_SUCCESS;
	}

}
