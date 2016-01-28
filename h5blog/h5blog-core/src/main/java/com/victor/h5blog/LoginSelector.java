package com.victor.h5blog;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.victor.h5blog.model.ConfigurationDefinition;
import com.victor.h5blog.model.ServerDefinition;
import com.victor.h5blog.service.inter.LoginService;

public class LoginSelector {
	private static Logger logger = Logger.getLogger(LoginSelector.class);

	public static LoginService select(HttpServletRequest request, String type) {
		LoginService loginService = null;
		/* get Spring config */
		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(request.getServletContext());
		/* get config file */
		ConfigurationRegistry.getInstance();

		for (String channel : ConfigurationRegistry.getInstance()
				.getConfigurations().keySet()) {
			ConfigurationDefinition configuration = ConfigurationRegistry
					.getInstance().getConfigurations().get(channel);
			List<ServerDefinition> serverList = configuration.getServers();
			for (ServerDefinition server : serverList) {
				if (type.equals(server.getFlag())) {
					try {
						loginService = (LoginService) context.getBean(server
								.getClazz());
					} catch (Exception e) {
						logger.error("Get Login Class Failed，Please Check the Spring Config，the Login Class must implement LoginService interface "
								+ e.getMessage());
					}
				}
			}
		}
		return loginService;
	}
}
