/**    
 * @Title: CommonController.java  
 * @Package com.mvc.controller  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年4月4日 下午12:52:15 
 * @version V1.0   
 */
package com.beauty.controller.security;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.beauty.entity.security.BeautyAuthorityResource;
import com.beauty.redis.RedisValueService;
import com.beauty.service.base.IMapperService;
import com.beauty.service.base.IService;
import com.beauty.util.CodeUtil;

/**
 * @ClassName: CommonController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年4月4日 下午12:52:15
 * 
 */
@SuppressWarnings({ "rawtypes" })
@RemoteProxy(name = "common")
@Controller
@RequestMapping("/common")
public class CommonController {

	@Resource(name = "userService")
	private IMapperService userService;

	@Resource(name = "myUserDetailsService")
	private UserDetailsService myUserDetailsService;

	@Resource(name = "redisValueService")
	private RedisValueService redisValueService;

	@Resource(name = "beautyAuthorityResourceService")
	private IService<BeautyAuthorityResource> beautyAuthorityResourceService;

	/**
	 * 
	 * @Title: redirect
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param redirect
	 * @param type
	 * @return
	 * @return String
	 * @date 2015年4月8日 下午10:49:20
	 * @throws
	 */
	@RequestMapping("/redirect/{redirect}/{type}")
	public String redirect(@PathVariable("redirect") String redirect, @PathVariable("type") String type) {
		redirect = redirect.replaceAll("\\.", "/");
		String ret = "redirect:/%s.%s";
		return String.format(ret, redirect, type);
	}

	/**
	 * 
	 * @Title: forward
	 * @Description: TODO(跳转方法)
	 * @author frinder_liu
	 * @param forward
	 * @return
	 * @return ModelAndView
	 * @date 2015年4月4日 下午1:25:47
	 * @throws
	 */
	@RequestMapping("/forward/{forward}")
	public ModelAndView forward(HttpServletRequest request, @PathVariable("forward") String forward) {
		forward = forward.replaceAll("\\.", "/");
		ModelAndView mv = new ModelAndView(forward);
		String param = request.getParameter("param");
		mv.addObject("param", param);
		return mv;
	}

	/**
	 * 
	 * @Title: flush
	 * @Description: TODO(清空缓存)
	 * @author frinder_liu
	 * @return
	 * @return String
	 * @date 2015年6月7日 下午8:43:40
	 * @throws
	 */
	@RequestMapping("/flush")
	@ResponseBody
	public String flush() {
		this.redisValueService.clear();
		return CodeUtil.SUCCESS;
	}

	/**
	 * 
	 * @Title: error
	 * @Description: TODO(获取错误信息)
	 * @author frinder_liu
	 * @param session
	 * @return
	 * @return String
	 * @date 2015年6月9日 下午10:33:57
	 * @throws
	 */
	@RemoteMethod
	public String error(HttpSession session) {
		Object obj = session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
		if (null != obj) {
			AuthenticationException exception = (AuthenticationException) obj;
			return exception.getMessage();
		}
		return null;
	}

	@RequestMapping(value = "/hibernate")
	public String test() {
		BeautyAuthorityResource arg = new BeautyAuthorityResource(1L, 2L);
		// this.beautyAuthorityResourceService.persist(arg);
		arg.setId(54L);
		// this.beautyAuthorityResourceService.merge(arg);
		//BeautyAuthorityResource arg = this.beautyAuthorityResourceService.findById(BeautyAuthorityResource.class, 54L);
		//System.out.println(JSON.toJSONString(arg));
		this.beautyAuthorityResourceService.remove(arg);
		return CodeUtil.SUCCESS;
	}

}
