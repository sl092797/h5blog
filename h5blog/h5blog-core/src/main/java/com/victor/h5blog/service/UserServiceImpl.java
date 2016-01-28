package com.victor.h5blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.victor.h5blog.dao.RoleDao;
import com.victor.h5blog.dao.UserDao;
import com.victor.h5blog.dao.UserRoleDao;
import com.victor.h5blog.entity.Role;
import com.victor.h5blog.entity.User;
import com.victor.h5blog.entity.UserRole;
import com.victor.h5blog.entity.vo.PageVo;
import com.victor.h5blog.entity.vo.UserVo;
import com.victor.h5blog.service.inter.UserService;
import com.victor.h5blog.util.AuthUtils;
import com.victor.h5blog.utils.LegooUtil;

/**
 * user manage implements class
 * 
 * @author tangfan
 * @since 2015-11-04
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRoleDao userRoleDao;

	@Autowired
	private RoleDao roleDao;

	/**
	 * find all users by pageNum
	 * 
	 * @param pageNum
	 * @return
	 */
	public PageVo<UserVo> findAllListPage(int pageNum) {
		List<UserVo> userVoList = new ArrayList<UserVo>();
		PageVo<UserVo> pageVo = new PageVo<UserVo>(pageNum);
		pageVo.setRows(20);
		List<User> list = this
				.findAllList(pageVo.getOffset(), pageVo.getRows());
		for (User user : list) {
			UserVo userVo = new UserVo();
			BeanUtils.copyProperties(user, userVo);
			List<UserRole> userRoleList = userRoleDao.getUserRoleByUser(user
					.getUserId());
			for (UserRole userRole : userRoleList) {
				Role role = roleDao.getRoleById(userRole.getRoleId());
				userVo.setUserRole(role.getRoleName());
			}
			userVoList.add(userVo);
		}

		pageVo.setList(userVoList);
		pageVo.setCount(this.findAllListCount());
		return pageVo;
	}

	/**
	 * find all users' count
	 * 
	 * @return
	 */
	public int findAllListCount() {
		return userDao.findAllListCount();
	}

	/**
	 * find all users by offset and rows
	 * 
	 * @param offset
	 * @param rows
	 * @return
	 */
	public List<User> findAllList(int offset, int rows) {
		return userDao.findAllList(offset, rows);
	}

	/**
	 * find user by id
	 * 
	 * @param userId
	 * @return
	 */
	@Cacheable(value="user")
	public User findUserById(long userId) {
		return userDao.findUserById(userId);
	}

	/**
	 * update user by id
	 */
	@CacheEvict(value="user",key="#userVo.getUserId()")
	public void updateUserById(UserVo userVo) {
		User user = new User();
		BeanUtils.copyProperties(userVo, user);
		user.setLastModifyTime(LegooUtil.getCurrentTime());
		userDao.updateUserById(user);
	}

	/**
	 * delete user by id
	 */
	@CacheEvict(value="user",allEntries = true)
	public void deleteUserById(long userId) {
		userDao.deleteUserById(userId);
	}

	/**
	 * find user by name
	 */
	@Cacheable(value="user")
	public User findUserByName(String loginName) {
		return userDao.findUserByName(loginName);
	}

	/**
	 * add new user
	 * 
	 * @return
	 */
	public Long addUser(UserVo userVo) {
		User user = new User();
		BeanUtils.copyProperties(userVo, user);
		user.setCreateTime(LegooUtil.getCurrentTime());
		user.setLastModifyTime(LegooUtil.getCurrentTime());
		user.setLoginPwd(AuthUtils.getPassword(user.getLoginPwd()));
		user.setUserState("1");
		user.setDeleteFlag("0");
		userDao.addUser(user);
		return user.getUserId();
	}

	/**
	 * find all normal users' count
	 */
	public int findNormalCount() {
		return userDao.findNormalCount();
	}

	@Override
	public void addUserRole(UserVo userVo) {
		UserRole userRole = new UserRole();
		userRole.setRoleId(userVo.getUserRole());
		userRole.setUserId(userVo.getUserId().toString());
		userRoleDao.insert(userRole);

	}

	@Override
	public void updateUserRole(UserVo userVo) {
		UserRole userRole = new UserRole();
		userRole.setRoleId(userVo.getUserRole());
		userRole.setUserId(userVo.getUserId().toString());
		userRoleDao.update(userRole);

	}

	@Override
	public void deleteUserRole(long roleId) {
		userRoleDao.deleteByRoleId(roleId);
		
	}
}
