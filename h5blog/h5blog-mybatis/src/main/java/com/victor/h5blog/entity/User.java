package com.victor.h5blog.entity;

/**
 * 用户实体,对应数据表:LEGOO_USER
 * 
 * @author tangfan
 * @since 2015-11-04
 *
 */

public class User {
	/**
	 * 用户ID db_column: USER_ID
	 */
	private java.lang.Long userId;
	/**
	 * 登录名 db_column: LOGIN_NAME
	 */
	private java.lang.String loginName;
	/**
	 * 密码 db_column: LOGIN_PWD
	 */
	private java.lang.String loginPwd;
	
	private java.lang.String userFlag;
	/**
	 * 真实姓名 db_column: REAL_NAME
	 */
	private java.lang.String realName;
	/**
	 * Email db_column: USER_EMAIL
	 */
	private java.lang.String userEmail;
	/**
	 * 电话 db_column: USER_PHONE
	 */
	private java.lang.String userPhone;
	/**
	 * 手机号 db_column: USER_MOBILE
	 */
	private java.lang.String userMobile;
	/**
	 * 性别1男 0女 db_column: USER_SEX
	 */
	private Integer userSex;
	/**
	 * 所属公司ID db_column: COMPANY_NAME
	 */
	private java.lang.String companyName;
	/**
	 * 所属部门ID db_column: DEPARTMENT_Name
	 */
	private java.lang.String departmentName;
	/**
	 * 创建时间 db_column: CREATE_TIME
	 */
	private java.lang.String createTime;
	/**
	 * 最后修改时间 db_column: LAST_MODIFY_TIME
	 */
	private java.lang.String lastModifyTime;
	/**
	 * 用户状态 1正常 0禁用 db_column: USER_STATE
	 */
	private java.lang.String userState;
	/**
	 * 删除标志 0 未删除 1已删除 默认 0
	 */
	private java.lang.String deleteFlag;
	/**
	 * 是否是第一次登录
	 */
	private String isFirstLog;

	/**
	 * 用户登录异常次数
	 */
	private java.lang.Integer loginErrorNum;
	/**
	 * 备注 db_column: MEMO
	 */
	private java.lang.String memo;

	public java.lang.Long getUserId() {
		return userId;
	}

	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}

	public java.lang.String getLoginName() {
		return loginName;
	}

	public void setLoginName(java.lang.String loginName) {
		this.loginName = loginName;
	}

	public java.lang.String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(java.lang.String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public java.lang.String getUserFlag() {
		return userFlag;
	}

	public void setUserFlag(java.lang.String userFlag) {
		this.userFlag = userFlag;
	}

	public java.lang.String getRealName() {
		return realName;
	}

	public void setRealName(java.lang.String realName) {
		this.realName = realName;
	}

	public java.lang.String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(java.lang.String userEmail) {
		this.userEmail = userEmail;
	}

	public java.lang.String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(java.lang.String userPhone) {
		this.userPhone = userPhone;
	}

	public java.lang.String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(java.lang.String userMobile) {
		this.userMobile = userMobile;
	}

	public Integer getUserSex() {
		return userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public java.lang.String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(java.lang.String companyName) {
		this.companyName = companyName;
	}

	public java.lang.String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(java.lang.String departmentName) {
		this.departmentName = departmentName;
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

	public java.lang.String getUserState() {
		return userState;
	}

	public void setUserState(java.lang.String userState) {
		this.userState = userState;
	}

	public java.lang.String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(java.lang.String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getIsFirstLog() {
		return isFirstLog;
	}

	public void setIsFirstLog(String isFirstLog) {
		this.isFirstLog = isFirstLog;
	}

	public java.lang.Integer getLoginErrorNum() {
		return loginErrorNum;
	}

	public void setLoginErrorNum(java.lang.Integer loginErrorNum) {
		this.loginErrorNum = loginErrorNum;
	}

	public java.lang.String getMemo() {
		return memo;
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}
}
