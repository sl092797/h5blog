package com.victor.h5blog.service.inter;

import java.util.List;

import com.victor.h5blog.entity.Authority;

public interface AuthorityService {

	/**
	 * find authority by role_id
	 * 
	 * @param roleId
	 * @return
	 */
	public List<Authority> findAuthoritiesByRoleId(Long roleId);

	public List<Authority> findAllAuthority();
}
