/**    
 * @Title: ResourceControllerUtil.java  
 * @Package com.mvc.controller.util  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年4月18日 下午1:31:26 
 * @version V1.0   
 */
package com.beauty.controller.security.util;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;

import com.beauty.entity.security2.Resource;
import com.beauty.security.UserInfo;

/**
 * @ClassName: ResourceControllerUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author frinder_liu
 * @date 2015年4月18日 下午1:31:26
 * 
 */
public class ControllerUtil {

	/**
	 * 
	 * @Title: getLoginUser
	 * @Description: TODO(获取当前登陆用户)
	 * @author frinder_liu
	 * @return
	 * @return UserInfo
	 * @date 2015年5月28日 下午10:32:25
	 * @throws
	 */
	public static UserInfo getLoginUser() {
		try {
			UserInfo user = (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 
	 * @Title: getLoginUserCode
	 * @Description: TODO(获取登陆用户名)
	 * @author frinder_liu
	 * @return
	 * @return String
	 * @date 2015年5月28日 下午10:33:47
	 * @throws
	 */
	public static String getLoginUserCode() {
		return getLoginUser() == null ? null : getLoginUser().getUsername();
	}

	/**
	 * 
	 * @Title: createMenu
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param resources
	 * @return
	 * @return StringBuffer
	 * @date 2015年4月18日 下午1:30:25
	 * @throws
	 */
	public static String createMenu(List<?> resources) {
		StringBuffer menus = new StringBuffer();
		String nav = "<h5 class=\"sidebartitle\">%s</h5><ul class=\"nav nav-pills nav-stacked nav-bracket\">";
		String l1 = "<li class=\"nav-parent\"><a href=\"#\"><i class=\"fa fa-edit\"></i><span>%s</span></a><ul class=\"children\">";
		String l2 = "<li><a href=\"#\" rel=\"%s\"><i class=\"fa fa-caret-right\"></i> %s</a></li>";
		List<Resource> plist, slist;
		for (Object object : resources) {
			// 是否有第一层级
			Resource resource = (Resource) object;
			// 导航
			menus.append(String.format(nav, resource.getResourceName()));
			// 第一节点
			plist = resource.getChildren();
			for (Resource pres : plist) {
				menus.append(String.format(l1, pres.getResourceName()));
				// 第二节点
				slist = pres.getChildren();
				for (Resource sres : slist) {
					menus.append(String.format(l2, sres.getResourceValue(), sres.getResourceName()));
				}
				menus.append("</ul></li>");
			}
			menus.append("</ul>");
		}
		return menus.toString();
	}

	/**
	 * 
	 * @Title: createSelect
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param resources
	 * @return
	 * @return StringBuffer
	 * @date 2015年4月12日 下午9:01:11
	 * @throws
	 */
	@Deprecated
	public static String createCombo(List<?> resources) {
		StringBuffer opts = new StringBuffer();
		String goption = "<option value='%s'>%s</option>";
		String option = "<option value='%s'>&nbsp;&nbsp;&nbsp;%s</option>";
		String soption = "<option value='%s' disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;%s</option>";
		int level;
		for (Object object : resources) {
			// 是否有第一层级
			Resource resource = (Resource) object;
			level = resource.getLevel();
			if (!resource.getChildren().isEmpty() || level != 3) {
				if (level == 1) {
					opts.append(String.format(goption, resource.getId(), resource.getResourceName()));
				} else {
					opts.append(String.format(option, resource.getId(), resource.getResourceName()));
				}
				// 递归调用
				opts.append(createCombo(resource.getChildren()));
			} else {
				opts.append(String.format(soption, resource.getId(), resource.getResourceName()));
			}
		}
		return opts.toString();
	}

	/**
	 * 
	 * @Title: createComboNew
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param resources
	 * @return
	 * @return String
	 * @date 2015年4月25日 下午9:04:34
	 * @throws
	 */
	public static String createComboNew(List<?> resources) {
		StringBuffer opts = new StringBuffer();
		String goption = "<option value='%s' level='%s'>%s</option>";
		String option = "<option value='%s' level='%s'>&nbsp;&nbsp;&nbsp;%s</option>";
		String soption = "<option value='%s' level='%s' disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;%s</option>";
		List<Resource> plist, slist;
		for (Object object : resources) {
			Resource resource = (Resource) object;
			// 第一层级
			opts.append(String.format(goption, resource.getId(), resource.getLevel(), resource.getResourceName()));
			// 第二层级
			plist = resource.getChildren();
			for (Resource pres : plist) {
				opts.append(String.format(option, pres.getId(), pres.getLevel(), pres.getResourceName()));
				// 第三层级
				slist = pres.getChildren();
				for (Resource sres : slist) {
					opts.append(String.format(soption, sres.getId(), sres.getLevel(), sres.getResourceName()));
				}
			}
		}
		return opts.toString();
	}

	/**
	 * 
	 * @Title: createCombo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author frinder_liu
	 * @param prefix
	 * @param resources
	 * @param suffix
	 * @return
	 * @return String
	 * @date 2015年4月21日 上午10:37:54
	 * @throws
	 */
	public static String createCombo(String prefix, List<?> resources, String suffix) {
		StringBuffer combo = new StringBuffer();
		combo.append(prefix);
		combo.append(createComboNew(resources));
		combo.append(suffix);
		return combo.toString();
	}

}
