package com.victor.h5blog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.victor.h5blog.entity.UserRole;

/**
 * 用户角色关联DAO
 * 
 * @author 立
 * @date 2015年11月6日
 */

@Repository
public interface UserRoleDao {

	/**
	 * 通过用户id获取关系
	 * 
	 * @return
	 */
	public List<UserRole> getUserRoleByUser(Long userId);

	public void insert(UserRole userRole);

	public void update(UserRole userRole);

	public void deleteByRoleId(long roleId);

}
