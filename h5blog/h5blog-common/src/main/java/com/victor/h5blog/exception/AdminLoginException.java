/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package com.victor.h5blog.exception;

/**
 * 
 * 系统配置Key获得的Value为空
 * 
 * @author Herbert
 * 
 */
public class AdminLoginException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AdminLoginException(String msg) {
		super(msg);
	}
}
