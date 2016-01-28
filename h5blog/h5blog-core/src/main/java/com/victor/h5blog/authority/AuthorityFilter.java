package com.victor.h5blog.authority;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.victor.h5blog.constant.SystemConstant;
import com.victor.h5blog.constant.UserConstant;
import com.victor.h5blog.utils.LegooUtil;

public class AuthorityFilter implements Filter {
	private static Logger logger = Logger.getLogger(AuthorityFilter.class);

	public static final String URL_PATH_LOGON = "/login.htm";
	public static final String URL_PATH_INDEX = "/index.htm";
	public static final String URL_PATH_CAPTCHA = "/ccba/captcha.htm";
	public static final String URL_PATH_MESSAGE = "/message.htm";
	private PermissionChecker checker;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		try {
			checker = AuthorityHandler.instantiationChecker(filterConfig);
		} catch (Exception e) {
			logger.error("instantiation permissionChecker which config int the AuthorityFilter init-param  error.");
		}
		if (checker != null) {
			checker.init();
		} else {
			checker = new LegooChecker();
			checker.init();
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		logger.info("doFilter AuthorityFilter begin...");

		Map<String, Object> map = getUrlFilterProperties(SystemConstant.URL_FILTER);

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String contextPath = req.getContextPath();
		String currentPath = req.getRequestURI();
		HttpSession session = req.getSession();
		// background pass
		if (currentPath.startsWith(contextPath + "/admin")
				|| currentPath.startsWith(contextPath + "/manage")) {
			filterChain.doFilter(request, response);
		} else {
			boolean flag = false;
			for (String key : map.keySet()) {
				if (currentPath.equals(contextPath + map.get(key))) {
					flag = true;
					break;
				}
			}
			if (flag) {
				filterChain.doFilter(request, response);
			} else {
				session.setAttribute(UserConstant.MESSAGE, "您还未登录，请您先登录");
				session.setAttribute(UserConstant.CURRENT_URL, "login.htm");
				// weather user is login or not
				if (session.getAttribute(SystemConstant.FORCE_USER) == null) {
					res.sendRedirect(contextPath + URL_PATH_MESSAGE);
				} else {
					// check authority
					if (checker.check(req, res)) {
						filterChain.doFilter(request, response);
					} else {
						session.setAttribute(UserConstant.MESSAGE, "您无权访问此页面");
						session.setAttribute(UserConstant.CURRENT_URL,
								"active.htm");
						res.sendRedirect(contextPath + URL_PATH_MESSAGE);
					}
				}
			}
		}
		logger.info("doFilter AuthorityFilter end...");
	}

	@Override
	public void destroy() {
		checker.destroy();
		logger.info("destroy AuthenFilter...");
	}

	private Map<String, Object> getUrlFilterProperties(String fileName) {
		Properties props = new Properties();
		InputStream in = LegooUtil.class.getResourceAsStream("/" + fileName
				+ ".properties");
		try {
			props.load(in);
			in.close();
		} catch (IOException e) {
			logger.error("Load Property File Error" + e.getMessage(), e);
		}
		Map<String, Object> map = new HashMap<String, Object>((Map) props);
		return map;
	}

}
