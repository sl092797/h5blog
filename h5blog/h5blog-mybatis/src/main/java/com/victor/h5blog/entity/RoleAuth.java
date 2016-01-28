package com.victor.h5blog.entity;

/**
 * 角色权限关联实体 对应数据表:LEGOO_ROLE_AUTH
 * 
 * @author 立
 * @date 2015年11月5日
 */
public class RoleAuth {
	/**
	 * 角色权限id db_column:role_auth_id
	 */
	private Long roleAuthId;
	/**
	 * 角色id db_column:role_id
	 */
	private String roleId;
	/**
	 * 权限id db_column:authority_id
	 */
	private String authorityId;

	public Long getRoleAuthId() {
		return roleAuthId;
	}

	public void setRoleAuthId(Long roleAuthId) {
		this.roleAuthId = roleAuthId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}
}
