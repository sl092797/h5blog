package com.victor.h5blog.entity;

/**
 * 用户角色关联实体，对应数据表:LEGOO_USER_ROLE
 * 
 * @author 立
 * @date 2015年11月5日
 */

public class UserRole {

	/**
	 * 用户角色关联ID db_column:USER_ROLE_ID
	 */
	private String userRoleId;
	/**
	 * 用户ID db_column:USER_ID
	 */
	private String userId;
	/**
	 * 角色ID db_column:ROLE_ID
	 */
	private String roleId;

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
