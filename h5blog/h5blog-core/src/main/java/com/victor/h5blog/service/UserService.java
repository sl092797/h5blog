package com.victor.h5blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.victor.h5blog.dao.UserMapper;
import com.victor.h5blog.entity.User;
import com.victor.h5blog.entity.UserExample;
import com.victor.h5blog.entity.vo.UserVo;



/**
 * user manage implements class
 * 
 * @author tangfan
 * @since 2015-11-04
 *
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userDao;


	/**
	 * find user by id
	 * 
	 * @param userId
	 * @return
	 */
	public User findUserById(long userId) {
		return userDao.selectByPrimaryKey(userId);
	}

	/**
	 * update user by id
	 */
	public void updateUserById(UserVo userVo) {
		User user = new User();
		BeanUtils.copyProperties(userVo, user);
		userDao.updateByPrimaryKey(user);
	}

	/**
	 * delete user by id
	 */
	public void deleteUserById(long userId) {
		userDao.deleteByPrimaryKey(userId);
	}

	/**
	 * find user by name
	 */
	public User findUserByName(String loginName) {
		UserExample ue = new UserExample();
		ue.createCriteria().andUsernameEqualTo(loginName);
		return userDao.selectByExample(ue).get(0);
	}

}
