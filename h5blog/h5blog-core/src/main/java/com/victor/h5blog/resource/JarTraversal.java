package com.victor.h5blog.resource;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tangfan
 * @since 2015-10-12
 *
 */
public class JarTraversal implements Traversal {

	private static Logger LOG = LoggerFactory.getLogger(JarTraversal.class);

	public void traverse(final URL url, final String resourceName,
			final ResourceProcessor processor) {
		JarFile file = null;
		try {
			JarURLConnection connection = (JarURLConnection) url
					.openConnection();
			file = connection.getJarFile();
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		for (Enumeration<JarEntry> en = file.entries(); en.hasMoreElements();) {
			JarEntry entry = en.nextElement();
			final String entryName = entry.getName();
			LOG.debug("Current entry name is {}", entryName);
			processor.process(entryName, resourceName);
		}
	}

}
