/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package com.victor.h5blog.constant;

import com.victor.h5blog.util.PropertyUtils;

/**
 * 系统常量
 * 
 * @author Herbert
 * 
 */
public class SystemConstant {

	/**
	 * 应用部署路径的KEY
	 */
	public static String LEGOO_CMS_ROOT = PropertyUtils.getRoot();

	/**
	 * 页面模板文件夹
	 */
	public static String PAGE_TPL_FOLDER = "static/pagetpl";

	/**
	 * 页面组件文件夹
	 */
	public static String PAGE_COM_FOLDER = "static/comtpl";

	/**
	 * 页面区域标识符
	 */
	public static String PAGE_TPL_AREA = "PAGE_TPL_AREA";

	/**
	 * 上传文件夹
	 */
	public static String UPLOAD_FOLDER = "upload/photo";

	/**
	 * 备份文件夹
	 */
	public static String BACKUP_FOLDER = "/WEB-INF/backup";

	/**
	 * Session中的管理员Key
	 */
	public static final String SESSION_ADMIN = "SESSION_ADMIN";
	/**
	 * 前台登陆用户
	 */
	public static final String FORCE_USER = "FORCE_USER";
	/**
	 * user authority list in Session
	 */
	public static final String USER_AUTH_LIST = "userAuthList";

	/**
	 * 头像URL 180x180
	 */
	public static final String FACE_URL = "http://faceurl.shishuo.com/face";

	/**
	 * 编码格式
	 */
	public static final String ENCODEING = "UTF-8";

	/**
	 * 
	 */
	public static final String LANGUAGE = "language";

	public static final String ROLE_ADMIN = "admin";
	/**
	 * LoginSelector config path
	 */
	public static final String RESOURCES_COMM = "comm";
	/**
	 * pack basic config file name
	 */
	public static final String PACK_BASIC = "packBasic";

	public static final String URL_FILTER = "urlFilter";

	public static final int PAGE_COMDEF_AVAL_TRUE = 1;

	public static final int PAGE_COMDEF_AVAL_FALSE = 1;

	public static final String PAGE_SUFFIX = ".htm";

	public static final String SHOW_URL_PARAM = "SHOW_URL_PARAM";
}
