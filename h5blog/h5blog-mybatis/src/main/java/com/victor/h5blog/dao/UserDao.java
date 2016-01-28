package com.victor.h5blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.victor.h5blog.entity.User;

/**
 * 用户管理
 * 
 * @author tangfan
 * @since 2015-11-04
 */

@Repository
public interface UserDao {

	/**
	 * 获取所有用户列表
	 * 
	 * @param offset
	 * @param rows
	 * @return List<Admin>
	 * 
	 */
	public List<User> findAllList(@Param("offset") long offset,
			@Param("rows") long rows);

	/**
	 * 获取所有用户的数量
	 * 
	 * @return Integer
	 * 
	 */
	public int findAllListCount();

	/**
	 * 根据ID获取用户
	 * 
	 * @param userId
	 * @return
	 */
	public User findUserById(long userId);

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 * @return
	 */
	public void updateUserById(User user);

	/**
	 * 根据ID删除用户
	 * 
	 * @param userId
	 */
	public void deleteUserById(long userId);

	/**
	 * 根据登录名获取用户
	 * 
	 * @param loginName
	 * @return
	 */
	public User findUserByName(String loginName);

	/**
	 * 新增用户
	 * 
	 * @param user
	 */
	public void addUser(User user);

	/**
	 * 获取状态正常的用户数
	 * 
	 * @return
	 */
	public int findNormalCount();

}
