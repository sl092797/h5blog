package com.victor.h5blog;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.victor.h5blog.model.Identity;
import com.victor.h5blog.resource.FileResource;
import com.victor.h5blog.resource.ResourceFilter;

/**
 * @author tangfan
 * @since 2015-10-12
 *
 */
public class ConfigurationReader {

	private static Logger logger = LoggerFactory
			.getLogger(ConfigurationReader.class);

	private FileResource fileResource = new FileResource();

	private static volatile ConfigurationReader instance;

	@SuppressWarnings({ "unchecked" })
	public <T> Map<String, T> read(String resourceName, String packagePath,
			ClassLoader classLoader) {
		Map<String, T> cache = null;
		String urlstring = "";
		try {
			final List<URL> urls = fileResource.collect(resourceName,
					ConfigurationReader.class.getClassLoader(),
					new ResourceFilter() {
						public <R> boolean filter(R resource) {
							return ((String) resource).endsWith(".xml");
						}
					});

			final JAXBContext context = JAXBContext.newInstance(packagePath,
					classLoader);
			final Unmarshaller unmarshaller = context.createUnmarshaller();

			cache = new HashMap<String, T>();
			T definition = null;
			for (URL url : urls) {
				urlstring = url.toString();
				definition = (T) unmarshaller.unmarshal(url);
				cache.put(((Identity) definition).getId(), definition);
			}
		} catch (JAXBException e) {
			logger.error("Error parsing file:{}", urlstring);
			logger.error(e.getMessage(), e);
		} catch (IllegalArgumentException e) {
			logger.error("Error parsing file:{}", urlstring);
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			logger.error("Error parsing file:{}", urlstring);
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return cache;
	}

	@SuppressWarnings({ "unchecked" })
	public <T> Map<String, T> read(String resourceName, Class<T> clazz) {
		Class<?>[] interfaces = clazz.getInterfaces();
		boolean isIdentity = false;
		for (Class<?> inter : interfaces) {
			isIdentity = inter.equals(Identity.class) ? true : false;
		}
		if (!isIdentity) {
			throw new IllegalArgumentException(
					"Class is not implement Identity.");
		}
		Map<String, T> cache = null;
		String urlstring = "";
		try {
			final List<URL> urls = fileResource.collect(resourceName,
					ConfigurationReader.class.getClassLoader(),
					new ResourceFilter() {
						public <R> boolean filter(R resource) {
							return ((String) resource).endsWith(".xml");
						}
					});

			final JAXBContext context = JAXBContext.newInstance(clazz
					.getPackage().getName(), clazz.getClassLoader());
			final Unmarshaller unmarshaller = context.createUnmarshaller();

			cache = new HashMap<String, T>();

			List<Exception> exceptions = new ArrayList<Exception>();
			boolean exceptionFalg = false;
			/*
			 * To solve a problem that one file load error cases the subsequent
			 * file unable to load.
			 */
			for (URL url : urls) {
				T definition = null;
				try {
					urlstring = url.toString();
					definition = (T) unmarshaller.unmarshal(url);
				} catch (Exception e) {
					logger.error("Error parsing file: File Path Is  {}",
							urlstring);
					exceptionFalg = true;
					exceptions.add(e);
					continue;
				}
				cache.put(((Identity) definition).getId(), definition);
			}
			if (exceptionFalg && exceptions != null && exceptions.size() > 0) {
				throw exceptions.get(0);
			}
		} catch (JAXBException e) {
			logger.error("Error parsing file:{}", urlstring);
			logger.error(e.getMessage(), e);
		} catch (IllegalArgumentException e) {
			logger.error("Error parsing file:{}", urlstring);
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			logger.error("Error parsing file:{}", urlstring);
			logger.error(e.getMessage(), e);
		}
		return cache;
	}

	@SuppressWarnings({ "unchecked" })
	public <T> Map<String, Map<String, T>> readConfig(String resourceName,
			Class<T> clazz) {
		Class<?>[] interfaces = clazz.getInterfaces();
		boolean isIdentity = false;
		for (Class<?> inter : interfaces) {
			isIdentity = inter.equals(Identity.class) ? true : false;
		}
		if (!isIdentity) {
			throw new IllegalArgumentException(
					"Class is not implement Identity.");
		}
		Map<String, Map<String, T>> caches = new HashMap<String, Map<String, T>>();

		String urlstring = "";
		try {
			final List<URL> urls = fileResource.collect(resourceName,
					ConfigurationReader.class.getClassLoader(),
					new ResourceFilter() {
						public <R> boolean filter(R resource) {
							return ((String) resource).endsWith(".xml");
						}
					});

			final JAXBContext context = JAXBContext.newInstance(clazz
					.getPackage().getName(), clazz.getClassLoader());
			final Unmarshaller unmarshaller = context.createUnmarshaller();

			List<Exception> exceptions = new ArrayList<Exception>();
			boolean exceptionFalg = false;
			/*
			 * To solve a problem that one file load error cases the subsequent
			 * file unable to load.
			 */
			for (URL url : urls) {
				T definition = null;
				try {
					urlstring = url.toString();
					String[] param = urlstring.split("\\/");
					String tranCode = param[param.length - 1].split("\\.")[0];
					String channel = param[param.length - 2];

					definition = (T) unmarshaller.unmarshal(url);
					Map<String, T> cache = caches.get(channel);
					if (cache == null) {
						cache = new HashMap<String, T>();
						caches.put(channel, cache);
					}
					cache.put(tranCode, definition);
				} catch (Exception e) {
					logger.error("Error parsing file: File Path Is  {}",
							urlstring);
					exceptionFalg = true;
					exceptions.add(e);
					continue;
				}

			}
			if (exceptionFalg && exceptions != null && exceptions.size() > 0) {
				throw exceptions.get(0);
			}
		} catch (JAXBException e) {
			logger.error("Error parsing file:{}", urlstring);
			logger.error(e.getMessage(), e);
		} catch (IllegalArgumentException e) {
			logger.error("Error parsing file:{}", urlstring);
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			logger.error("Error parsing file:{}", urlstring);
			logger.error(e.getMessage(), e);
		}
		return caches;
	}

	public Map<String, Map<String, String>> readClass(String resourceName) {

		final List<URL> urls = fileResource.collect(resourceName,
				ConfigurationReader.class.getClassLoader(),
				new ResourceFilter() {
					public <R> boolean filter(R resource) {
						return ((String) resource).endsWith(".class");
					}
				});
		String path = null;
		Map<String, Map<String, String>> classMaps = new HashMap<String, Map<String, String>>();
		for (URL url : urls) {
			try {
				// URLConnection conn = url.openConnection();
				String urlStr = url.toString();
				String[] param = urlStr.split("\\/");
				String tranCode = param[param.length - 1].split("\\.")[0];
				String channel = param[param.length - 2];
				Map<String, String> classMap = classMaps.get(channel);
				if (classMap == null) {
					classMap = new HashMap<String, String>();
					classMaps.put(channel, classMap);
				}
				classMap.put(tranCode, resourceName + "." + channel + "."
						+ tranCode);
			} catch (Exception e) {
				logger.error("Error parsing file: File Path Is  {}", path);
				continue;
			}
		}

		return classMaps;
	}

	public Map<String, Map<String, File>> readTemplate(String resourceName) {

		final List<URL> urls = fileResource.collect(resourceName,
				ConfigurationReader.class.getClassLoader(),
				new ResourceFilter() {
					public <R> boolean filter(R resource) {
						return ((String) resource).endsWith(".ftl");
					}
				});
		String path = null;
		Map<String, Map<String, File>> filesMaps = new HashMap<String, Map<String, File>>();
		for (URL url : urls) {
			try {
				// URLConnection conn = url.openConnection();

				String urlStr = url.toString();
				File file = new File(urlStr.substring(5,
						urlStr.lastIndexOf("/")));
				String[] param = urlStr.split("\\/");
				String tranCode = param[param.length - 1].split("\\.")[0];
				String channel = param[param.length - 2];
				Map<String, File> filesMap = filesMaps.get(channel);
				if (filesMap == null) {
					filesMap = new HashMap<String, File>();
					filesMaps.put(channel, filesMap);
				}
				filesMap.put(tranCode, file);
			} catch (Exception e) {
				logger.error("Error load templage file: File Path Is  {}", path);
				continue;
			}
		}

		return filesMaps;
	}

	@SuppressWarnings({ "unchecked" })
	public <T> T reload(String resourceName, Class<T> clazz)
			throws JAXBException {
		Class<?>[] interfaces = clazz.getInterfaces();
		boolean isIdentity = false;
		for (Class<?> inter : interfaces) {
			isIdentity = inter.equals(Identity.class) ? true : false;
		}
		if (!isIdentity) {
			throw new IllegalArgumentException(
					"Class is not implement Identity.");
		}
		final JAXBContext context = JAXBContext.newInstance(clazz.getPackage()
				.getName(), clazz.getClassLoader());
		final Unmarshaller unmarshaller = context.createUnmarshaller();
		T definition = (T) unmarshaller.unmarshal(new File(resourceName));
		return definition;
	}

	public static ConfigurationReader getInstance() {
		if (instance == null) {
			instance = new ConfigurationReader();
		}
		return instance;
	}

}
