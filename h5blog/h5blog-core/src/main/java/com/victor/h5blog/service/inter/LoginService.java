package com.victor.h5blog.service.inter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.victor.h5blog.entity.vo.UserVo;

public interface LoginService {

	public Map<String, Object> login(HttpServletRequest request, UserVo user);
}
