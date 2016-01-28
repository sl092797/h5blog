package com.victor.h5blog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.victor.h5blog.entity.RoleAuth;

@Repository
public interface RoleAuthorityDao {

	public List<RoleAuth> findRoleAuthByRoleId(Long userId);

	public void deleteByRoleId(Long roleId);

	public void insertRoleAuthority(RoleAuth roleAuth);
}
