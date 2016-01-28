package com.victor.h5blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.h5blog.dao.AuthorityDao;
import com.victor.h5blog.dao.RoleAuthorityDao;
import com.victor.h5blog.entity.Authority;
import com.victor.h5blog.entity.RoleAuth;
import com.victor.h5blog.service.inter.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private RoleAuthorityDao roleAuthorityDao;
	@Autowired
	private AuthorityDao authorityDao;

	@Override
	public List<Authority> findAuthoritiesByRoleId(Long roleId) {
		List<Authority> list = new ArrayList<Authority>();
		List<RoleAuth> roleAuthList = roleAuthorityDao
				.findRoleAuthByRoleId(roleId);
		for (int i = 0; i < roleAuthList.size(); i++) {
			String authorityId = roleAuthList.get(i).getAuthorityId();
			Authority authority = authorityDao.findAuthorityById(authorityId);
			list.add(authority);
		}
		return list;
	}

	@Override
	public List<Authority> findAllAuthority() {
		return authorityDao.findAllAuthority();
	}
}
