package com.victor.h5blog.resource;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.slf4j.Logger;

/**
 * @author tangfan
 * @since 2015-10-12
 *
 */

public abstract class Resource {

	protected Logger LOG;

	public <E> List<E> collect(final String resourceName,
			final ClassLoader classLoader, final ResourceFilter filter) {
		final String resourceDir = resourceName.replace(".", "/");
		Enumeration<URL> urls = null;
		try {
			urls = classLoader
					.getResources(resourceDir.endsWith("/") ? resourceDir
							: resourceDir.concat("/"));
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		List<E> result = new ArrayList<E>();
		ResourceProcessor processor = getProcessor(classLoader, result, filter);
		while (urls.hasMoreElements()) {
			URL url = urls.nextElement();
			if ("jar".equals(url.getProtocol())) {
				JarTraversal pt = new JarTraversal();
				pt.traverse(url, resourceDir, processor);
			} else if ("file".equals(url.getProtocol())) {
				DirTraversal dt = new DirTraversal();
				dt.traverse(url, resourceDir, processor);
			}
		}
		return result;
	}

	/**
	 * @return
	 */
	protected abstract <E> ResourceProcessor getProcessor(
			ClassLoader classLoader, final List<E> list,
			final ResourceFilter filter);

}
