package com.victor.h5blog.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.victor.h5blog.constant.ConfigConstant;
import com.victor.h5blog.constant.SystemConstant;
import com.victor.h5blog.service.ConfigService;
import com.victor.h5blog.util.HttpUtils;

/**
 * @author Herbert
 * 
 */
@Component
public class GlobalInterceptor implements HandlerInterceptor {

	@Autowired
	private ConfigService configService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (null == modelAndView) {
			return;
		}
		
		Object showParam = request.getAttribute(SystemConstant.SHOW_URL_PARAM);
		if(showParam != null && showParam.equals(false)){
			return;
		}
		// system config param
		String basePath = HttpUtils.getBasePath(request);
		modelAndView.addObject("BASE_PATH", basePath);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
