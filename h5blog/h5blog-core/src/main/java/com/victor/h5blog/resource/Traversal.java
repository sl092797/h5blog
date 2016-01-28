package com.victor.h5blog.resource;

import java.net.URL;

/**
 * @author tangfan
 * @since 2015-10-12
 *
 */
public interface Traversal {

	public void traverse(final URL url, final String resource,
			final ResourceProcessor processor);

}
