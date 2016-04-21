package com.victor.h5blog.action.manage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.victor.h5blog.entity.User;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.entity.vo.UserVo;
import com.victor.h5blog.service.UserService;
import com.victor.h5blog.util.AuthUtils;

@Controller
@RequestMapping("/manage")
public class ManageIndexAction extends ManageBaseAction{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap modelMap) {
		return "/manage/index";
	}
	
	@RequestMapping(value = "/updatePassword.htm", method = RequestMethod.GET)
	public String updatePasswordHtm(HttpServletRequest request, ModelMap modelMap) {
		return "/manage/admin/update";
	}
	
	@ResponseBody
	@RequestMapping(value = "/updatePassword.json")
	public JsonVo<String> updatePassword(HttpServletRequest request,
			HttpServletResponse response){
		JsonVo<String> json = new JsonVo<String>();
		UserVo userVo = this.getAdmin(request);
		User user = userService.findUserById(userVo.getId());
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		String confirmPwd = request.getParameter("confirmPwd");
		String password = AuthUtils.getPassword(oldPwd);
		if(user.getPassword().equals(password)){
			if(newPwd.equals(confirmPwd)){
				user.setPassword(AuthUtils.getPassword(newPwd));
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
