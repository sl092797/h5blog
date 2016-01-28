package com.victor.h5blog.authority;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.victor.h5blog.constant.SystemConstant;

public class LegooChecker extends PermissionChecker {

	@SuppressWarnings("unchecked")
	@Override
	public Boolean check(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String contextPath = request.getContextPath();
		String currentPath = request.getRequestURI();
		// get authority list from session
		ArrayList<String> collection = (ArrayList<String>) session
				.getAttribute(SystemConstant.USER_AUTH_LIST);
		if (collection != null) {
			for (int i = 0; i < collection.size(); i++) {
				String url = collection.get(i);
				url = contextPath + url;
				if (url.contains(currentPath)) {
					return true;
				}
			}
		}
		return false;
	}
}
