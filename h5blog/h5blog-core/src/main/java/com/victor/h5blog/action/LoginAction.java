package com.victor.h5blog.action;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.victor.h5blog.LoginSelector;
import com.victor.h5blog.constant.SystemConstant;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.entity.vo.UserVo;
import com.victor.h5blog.service.inter.AuthorityService;
import com.victor.h5blog.service.inter.LoginService;
import com.victor.h5blog.service.inter.RoleService;
import com.victor.h5blog.util.HttpUtils;

/**
 * login action
 * 
 * @author tangfan
 * @date 2015-12-16
 */

@Controller
@RequestMapping("/admin")
public class LoginAction extends BaseAction {

	/**
	 * Kaptcha identifying code
	 */
	@Autowired
	private DefaultKaptcha captchaProducer;

	@Autowired
	private RoleService roleService;
	@Autowired
	private AuthorityService authorityService;

	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String login(HttpServletRequest request, ModelMap modelMap) {
		return "/manage/login";
	}

	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public String adminLogout(HttpServletRequest request, ModelMap modelMap) {
		request.getSession().removeAttribute(SystemConstant.SESSION_ADMIN);
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:" + HttpUtils.getBasePath(request);
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
	public JsonVo<String> adminLogin(@RequestParam(value = "name") String name,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "captcha") String captcha,
			HttpServletRequest request, ModelMap modelMap) {
		JsonVo<String> json = new JsonVo<String>();
		try {
			String kaptcha = (String) request.getSession().getAttribute(
					com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			if (StringUtils.isBlank(password)) {
				json.getErrors().put("password", "密码不能为空");
			} else if (password.length() < 6 && password.length() > 30) {
				json.getErrors().put("password", "密码最少6个字符，最多30个字符");
			}
			// check identifying code
//			if (StringUtils.isNotBlank(kaptcha)
//					&& kaptcha.equalsIgnoreCase(captcha)) {
//			} else {
//				json.getErrors().put("captcha", "验证码错误");
//			}
			json.check();
			UserVo userVo = new UserVo();
			userVo.setLoginName(name);
			userVo.setLoginPwd(password);
			LoginService loginService = LoginSelector.select(request,
					"DbLogin");
			loginService.login(request, userVo);
		} catch (Exception e) {
			// exception，reset identifying code
			request.getSession().removeAttribute(
					com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
			json.setResult(false);
			json.getErrors().put("password", "邮箱或密码错误");
			json.setMsg("change_captcha");
			logger.error(e.getMessage());
		}
		return json;
	}

	/**
	 * make identifying code
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "captcha.htm", method = RequestMethod.GET)
	public void captcha(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		String capText = captchaProducer.createText();
		request.getSession().setAttribute(
				com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY, capText);
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
	}
}
