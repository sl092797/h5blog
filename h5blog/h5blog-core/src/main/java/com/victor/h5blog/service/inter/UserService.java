package com.victor.h5blog.service.inter;

import java.util.List;

import com.victor.h5blog.entity.User;
import com.victor.h5blog.entity.vo.PageVo;
import com.victor.h5blog.entity.vo.UserVo;

public interface UserService {

	/**
	 * find all users by pageNum
	 * 
	 * @param pageNum
	 * @return
	 */
	public PageVo<UserVo> findAllListPage(int pageNum);

	/**
	 * find all users' count
	 * 
	 * @return
	 */
	public int findAllListCount();

	/**
	 * find all normal users' count
	 * 
	 * @return
	 */
	public int findNormalCount();

	/**
	 * find all users by offset and rows
	 * 
	 * @param offset
	 * @param rows
	 * @return
	 */
	public List<User> findAllList(int offset, int rows);

	/**
	 * find user by id
	 * 
	 * @param userId
	 * @return
	 */
	public User findUserById(long userId);

	/**
	 * find user by name
	 * 
	 * @param loginName
	 * @return
	 */
	public User findUserByName(String loginName);

	/**
	 * modify user by id
	 * 
	 * @param user
	 */
	public void updateUserById(UserVo userVo);

	/**
	 * delete user by id
	 * 
	 * @param userId
	 */
	public void deleteUserById(long userId);

	/**
	 * add new user
	 * 
	 * @param user
	 * @return
	 */
	public Long addUser(UserVo userVo);

	public void addUserRole(UserVo userVo);

	public void updateUserRole(UserVo userVo);

	public void deleteUserRole(long roleId);
}
