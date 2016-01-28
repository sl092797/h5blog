/**
 * 
 */
package com.victor.h5blog.resource;

import java.net.URL;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * @author tangfan
 * @since 2015-10-12
 *
 */
public class FileResource extends Resource {

	public FileResource() {
		LOG = LoggerFactory.getLogger(FileResource.class);
	}

	@SuppressWarnings("unchecked")
	protected <E> ResourceProcessor getProcessor(final ClassLoader classLoader,
			final List<E> list, final ResourceFilter filter) {
		return new FileResourceProcessor(classLoader, (List<URL>) list, filter);
	}

}
