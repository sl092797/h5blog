package com.victor.h5blog.entity;

import java.io.Serializable;

/**
 * 权限实体 对应数据表:LEGOO_AUTH
 * 
 * @author 立
 * @date 2015年11月5日
 */
public class Authority implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 权限id db_column:AUTHORITY_ID
	 */
	private String authorityId;
	/**
	 * 权限名称 db_column:AUTHORITY_NAME
	 */
	private String authorityName;
	/**
	 * 权限编号 db_column:AUTHORITY_NO
	 */
	private String authorityNo;
	/**
	 * 权限描述 db_column:AUTHORITY_DESC
	 */
	private String authorityDesc;
	/**
	 *  菜单图标
	 */
	private String authorityIcon;
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

	public String getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public String getAuthorityNo() {
		return authorityNo;
	}

	public void setAuthorityNo(String authorityNo) {
		this.authorityNo = authorityNo;
	}

	public String getAuthorityDesc() {
		return authorityDesc;
	}

	public void setAuthorityDesc(String authorityDesc) {
		this.authorityDesc = authorityDesc;
	}

	public String getAuthorityIcon() {
		return authorityIcon;
	}

	public void setAuthorityIcon(String authorityIcon) {
		this.authorityIcon = authorityIcon;
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
