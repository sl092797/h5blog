package com.victor.h5blog.authority;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public abstract class PermissionChecker {

	private static Logger logger = Logger.getLogger(PermissionChecker.class);

	public abstract Boolean check(HttpServletRequest request,
			HttpServletResponse response);

	public void init() {
		logger.info("Init Perssionchecker...");

	}

	public void destroy() {
		logger.info("Destroy Perssionchecker...");
	}

	public String getUrl(HttpServletRequest request) {
		return request.getServletPath();
	}

	public void forward(String path, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		logger.info("forward to " + path);
		request.getRequestDispatcher(path).forward(request, response);
	}

	public void redirect(String path, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		logger.info("redirect to " + path);
		response.sendRedirect(path);
	}
}
