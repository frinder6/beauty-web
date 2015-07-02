/**    
 * @Title: AjaxLoginUrlAuthenticationEntryPoint.java  
 * @Package org.springframework.security.web.authentication  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年5月24日 下午9:09:31 
 * @version V1.0   
 */
package com.beauty.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import com.beauty.util.HttpUtil;

/**
 * @ClassName: AjaxLoginUrlAuthenticationEntryPoint
 * @Description: TODO(重写认证切入点：添加ajax方式处理)
 * @author frinder_liu
 * @date 2015年5月24日 下午9:09:31
 * 
 */
public class AjaxLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
	
	private final Logger logger = Logger.getLogger(getClass());

	@SuppressWarnings("deprecation")
	public AjaxLoginUrlAuthenticationEntryPoint() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param loginFormUrl
	 */
	public AjaxLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
		super(loginFormUrl);
	}

	private String ajaxInvalidSessionUrl;

	/**
	 * @param ajaxInvalidSessionUrl
	 *            the ajaxInvalidSessionUrl to set
	 */
	public void setAjaxInvalidSessionUrl(String ajaxInvalidSessionUrl) {
		this.ajaxInvalidSessionUrl = ajaxInvalidSessionUrl;
	}

	@Override
	protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
		logger.info("AjaxLoginUrlAuthenticationEntryPoint.determineUrlToUseForThisRequest...begin!");
		if (HttpUtil.isAjaxRequest(request)) {
			logger.info("AjaxLoginUrlAuthenticationEntryPoint.determineUrlToUseForThisRequest...this is an ajax request!");
			return ajaxInvalidSessionUrl;
		}
		logger.info("AjaxLoginUrlAuthenticationEntryPoint.determineUrlToUseForThisRequest...this is not an ajax request!");
		return super.determineUrlToUseForThisRequest(request, response, exception);
	}

	

}
