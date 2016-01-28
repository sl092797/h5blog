package com.victor.h5blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.victor.h5blog.entity.Role;

/**
 * 角色DAO
 * 
 * @author 立
 * @date 2015年11月7日
 */
@Repository
public interface RoleDao {
	/**
	 * 通过id查找角色
	 * 
	 * @return
	 */
	public Role getRoleById(String roleId);

	public List<Role> findAllRoles();

	public List<Role> findAllList(@Param("offset") int offset,
			@Param("rows") int rows);

	public Role finRoleById(long roleId);

	public void updateRoleById(Role role);

	public void deleteById(long roleId);

	public void addRole(Role role);

	public Role findRoleByNo(String roleNo);

}
