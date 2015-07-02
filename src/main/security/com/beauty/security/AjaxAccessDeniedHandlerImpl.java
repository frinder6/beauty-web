/**    
 * @Title: AjaxAccessDeniedHandlerImpl.java  
 * @Package com.mvc.security  
 * @Description: TODO(用一句话描述该文件做什么)  
 * @author frinder_liu    
 * @date 2015年5月27日 下午9:21:33 
 * @version V1.0   
 */
package com.beauty.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

import com.beauty.util.HttpUtil;

/**
 * @ClassName: AjaxAccessDeniedHandlerImpl
 * @Description: TODO(重写权限认证失败处理逻辑，添加ajax处理)
 * @author frinder_liu
 * @date 2015年5月27日 下午9:21:33
 * 
 */
public class AjaxAccessDeniedHandlerImpl extends AccessDeniedHandlerImpl {

	private final Logger logger = Logger.getLogger(getClass());

	private String errorPage;

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		logger.info("AjaxAccessDeniedHandlerImpl.handle....................... begin !");
		boolean isAjax = HttpUtil.isAjaxRequest(request);
		if (isAjax) {
			logger.info("AjaxAccessDeniedHandlerImpl.handle....................... is an ajax request !");
			PrintWriter out = response.getWriter();
			out.print("no right...");
			out.flush();
			out.close();
		} else {
			logger.info("AjaxAccessDeniedHandlerImpl.handle....................... is not an ajax request !");
			if (!response.isCommitted()) {
				if (errorPage != null) {
					logger.info("AjaxAccessDeniedHandlerImpl.handle....................... error page : [" + errorPage + "] !");
					// Put exception into request scope (perhaps of use to a
					// view)
					request.setAttribute(WebAttributes.ACCESS_DENIED_403, accessDeniedException);

					// Set the 403 status code.
					response.setStatus(HttpServletResponse.SC_FORBIDDEN);

					// forward to error page.
					RequestDispatcher dispatcher = request.getRequestDispatcher(errorPage);
					dispatcher.forward(request, response);
				} else {
					logger.info("AjaxAccessDeniedHandlerImpl.handle....................... no config default error page !");
					response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());
				}
			}
		}
		logger.info("AjaxAccessDeniedHandlerImpl.handle....................... begin !");
	}

	public void setErrorPage(String errorPage) {
		if ((errorPage != null) && !errorPage.startsWith("/")) {
			throw new IllegalArgumentException("errorPage must begin with '/'");
		}

		this.errorPage = errorPage;
	}
}
