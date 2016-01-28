/**
 * 
 */
package com.victor.h5blog.resource;

/**
 * @author tangfan
 * @since 2015-10-12
 *
 */
public interface ResourceFilter {

	public <R> boolean filter(R resource);

}
