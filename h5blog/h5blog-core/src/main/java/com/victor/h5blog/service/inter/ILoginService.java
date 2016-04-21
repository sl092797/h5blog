package com.victor.h5blog.service.inter;

import javax.servlet.http.HttpServletRequest;

import com.victor.h5blog.entity.vo.UserVo;
import com.victor.h5blog.exception.LoginException;


public interface ILoginService {

	public void login(HttpServletRequest request, UserVo user)throws LoginException ;
}
