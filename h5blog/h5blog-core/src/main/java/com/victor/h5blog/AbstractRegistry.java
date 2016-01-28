package com.victor.h5blog;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tangfan
 * @since 2015-10-12
 *
 */
public abstract class AbstractRegistry<K, V> implements Registry {

	protected Map<K, V> configurations;

	protected Logger logger;

	protected AbstractRegistry(Class<? extends AbstractRegistry<K, V>> clazz) {
		this.logger = LoggerFactory.getLogger(clazz);
		configurations = new ConcurrentHashMap<K, V>();
	}

	public abstract void init();

	@SuppressWarnings("unchecked")
	public Map<K, V> getConfigurations() {
		return configurations;
	}

}
