package com.victor.h5blog.action.front;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.victor.h5blog.annotation.SystemControllerLog;

@Controller
@RequestMapping("/main")
public class MainAction {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@SystemControllerLog(description = "进入首页")
	public String index(
			ModelMap modelMap, HttpServletRequest request) {
		return "page/index";
	}
	
	@RequestMapping(value = "/photos", method = RequestMethod.GET)
	@SystemControllerLog(description = "进入相册")
	public String about(
			ModelMap modelMap, HttpServletRequest request) {
		return "page/photos";
	}
	
	@RequestMapping(value = "/videos", method = RequestMethod.GET)
	@SystemControllerLog(description = "进入视频")
	public String employeers(
			ModelMap modelMap, HttpServletRequest request) {
		return "page/videos";
	}
	
	@RequestMapping(value = "/blogs", method = RequestMethod.GET)
	@SystemControllerLog(description = "进入文章")
	public String blog(
			ModelMap modelMap, HttpServletRequest request) {
		return "page/blogs";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	@SystemControllerLog(description = "进入contact")
	public String contact(
			ModelMap modelMap, HttpServletRequest request) {
		return "page/contact";
	}
	
}
