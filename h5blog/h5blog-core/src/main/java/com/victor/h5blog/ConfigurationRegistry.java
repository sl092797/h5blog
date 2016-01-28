package com.victor.h5blog;

import java.util.Map;





import com.victor.h5blog.constant.SystemConstant;
import com.victor.h5blog.model.ConfigurationDefinition;

/**
 * 
 * @author tangfan
 * @since 2015-10-12
 *
 */
public class ConfigurationRegistry extends
		AbstractRegistry<String, ConfigurationDefinition> {

	private static final ConfigurationRegistry instance = new ConfigurationRegistry();

	/**
	 * @param clazz
	 */
	private ConfigurationRegistry() {
		super(ConfigurationRegistry.class);
		init();
	}

	@SuppressWarnings("unchecked")
	public Map<String, ConfigurationDefinition> getConfigurations() {
		return this.configurations;
	}

	public void init() {
		this.configurations = ConfigurationReader.getInstance().read(
				SystemConstant.RESOURCES_COMM, ConfigurationDefinition.class);
		logger.debug("The communication's configurations ars {}",
				this.configurations.toString());
	}

	/**
	 * @return
	 */
	public static ConfigurationRegistry getInstance() {
		return instance;
	}

}
