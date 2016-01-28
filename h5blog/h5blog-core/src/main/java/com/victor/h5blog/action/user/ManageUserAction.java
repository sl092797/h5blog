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
import com.victor.h5blog.entity.Role;
import com.victor.h5blog.entity.User;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.entity.vo.PageVo;
import com.victor.h5blog.entity.vo.UserVo;
import com.victor.h5blog.security.PermissionSign;
import com.victor.h5blog.util.AuthUtils;

/**
 * user manage action,charge for user CURD
 * 
 * @author tangfan
 * @since 2015-11-04
 *
 */
@Controller
@RequestMapping("manage/user")
public class ManageUserAction extends ManageBaseAction {
	private static Logger logger = Logger.getLogger(ManageUserAction.class);

	/**
	 * visit page of user manage
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.USER_VISIT)
	public String userList(
			@RequestParam(value = "p", defaultValue = "1") int pageNum,
			ModelMap modelMap) {
		ArrayList<UserVo> backList = new ArrayList<UserVo>();
		ArrayList<UserVo> foreList = new ArrayList<UserVo>();
		PageVo<UserVo> pageVo = userService.findAllListPage(pageNum);
		List<UserVo> list = pageVo.getList();
		for (UserVo userVo : list) {
			if (userVo.getUserFlag().equals("0")) {
				backList.add(userVo);
			} else {
				foreList.add(userVo);
			}
		}
		// 所有用户数量
		int total = pageVo.getCount();
		// 后台用户数量
		int backCount = userService.findNormalCount();
		modelMap.put("pageVo", pageVo);
		modelMap.put("backList", backList);
		modelMap.put("foreList", foreList);
		modelMap.put("total", total);
		modelMap.put("backCount", backCount);
		modelMap.put("foreCount", total - backCount);
		return "manage/user/list";
	}

	/**
	 * visit add user page
	 * 
	 */
	@RequestMapping(value = "/add.htm", method = RequestMethod.GET)
	public String addUser(ModelMap modelMap) {
		List<Role> list = roleService.findAllRoles();
		modelMap.put("roleList", list);
		return "manage/user/add";
	}

	/**
	 * visit modify user information page
	 * 
	 * @param userId
	 * @param modelMap
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update.htm", method = RequestMethod.GET)
	public String update(
			@RequestParam(value = "userId", defaultValue = "1") long userId,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserVo userVo = new UserVo();
		User user = userService.findUserById(userId);
		BeanUtils.copyProperties(user, userVo);
		List<Role> roleList = roleService.findRolesByUserId(user.getUserId());
		if (roleList.size() > 0) {
			userVo.setUserRole((roleList.get(0).getRoleId()).toString());
		}
		List<Role> list = roleService.findAllRoles();
		modelMap.put("roleList", list);
		modelMap.put("user", userVo);
		return "manage/user/update";
	}

	/**
	 * visit page of user details
	 * 
	 * @param userId
	 * @param modelMap
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/detail.htm", method = RequestMethod.GET)
	public String detail(
			@RequestParam(value = "userId", defaultValue = "1") long userId,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserVo userVo = new UserVo();
		User user = userService.findUserById(userId);
		BeanUtils.copyProperties(user, userVo);
		List<Role> roleList = roleService.findRolesByUserId(user.getUserId());
		if (roleList.size() > 0) {
			userVo.setUserRole(roleList.get(0).getRoleName());
		}
		modelMap.put("user", userVo);
		return "manage/user/detail";
	}

	/**
	 * add new user
	 */
	@ResponseBody
	@RequestMapping(value = "/addNew.json", method = RequestMethod.POST)
	public JsonVo<String> addNewUser(UserVo userVo) {
		JsonVo<String> json = new JsonVo<String>();
		json = checkUserInfo(userVo, json);
		if (!json.isResult()) {
			return json;
		}
		try {
			Long userId = userService.addUser(userVo);
			userVo.setUserId(userId);
			userService.addUserRole(userVo);
			json.setResult(true);
		} catch (Exception e) {
			logger.error(e.getMessage());
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}

	private JsonVo<String> checkUserInfo(UserVo userVo, JsonVo<String> json) {
		if (StringUtil.isBlank(userVo.getLoginName())) {
			json.setResult(false);
			json.getErrors().put("loginName", "用户姓名不能为空");
		}
		if (StringUtil.isBlank(userVo.getLoginPwd())) {
			json.setResult(false);
			json.getErrors().put("loginPwd", "用户密码不能为空");
		}
		if (StringUtil.isBlank(userVo.getDepartmentName())) {
			json.setResult(false);
			json.getErrors().put("departmentName", "部门名称不能为空");
		}
		if (StringUtil.isBlank(userVo.getCompanyName())) {
			json.setResult(false);
			json.getErrors().put("companyName", "公司名称不能为空");
		}
		if (StringUtil.isBlank(userVo.getUserRole())) {
			json.setResult(false);
			json.getErrors().put("userRole", "用户角色不能为空");
		}
		User userExist = userService.findUserByName(userVo.getLoginName());
		if (userExist == null) {
		} else {
			json.setResult(false);
			json.getErrors().put("loginName", "用户名称不能重复");
		}
		return json;
	}

	/**
	 * modify user info
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update.json", method = RequestMethod.POST)
	public JsonVo<String> update(UserVo userVo) {
		JsonVo<String> json = new JsonVo<String>();
		json = checkUserInfo(userVo, json);
		if (!json.isResult()) {
			return json;
		}
		try {
			userService.updateUserById(userVo);
			userService.updateUserRole(userVo);
			json.setResult(true);
			return json;
		} catch (Exception e) {
			logger.error(e.getMessage());
			json.setResult(false);
			return json;
		}
	}

	/**
	 * reset password
	 * 
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/reset.json", method = RequestMethod.POST)
	public JsonVo<User> reset(Long userId) {
		JsonVo<User> json = new JsonVo<User>();
		UserVo userVo = new UserVo();
		try {
			User user = userService.findUserById(userId);
			user.setLoginPwd(AuthUtils.getPassword("123456"));
			BeanUtils.copyProperties(user, userVo);
			userService.updateUserById(userVo);
			json.setResult(true);
			return json;
		} catch (Exception e) {
			logger.error(e.getMessage());
			json.setResult(false);
			return json;
		}
	}

	/**
	 * delete user
	 * 
	 * @param userId
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public JsonVo<String> delete(@RequestParam(value = "userId") long userId,
			HttpServletRequest request) {
		JsonVo<String> json = new JsonVo<String>();
		try {
			userService.deleteUserById(userId);
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}
}
