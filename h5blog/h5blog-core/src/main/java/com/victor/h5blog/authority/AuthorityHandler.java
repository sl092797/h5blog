package com.victor.h5blog.authority;

import javax.servlet.FilterConfig;

import org.apache.log4j.Logger;

import com.victor.h5blog.utils.LegooUtil;

public class AuthorityHandler {

	private static Logger logger = Logger.getLogger(AuthorityHandler.class);

	private static PermissionChecker checker;

	private static final String PERMISSIONCHECKER = "permissionChecker";

	public static PermissionChecker instantiationChecker(
			FilterConfig filterConfig) throws Exception {
		String permissionChecker = filterConfig
				.getInitParameter(PERMISSIONCHECKER);
		if (!LegooUtil.isNotEmpty(permissionChecker)) {
			logger.error("The init param of permissionChecker is undefined.Please config it in the web.xml.");
			return null;
		} else {
			try {
				Class<?> clazz = Class.forName(permissionChecker.trim());
				Object obj = clazz.newInstance();
				if (obj instanceof PermissionChecker) {
					checker = (PermissionChecker) obj;
					return checker;
				} else {
					logger.error("The init param of permissionChecker["
							+ permissionChecker
							+ "] must be extends the class PermissionChecker check it again.");
					return null;
				}
			} catch (ClassNotFoundException e) {
				logger.error(e.getMessage());
				logger.error("Get the permissionChecker[" + permissionChecker
						+ "] that configing in the web.xml error!");
				return null;
			} catch (InstantiationException e) {
				logger.error(e.getMessage());
				logger.error("Instantiation the permissionChecker["
						+ permissionChecker
						+ "] that configing in the web.xml error!");
				return null;
			} catch (IllegalAccessException e) {
				logger.error(e.getMessage());
				logger.error("Instantiation the permissionChecker["
						+ permissionChecker
						+ "] that configing in the web.xml error!");
				return null;
			}
		}
	}
}
