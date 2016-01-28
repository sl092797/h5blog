package com.victor.h5blog.action.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.victor.h5blog.action.manage.ManageBaseAction;
import com.victor.h5blog.entity.Authority;
import com.victor.h5blog.entity.Role;
import com.victor.h5blog.entity.RoleAuth;
import com.victor.h5blog.entity.vo.AuthorityVo;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.entity.vo.PageVo;
import com.victor.h5blog.security.PermissionSign;

@Controller
@RequestMapping("manage/role")
public class ManageRoleAction extends ManageBaseAction {

	private static Logger logger = Logger.getLogger(ManageRoleAction.class);

	@RequestMapping(value = "/list.htm", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.ROLE_VISIT)
	public String userList(
			@RequestParam(value = "p", defaultValue = "1") int pageNum,
			ModelMap modelMap) {
		logger.info("访问角色管理页面");
		PageVo<Role> pageVo = roleService.findAllListPage(pageNum);
		ArrayList<Role> backList = new ArrayList<Role>();
		ArrayList<Role> foreList = new ArrayList<Role>();
		List<Role> list = pageVo.getList();
		for (Role roleVo : list) {
			if (roleVo.getRoleType().equals("0")) {
				backList.add(roleVo);
			} else {
				foreList.add(roleVo);
			}
		}
		modelMap.put("pageVo", pageVo);
		modelMap.put("backList", backList);
		modelMap.put("foreList", foreList);
		return "manage/role/list";
	}

	@RequestMapping(value = "/add.htm", method = RequestMethod.GET)
	public String addRole(ModelMap modelMap) {
		List<Authority> list = authorityService.findAllAuthority();
		modelMap.put("allList", list);
		return "manage/role/add";
	}

	@RequestMapping(value = "/fore.htm", method = RequestMethod.GET)
	public String addFore(ModelMap modelMap) {
		return "manage/role/fore";
	}

	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(
			@RequestParam(value = "roleId", defaultValue = "1") long roleId,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<AuthorityVo> authList = new ArrayList<AuthorityVo>();
		Role role = roleService.findRoleById(roleId);
		if (role.getRoleType().equals("0")) {
			List<Authority> allList = authorityService.findAllAuthority();
			List<Authority> list = authorityService
					.findAuthoritiesByRoleId(roleId);
			List<String> ids = new ArrayList<String>();
			for (int i = 0; i < list.size(); i++) {
				String id = list.get(i).getAuthorityId();
				ids.add(id);
			}
			for (Authority auth : allList) {
				AuthorityVo authVo = new AuthorityVo();
				BeanUtils.copyProperties(auth, authVo);
				if (ids.contains(auth.getAuthorityId())) {
					authVo.setIsTrue("1");
				} else {
					authVo.setIsTrue("0");
				}
				authList.add(authVo);
			}
		}
		modelMap.put("role", role);
		modelMap.put("allList", authList);
		return "manage/role/detail";
	}

	@RequestMapping(value = "/update.htm", method = RequestMethod.GET)
	public String update(
			@RequestParam(value = "roleId", defaultValue = "1") long roleId,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<AuthorityVo> authList = new ArrayList<AuthorityVo>();
		Role role = roleService.findRoleById(roleId);
		if (role.getRoleType().equals("0")) {
			List<Authority> allList = authorityService.findAllAuthority();
			List<Authority> list = authorityService
					.findAuthoritiesByRoleId(roleId);
			List<String> ids = new ArrayList<String>();
			for (int i = 0; i < list.size(); i++) {
				String id = list.get(i).getAuthorityId();
				ids.add(id);
			}
			for (Authority auth : allList) {
				AuthorityVo authVo = new AuthorityVo();
				BeanUtils.copyProperties(auth, authVo);
				if (ids.contains(auth.getAuthorityId())) {
					authVo.setIsTrue("1");
				} else {
					authVo.setIsTrue("0");
				}
				authList.add(authVo);
			}
		}
		modelMap.put("role", role);
		modelMap.put("allList", authList);
		return "manage/role/update";
	}

	@ResponseBody
	@RequestMapping(value = "/update.json", method = RequestMethod.POST)
	public JsonVo<String> update(Role role, HttpServletRequest request) {
		JsonVo<String> json = new JsonVo<String>();
		json = checkRoleInfo(role, json);
		if (!json.isResult()) {
			return json;
		}
		try {
			/* 更新角色信息 */
			roleService.updateRoleById(role);
			/* 删除目前授权信息 */
			roleService.deleteRoleAuthority(role.getRoleId());
			String[] auths = request.getParameterValues("authority");
			if (auths != null) {
				for (int i = 0; i < auths.length; i++) {
					RoleAuth roleAuth = new RoleAuth();
					roleAuth.setRoleId((role.getRoleId()).toString());
					roleAuth.setAuthorityId(auths[i]);
					roleService.insertRoleAuthority(roleAuth);
				}
			}
			json.setResult(true);
			return json;
		} catch (Exception e) {
			logger.error("Update role info failed:" + e.getMessage());
			json.setResult(false);
			return json;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public JsonVo<String> delete(@RequestParam(value = "roleId") long roleId,
			HttpServletRequest request) {
		JsonVo<String> json = new JsonVo<String>();
		try {
			roleService.deleteById(roleId);
			userService.deleteUserRole(roleId);
			roleService.deleteRoleAuthority(roleId);
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

	/**
	 * 添加后台角色
	 * 
	 * @param role
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public JsonVo<String> addNewRole(Role role, HttpServletRequest request) {
		JsonVo<String> json = new JsonVo<String>();
		json = checkRoleInfo(role, json);
		if (!json.isResult()) {
			return json;
		}
		try {
			role.setRoleType("0");
			Long roleId = roleService.addRole(role);
			String[] auths = request.getParameterValues("authority");
			for (int i = 0; i < auths.length; i++) {
				RoleAuth roleAuth = new RoleAuth();
				roleAuth.setRoleId((roleId.toString()));
				roleAuth.setAuthorityId(auths[i]);
				roleService.insertRoleAuthority(roleAuth);
			}
			json.setResult(true);
		} catch (Exception e) {
			logger.error(e.getMessage());
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "/addFore.json", method = RequestMethod.POST)
	public JsonVo<String> addForeRole(Role role, HttpServletRequest request) {
		JsonVo<String> json = new JsonVo<String>();
		json = checkRoleInfo(role, json);
		if (!json.isResult()) {
			return json;
		}
		try {
			role.setRoleType("1");
			Long roleId = roleService.addRole(role);
			logger.info("the new role id is :" + roleId);
			json.setResult(true);
		} catch (Exception e) {
			logger.error(e.getMessage());
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

	private JsonVo<String> checkRoleInfo(Role role, JsonVo<String> json) {
		if (StringUtil.isBlank(role.getRoleName())) {
			json.setResult(false);
			json.getErrors().put("roleName", "角色名称不能为空");
		}
		if (StringUtil.isBlank(role.getRoleNo())) {
			json.setResult(false);
			json.getErrors().put("roleNo", "角色代码不能为空");
		}
		if (StringUtil.isBlank(role.getRoleDesc())) {
			json.setResult(false);
			json.getErrors().put("roleDesc", "角色描述不能为空");
		}
		Role roleExist = roleService.findRoleByNo(role.getRoleNo());
		if (roleExist == null) {
		} else {
			json.setResult(false);
			json.getErrors().put("roleNo", "角色代码不能重复");
			return json;
		}
		return json;
	}
}
