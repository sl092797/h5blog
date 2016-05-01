package com.victor.h5blog.action.manage;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.victor.h5blog.constant.SystemConstant;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.entity.vo.UserVo;
import com.victor.h5blog.exception.ValidateException;
import com.victor.h5blog.service.CatlogService;

public class ManageBaseAction {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected final static String PHOTO_CATLOG_KEY = "PHOTO";
	protected final static String VIDEO_CATLOG_KEY="VIDEO";
	protected final static String FILE_CATLOG_KEY = "FILE";
	
	@Autowired
	protected CatlogService catlogService;
	
	/**
	 * 参数校验
	 * 
	 * @param json
	 *            json数据Bean
	 * @throws ValidateException
	 */
	protected <T> void validate(JsonVo<T> json) throws ValidateException {
		if (json.getErrors().size() > 0) {
			json.setResult(false);
			throw new ValidateException("有错误发生");
		} else {
			json.setResult(true);
		}
	}
	
	/**
	 * 从session中获得管理员的信息
	 * 
	 * @param request
	 * @return
	 */
	protected UserVo getAdmin(HttpServletRequest request) {
		UserVo userVo = (UserVo) request.getSession().getAttribute(
				SystemConstant.SESSION_ADMIN);
		return userVo;
	}
	
	
	
}
