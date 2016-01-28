package com.victor.h5blog.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.victor.h5blog.annotation.SystemControllerLog;
import com.victor.h5blog.constant.SystemConstant;
import com.victor.h5blog.exception.PageNotFoundExcetption;
import com.victor.h5blog.service.RenderPageService;

@Controller
@RequestMapping("/")
public class PageAction {

	@Autowired
	private RenderPageService renderPageService;

	/**
	 * 前台页面访问请求-二级请求
	 * 
	 * @param parentKey
	 * @param pageKey
	 * @param modelMap
	 * @return
	 * @throws IOException
	 * @throws PageNotFoundExcetption
	 */
	@SystemControllerLog(description = "页面访问")
	@RequestMapping(value = "/{parentKey}/{pageKey}.htm", method = RequestMethod.GET)
	public String toLevl2Page(@PathVariable String parentKey,
			@PathVariable String pageKey, ModelMap modelMap,
			HttpServletRequest request) throws IOException,
			PageNotFoundExcetption {
		String url = "/" + parentKey + "/" + pageKey
				+ SystemConstant.PAGE_SUFFIX;
		modelMap.put("pageName", pageKey);
		modelMap.put("url", url);
		request.getParameterMap();
		return renderPageService.combinePage(url, modelMap);
	}

	/**
	 * 前台页面访问请求 一级请求
	 * 
	 * @param pageKey
	 * @param modelMap
	 * @return
	 * @throws IOException
	 * @throws PageNotFoundExcetption
	 */
	@SystemControllerLog(description = "页面访问")
	@RequestMapping(value = "/{pageKey}.htm", method = RequestMethod.GET)
	public String toPage(@PathVariable String pageKey, ModelMap modelMap,
			HttpServletRequest request) throws IOException,
			PageNotFoundExcetption {
		String url = "/" + pageKey + SystemConstant.PAGE_SUFFIX;
		modelMap.put("pageName", pageKey);
		modelMap.put("url", url);
		return renderPageService.combinePage(url, modelMap);
	}
}
