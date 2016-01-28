package com.victor.h5blog.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.victor.h5blog.constant.SystemConstant;
import com.victor.h5blog.entity.User;
import com.victor.h5blog.entity.vo.UserVo;
import com.victor.h5blog.service.inter.LoginService;
import com.victor.h5blog.service.inter.UserService;
import com.victor.h5blog.util.AuthUtils;

/**
 * Login through Database
 * 
 * @author tangfan
 * @since 2015-12-16
 *
 */
public class DbLoginService implements LoginService {

	@Autowired
	private UserService userService;

	@Override
	public Map<String, Object> login(HttpServletRequest request, UserVo user) {
		String name = user.getLoginName();
		String password = user.getLoginPwd();
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(name,
				AuthUtils.getPassword(password));
		token.setRememberMe(true);
		subject.login(token);
		final User authUserInfo = userService.findUserByName(name);
		UserVo userVo = new UserVo();
		BeanUtils.copyProperties(authUserInfo, userVo);
		userVo.setAdmin(true);
		HttpSession session = request.getSession();
		authUserInfo.setLoginPwd("");
		session.setAttribute(SystemConstant.SESSION_ADMIN, userVo);
		return null;
	}

}
