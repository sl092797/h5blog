/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package com.victor.h5blog.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Herbert
 * 
 */
public class UploadException extends Exception {

	public UploadException(String msg) {
		super(msg);
	}
}
