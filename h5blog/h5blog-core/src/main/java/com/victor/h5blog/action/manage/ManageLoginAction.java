package com.victor.h5blog.action.manage;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.victor.h5blog.constant.SystemConstant;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.entity.vo.UserVo;
import com.victor.h5blog.service.LoginService;

/**
 * login action
 * 
 * @author shengli
 * @date 2015-12-16
 */

@Controller
@RequestMapping("/")
public class ManageLoginAction extends ManageBaseAction {

	@Autowired
	private LoginService loginService;


	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String login(HttpServletRequest request, ModelMap modelMap) {
		return "/manage/login";
	}

	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public String adminLogout(HttpServletRequest request, ModelMap modelMap) {
		request.getSession().removeAttribute(SystemConstant.SESSION_ADMIN);
		return "/manage/login";
	}

	/**
	 * login
	 * 
	 * @param name
	 * @param password
	 * @param captcha
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login.json", method = RequestMethod.POST)
	public JsonVo<String> adminLogin(@RequestParam(value = "name") String username,
			@RequestParam(value = "password") String password,
			HttpServletRequest request, ModelMap modelMap) {
		JsonVo<String> json = new JsonVo<String>();
		try {
			if (StringUtils.isBlank(password)) {
				json.getErrors().put("password", "密码不能为空");
			} else if (password.length() < 6 && password.length() > 30) {
				json.getErrors().put("password", "密码最少6个字符，最多30个字符");
			}
			json.check();
			UserVo userVo = new UserVo();
			userVo.setUsername(username);
			userVo.setPassword(password);
			loginService.login(request, userVo);
		} catch (Exception e) {
			json.setResult(false);
			json.getErrors().put("password", "用户名或密码错误");
			logger.error(e.getMessage());
		}
		return json;
	}

}
