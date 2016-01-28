/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package com.victor.h5blog.constant;

/**
 * 评论表的常量
 * 
 * @author Administrator
 * 
 */
public class CommentConstant {
	/**
	 * @author Herbert
	 * 
	 */
	public static enum Status {
		/**
		 * 隐藏
		 */
		hidden,
		/**
		 * 显示
		 */
		display,
		/**
		 * 垃圾
		 */
		trash
	};

	public static enum kind {
		/**
		 * 隐藏
		 */
		article,
		/**
		 * 显示
		 */
		folder
	};	
	public static final String SUCCESS_CODE = "000000";
	public static final String ACTIVEDCARD_CODE = "051005";
	public static final String SC="zh_cn";
	public static final String EN="en";
	
	public static final String[] SYSTEM_ERROR_CODE={"990099","000101","00A702"};
	public static final String[] CARDPIN_ERROR_CODE={"080001","051001","005502","005501","070001","070005"};
	public static final String[] CARDSTATUS_ERROR_CODE={"051006","051008","050073","051003"};
	public static final String[] EXPIRED_CODE={"051007"};
}
