package com.victor.h5blog.resource;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tangfan
 *
 */
public class DirTraversal implements Traversal {

	private static Logger LOG = LoggerFactory.getLogger(DirTraversal.class);

	@SuppressWarnings("deprecation")
	public void traverse(final URL url, final String resourceName,
			final ResourceProcessor processor) {
		final String filePath = URLDecoder.decode(url.getFile());
		final File curDirectory = new File(filePath);
		traverseDirectory(curDirectory, resourceName, processor);
	}

	private void traverseDirectory(final File directory,
			final String resourceName, final ResourceProcessor processor) {
		if (directory.exists() && directory.isDirectory()) {
			final File[] files = directory.listFiles();
			for (File file : files) {
				LOG.debug("Current file name is {}", file.getName());
				final String logicPath = resourceName.concat("/").concat(
						file.getName());
				LOG.debug("Current file path is {}", logicPath);
				if (file.isDirectory()) {
					traverseDirectory(file, logicPath, processor);
				} else {
					processor.process(logicPath, "");
				}
			}
		}
	}
}
