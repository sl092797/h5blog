package com.victor.h5blog.entity;

/**
 * 角色实体，对应数据表:LEGOO_ROLE
 * 
 * @author 立
 * @date 2015年11月5日
 */
public class Role {
	/**
	 * 角色ID db_column:ROLE_ID
	 */
	private Long roleId;
	/**
	 * 角色名称 db_column:ROLE_NAME
	 */
	private String roleName;
	/**
	 * 角色编号 db_column:ROLE_NO
	 */
	private String roleNo;
	/**
	 * 角色描述 db_column:ROLE_DESC
	 */
	private String roleDesc;
	/**
	 * 角色类型 db_column: ROLE_TYPE
	 */
	private String roleType;
	/**
	 * 创建时间 db_column: CREATE_TIME
	 */
	private java.lang.String createTime;
	/**
	 * 最后修改时间 db_column: LAST_MODIFY_TIME
	 */
	private java.lang.String lastModifyTime;
	/**
	 * 删除标志 0 未删除 1已删除 默认 0
	 */
	private java.lang.String deleteFlag;
	/**
	 * 备注 db_column: MEMO
	 */
	private java.lang.String memo;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleNo() {
		return roleNo;
	}

	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public java.lang.String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.lang.String createTime) {
		this.createTime = createTime;
	}

	public java.lang.String getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(java.lang.String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public java.lang.String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(java.lang.String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public java.lang.String getMemo() {
		return memo;
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}
}
