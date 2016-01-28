package com.victor.h5blog.service.inter;

import java.util.List;

import com.victor.h5blog.entity.Role;
import com.victor.h5blog.entity.RoleAuth;
import com.victor.h5blog.entity.vo.PageVo;

public interface RoleService {

	/**
	 * find user's role by user_id
	 * 
	 * @return
	 */
	public List<Role> findRolesByUserId(Long userId);

	public PageVo<Role> findAllListPage(int pageNum);

	public List<Role> findAllRoles();

	public Role findRoleById(long roleId);

	public void updateRoleById(Role role);

	public void deleteRoleAuthority(Long roleId);

	public void insertRoleAuthority(RoleAuth roleAuth);

	public void deleteById(long roleId);

	public Long addRole(Role role);

	public Role findRoleByNo(String roleNo);
}
