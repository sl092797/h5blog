package com.victor.h5blog.action.manage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.victor.h5blog.entity.Authority;
import com.victor.h5blog.entity.Role;
import com.victor.h5blog.entity.User;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.entity.vo.UserVo;
import com.victor.h5blog.exception.FolderNotFoundException;
import com.victor.h5blog.util.AuthUtils;

/**
 * @author lqq
 * @author 进入网站后台首页
 * 
 */

@Controller
@RequestMapping("/manage/common")
public class ManageAction extends ManageBaseAction {

	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap modelMap)
			throws FolderNotFoundException {
		HttpSession session = request.getSession();
		ArrayList<Authority> list = new ArrayList<Authority>();
		UserVo userVo = this.getAdmin(request);
		List<Role> roleList = roleService.findRolesByUserId(userVo.getUserId());
		for (Role role : roleList) {
			List<Authority> authList = authorityService
					.findAuthoritiesByRoleId(role.getRoleId());
			list.removeAll(authList);
			list.addAll(authList);
		}
		session.setAttribute("authList", list);
		return "manage/index";
	}

	@RequestMapping(value = "/update.htm", method = RequestMethod.GET)
	public String modifyPwd(HttpServletRequest request,
			HttpServletResponse response, ModelMap modelMap) {
		UserVo userVo = this.getAdmin(request);
		modelMap.put("user", userVo);
		return "manage/admin/update";
	}
	
	@ResponseBody
	@RequestMapping(value = "/update.json")
	public JsonVo<String> modify(HttpServletRequest request,
			HttpServletResponse response){
		JsonVo<String> json = new JsonVo<String>();
		UserVo userVo = this.getAdmin(request);
		User user = userService.findUserById(userVo.getUserId());
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		String confirmPwd = request.getParameter("confirmPwd");
		String password = AuthUtils.getPassword(oldPwd);
		if(user.getLoginPwd().equals(password)){
			if(newPwd.equals(confirmPwd)){
				user.setLoginPwd(AuthUtils.getPassword(newPwd));
				BeanUtils.copyProperties(user, userVo);
				userService.updateUserById(userVo);
				json.setResult(true);
			}else{
				json.setResult(false);
				json.getErrors().put("confirmPwd", "两次输入密码不一致");
				return json;
			}
		}else{
			json.setResult(false);
			json.getErrors().put("oldPwd", "原密码输入错误");
			return json;
		}
		return json;
	}
}
