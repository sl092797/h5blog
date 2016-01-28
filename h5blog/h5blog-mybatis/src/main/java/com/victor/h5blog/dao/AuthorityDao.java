package com.victor.h5blog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.victor.h5blog.entity.Authority;

/**
 * 
 * @author tangfan
 * @since 2015-11-12
 *
 */
@Repository
public interface AuthorityDao {

	/**
	 * find authority by authority_id
	 * 
	 * @param authorityId
	 * @return
	 */
	public Authority findAuthorityById(String authorityId);

	public List<Authority> findAllAuthority();

}
