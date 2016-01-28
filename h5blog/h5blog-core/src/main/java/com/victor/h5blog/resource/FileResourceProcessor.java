package com.victor.h5blog.resource;

import java.net.URL;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tangfan
 * @since 2015-10-12
 * 
 */
public class FileResourceProcessor extends AbstractResourceProcessor<URL> {

	private static Logger LOG = LoggerFactory
			.getLogger(FileResourceProcessor.class);

	/**
	 * @param list
	 * @param filter
	 */
	public FileResourceProcessor(final ClassLoader classLoader,
			final List<URL> list, final ResourceFilter filter) {
		super(classLoader, list, filter);
	}

	public void process(final String... resources) {
		URL url = this.classLoader.getResource(resources[0]);
		if (this.filter != null && this.filter.filter(url.getPath())
				&& resources[0].startsWith(resources[1])) {
			LOG.debug("Current xml's url is {}", url.getPath());
			this.list.add(url);
		}
	}

}
