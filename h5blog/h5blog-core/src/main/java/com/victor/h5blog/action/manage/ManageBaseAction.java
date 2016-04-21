package com.victor.h5blog.action.manage;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.victor.h5blog.constant.SystemConstant;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.entity.vo.UserVo;
import com.victor.h5blog.exception.ValidateException;
import com.victor.h5blog.service.CatlogService;
import com.victor.h5blog.util.HttpUtils;

public class ManageBaseAction {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	protected final static String PHOTO_CATLOG_KEY = "PHOTO";
	protected final static String VIDEO_CATLOG_KEY="VIDEO";
	
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
