package com.victor.h5blog.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.victor.h5blog.annotation.SystemControllerLog;
import com.victor.h5blog.constant.SystemConstant;

/**
 * 首页
 * 
 * @author Herbert
 */
@Controller
public class IndexAction extends BaseAction {

	/**
	 * 首页
	 * 
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@SystemControllerLog(description = "首页Controller请求")
	public String defalut(
			ModelMap modelMap, HttpServletRequest request) {
		return "redirect:/main/index";
	}

	/**
	 * 首页
	 * 
	 * @param pageNum
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	@SystemControllerLog(description = "首页2")
	public String home(
			ModelMap modelMap, HttpServletRequest request) {
		try {
			request.setAttribute(SystemConstant.SHOW_URL_PARAM, false);
			String url = themeService.getDefaultUrlPath();
			if ("".equals(url)) {
				return "redirect:/admin/login.htm";
			} else {
				return "redirect:" + url;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return themeService.get404();
		}
	}
	

	/**
	 * 404
	 * 
	 * @return
	 */
	@RequestMapping(value = "/404.htm", method = RequestMethod.GET)
	public String pageNotFound(ModelMap modelMap) {
		modelMap.addAttribute("g_folderId", 0);
		return themeService.get404();
	}

	/**
	 * 500
	 * 
	 * @return
	 */
	@RequestMapping(value = "/500.htm", method = RequestMethod.GET)
	public String error(ModelMap modelMap) {
		modelMap.addAttribute("g_folderId", 0);
		return themeService.get500();
	}

	/**
	 * 404
	 * 
	 * @return
	 */
	@RequestMapping(value = "/401.htm", method = RequestMethod.GET)
	public String authorityNotFound(ModelMap modelMap) {
		modelMap.addAttribute("g_folderId", 0);
		return themeService.get401();
	}
}
