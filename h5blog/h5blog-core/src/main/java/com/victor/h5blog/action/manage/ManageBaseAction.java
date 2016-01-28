/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package com.victor.h5blog.action.manage;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.victor.h5blog.constant.SystemConstant;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.entity.vo.UserVo;
import com.victor.h5blog.exception.ValidateException;
import com.victor.h5blog.service.AdminFolderService;
import com.victor.h5blog.service.ArticleService;
import com.victor.h5blog.service.ConfigService;
import com.victor.h5blog.service.FolderService;
import com.victor.h5blog.service.HeadlineService;
import com.victor.h5blog.service.MediaService;
import com.victor.h5blog.service.inter.AuthorityService;
import com.victor.h5blog.service.inter.RoleService;
import com.victor.h5blog.service.inter.UserService;

/**
 * @author 所有action的父类
 * 
 */
@Controller
public class ManageBaseAction {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected ConfigService configService;

	@Autowired
	protected FolderService folderService;

	@Autowired
	protected ArticleService articleService;

	@Autowired
	protected MediaService attachmentService;

	@Autowired
	protected UserService userService;
	
	@Autowired
	protected RoleService roleService;
	
	@Autowired
	protected AuthorityService authorityService;

	@Autowired
	protected HeadlineService headlineService;

	@Autowired
	protected AdminFolderService adminFolderService;

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
