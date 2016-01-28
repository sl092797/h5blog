package com.victor.h5blog.resource;

import java.util.List;

/**
 * @author tangfan
 * @since 2015-10-12
 *
 */
public abstract class AbstractResourceProcessor<E> implements ResourceProcessor {

	protected List<E> list;

	protected ResourceFilter filter;

	protected ClassLoader classLoader;

	/**
	 * @param list
	 * @param filter
	 */
	public AbstractResourceProcessor(final ClassLoader classLoader,
			final List<E> list, final ResourceFilter filter) {
		super();
		this.classLoader = classLoader;
		this.list = list;
		this.filter = filter;
	}

	protected boolean check(String curResource, final String prefix,
			final String suffix) {
		boolean result = ((prefix == null || "".equals(prefix)) ? true
				: curResource.startsWith(prefix))
				&& curResource.endsWith(suffix)
				&& curResource.indexOf("$") == -1;
		return result;
	}

}
