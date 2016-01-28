package com.victor.h5blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.h5blog.dao.RoleAuthorityDao;
import com.victor.h5blog.dao.RoleDao;
import com.victor.h5blog.dao.UserRoleDao;
import com.victor.h5blog.entity.Role;
import com.victor.h5blog.entity.RoleAuth;
import com.victor.h5blog.entity.UserRole;
import com.victor.h5blog.entity.vo.PageVo;
import com.victor.h5blog.service.inter.RoleService;
import com.victor.h5blog.utils.LegooUtil;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private RoleAuthorityDao roleAuthorityDao;

	@Override
	public List<Role> findRolesByUserId(Long userId) {
		List<Role> list = new ArrayList<Role>();
		List<UserRole> userRoleList = userRoleDao.getUserRoleByUser(userId);
		for (int i = 0; i < userRoleList.size(); i++) {
			String roleId = userRoleList.get(i).getRoleId();
			Role role = roleDao.getRoleById(roleId);
			list.add(role);
		}
		return list;
	}

	@Override
	public List<Role> findAllRoles() {
		return roleDao.findAllRoles();
	}

	@Override
	public PageVo<Role> findAllListPage(int pageNum) {
		PageVo<Role> pageVo = new PageVo<Role>(pageNum);
		pageVo.setRows(20);
		List<Role> list = this
				.findAllList(pageVo.getOffset(), pageVo.getRows());
		pageVo.setList(list);
		return pageVo;
	}

	private List<Role> findAllList(int offset, int rows) {
		return roleDao.findAllList(offset, rows);
	}

	@Override
	public Role findRoleById(long roleId) {
		return roleDao.finRoleById(roleId);
	}

	@Override
	public void updateRoleById(Role role) {
		role.setLastModifyTime(LegooUtil.getCurrentTime());
		roleDao.updateRoleById(role);

	}

	@Override
	public void deleteRoleAuthority(Long roleId) {
		roleAuthorityDao.deleteByRoleId(roleId);

	}

	@Override
	public void insertRoleAuthority(RoleAuth roleAuth) {
		roleAuthorityDao.insertRoleAuthority(roleAuth);

	}

	@Override
	public void deleteById(long roleId) {
		roleDao.deleteById(roleId);

	}

	@Override
	public Long addRole(Role role) {
		role.setCreateTime(LegooUtil.getCurrentTime());
		role.setLastModifyTime(LegooUtil.getCurrentTime());
		role.setDeleteFlag("0");
		roleDao.addRole(role);
		return role.getRoleId();
	}

	@Override
	public Role findRoleByNo(String roleNo) {
		return roleDao.findRoleByNo(roleNo);
	}
}
