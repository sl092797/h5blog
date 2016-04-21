package com.victor.h5blog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.victor.h5blog.constant.SystemConstant;
import com.victor.h5blog.entity.vo.UserVo;

/**
 * 
 * manage filter
 * 
 * @author Herbert
 * 
 */
public class ManageFilter implements Filter {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		UserVo userVo = (UserVo) request.getSession().getAttribute(
				SystemConstant.SESSION_ADMIN);
		if (userVo == null) {
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path;
			response.sendRedirect(basePath + "/login.htm");
		} else {
			chain.doFilter(request, response);
		}
	}

	public void destroy() {

	}

}
