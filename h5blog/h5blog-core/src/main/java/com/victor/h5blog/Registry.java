package com.victor.h5blog;

import java.util.Map;

/**
 * @author tangfan
 * @since 2015-10-12
 *
 */
public interface Registry {

	public <K, V> Map<K, V> getConfigurations();

}
