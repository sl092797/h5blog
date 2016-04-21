package com.victor.h5blog.service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.h5blog.constant.SystemConstant;
import com.victor.h5blog.entity.User;
import com.victor.h5blog.entity.vo.UserVo;
import com.victor.h5blog.exception.LoginException;
import com.victor.h5blog.service.inter.ILoginService;
import com.victor.h5blog.util.AuthUtils;

@Service
public class LoginService implements ILoginService{

	@Autowired
	private UserService userService;
	
	@Override
	public void login(HttpServletRequest request, UserVo loginUser) throws LoginException {
		String loginName = loginUser.getUsername();
		String password = loginUser.getPassword();
	    User user = userService.findUserByName(loginName);
	    if(user !=null && user.getPassword().equalsIgnoreCase(AuthUtils.getPassword(password))){
	    	HttpSession session = request.getSession();
	    	UserVo userVo = new UserVo();
	    	BeanUtils.copyProperties(user, userVo);
			session.setAttribute(SystemConstant.SESSION_ADMIN, userVo);
	    }else{
	    	throw new LoginException("用户名或密码错误");
	    }
	}

}
