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
		Object user = request.getSession().getAttribute(SystemConstant.FORCE_USER);
		// system config param
		String basePath = HttpUtils.getBasePath(request);
		modelAndView.addObject("BASE_PATH", basePath);
		modelAndView.addObject("CCB_BASE_PATH", basePath
				+ "/static/template/ccb");
		modelAndView.addObject("UPLOAD_BASE_PATH", basePath + "/upload");
		modelAndView.addObject("PAGE_TPL_BASE_PATH", basePath
				+ "/static/pagetpl");
		modelAndView
				.addObject(
						"TEMPLATE_BASE_PATH",
						basePath
								+ "/static/template/"
								+ configService
										.getStringByKey(ConfigConstant.SHISHUO_TEMPLATE));
		modelAndView.addObject("shishuo_seo_title",
				configService.getStringByKey("shishuo_seo_title"));
		modelAndView.addObject("shishuo_seo_description",
				configService.getStringByKey("shishuo_seo_description"));
		MDC.put("ip", HttpUtils.getIp(request));
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
