package com.victor.h5blog.security;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.victor.h5blog.entity.Authority;
import com.victor.h5blog.entity.Role;
import com.victor.h5blog.entity.User;
import com.victor.h5blog.service.inter.AuthorityService;
import com.victor.h5blog.service.inter.RoleService;
import com.victor.h5blog.service.inter.UserService;

/**
 * user identify Realm
 * 
 * @author tangfan
 * @since 2015-11-11
 **/
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {
	private static Logger logger = Logger.getLogger(SecurityRealm.class);
	@Resource
	private UserService userService;

	@Resource
	private RoleService roleService;

	@Resource
	private AuthorityService authorityService;

	/**
	 * authorization check
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		String username = String.valueOf(principals.getPrimaryPrincipal());
		final User user = userService.findUserByName(username);
		final List<Role> roleInfos = roleService.findRolesByUserId(user
				.getUserId());
		for (Role role : roleInfos) {
			// add role
			logger.info("ROLE INFO: " + "[" + role.getRoleId() + " "
					+ role.getRoleName() + " " + role.getRoleNo() + "]");
			authorizationInfo.addRole(role.getRoleNo());

			final List<Authority> authorities = authorityService
					.findAuthoritiesByRoleId(role.getRoleId());
			for (Authority authority : authorities) {
				// add authorization
				logger.info("AUTHORITY INFO: " + "["
						+ authority.getAuthorityId() + " "
						+ authority.getAuthorityName() + " "
						+ authority.getAuthorityNo() + "]");
				authorizationInfo.addStringPermission(authority
						.getAuthorityNo());
			}
		}
		return authorizationInfo;
	}

	/**
	 * Login Authentication
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		final User user = userService.findUserByName(token.getUsername());
		if (user != null) {
			return new SimpleAuthenticationInfo(user.getLoginName(),
					user.getLoginPwd(), getName());
		} else {
			throw new AuthenticationException();
		}
	}
}
