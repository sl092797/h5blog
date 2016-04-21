/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package com.victor.h5blog.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import org.apache.commons.fileupload.FileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.victor.h5blog.constant.SystemConstant;

/**
 * @author Herbert
 * 
 */
public class MediaUtils {
	
	private static Logger logger = LoggerFactory.getLogger(MediaUtils.class);

	public static String UPLOAD_PHOTO_PATH = "upload/photo/";
	public static String UPLOAD_VIDEO_PATH = "upload/video/";
	
	/**
	 * 文件允许格式
	 */
	public static String[] FILE_TYPE = { ".rar", ".doc", ".docx", ".zip",
			".pdf", ".txt", ".swf", ".wmv", "ftl" };

	/**
	 * 图片允许格式
	 */
	public static String[] PHOTO_TYPE = { ".gif", ".png", ".jpg", ".jpeg",
			".bmp" };
	

	public static boolean isFileType(String fileName, String[] typeArray) {
		for (String type : typeArray) {
			if (fileName.toLowerCase().endsWith(type)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 递归获得目录的所有地址
	 * 
	 * @param realpath
	 * @param files
	 * @param fileType
	 * @return
	 */
	public static List<java.io.File> getFiles(String realpath,
			List<File> files, String[] fileType) {
		File realFile = new File(realpath);
		if (realFile.isDirectory()) {
			File[] subfiles = realFile.listFiles();
			for (File file : subfiles) {
				if (file.isDirectory()) {
					getFiles(file.getAbsolutePath(), files, fileType);
				} else {
					if (isFileType(file.getName(), fileType)) {
						files.add(file);
					}
				}
			}
		}
		return files;
	}

	/**
	 * 得到文件上传的相对路径
	 * 
	 * @param fileName
	 *            文件名
	 * @return
	 */
	public static String getPath(String fileName) {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		String uploadPath = "upload/" + formater.format(new Date()) + "/"
				+ UUID.randomUUID().toString().replaceAll("-", "")
				+ getFileExt(fileName);
		return uploadPath;
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @return string
	 */
	public static String getFileExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 删除物理文件
	 * 
	 * @param path
	 */
	public static void deleteFile(String path) {
		File file = new File(SystemConstant.LEGOO_CMS_ROOT + path);
		file.delete();
	}

	/**
	 * 保存，并裁剪图片
	 * 
	 * @param multipartFile
	 * @param width
	 * @param height
	 * @throws IOException
	 */
	public static String saveImage(InputStream inStream, int width,
			int height,String fileRoot,String fileName) throws IOException {
		logger.info("压缩图片尺寸："+width+" x "+height);
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		String path = UPLOAD_PHOTO_PATH + formater.format(new Date()) + "/"
				+ fileName;
		String filePath = fileRoot+ "/" + path;
		File file = new File(filePath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		if (width > 0 && height > 0) {
			BufferedImage bufferedImage = ImageIO.read(inStream);
			int imageWidth = bufferedImage.getWidth();
			int imageHeitht = bufferedImage.getHeight();
			BufferedImage image = null;
			if (width / height < imageWidth / imageHeitht) {
				image = Thumbnails.of(inStream)
						.height(height).asBufferedImage();
			} else {
				image = Thumbnails.of(inStream)
						.width(width).asBufferedImage();
			}
			Thumbnails.of(image).sourceRegion(Positions.CENTER, width, height)
					.size(width, height).outputFormat("jpg").toFile(filePath);

		} else {
			if (width == 0 && height == 0) {
				Thumbnails.of(inStream)
				.keepAspectRatio(true).outputFormat("jpg")
				.toFile(filePath);
			} else {
				if (width > 0) {
					Thumbnails.of(inStream).width(width)
							.keepAspectRatio(true).outputFormat("jpg")
							.toFile(filePath);
				}
				if (height > 0) {
					Thumbnails.of(inStream)
							.height(height).keepAspectRatio(true)
							.outputFormat("jpg").toFile(filePath);
				}
			}
		}
		// FileOutputStream fos = new FileOutputStream(file);
		// baos.writeTo(fos);
		return path;
	}

	/**
	 * @param multipartFile
	 * @return
	 */
	public static String save(MultipartFile multipartFile) {
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
		String path = "upload/" + formater.format(new Date()) + "/"
				+ UUID.randomUUID().toString().replaceAll("-", "")
				+ getFileExt(multipartFile.getOriginalFilename());
		File file = new File(SystemConstant.LEGOO_CMS_ROOT + "/" + path);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		return path;
	}
	
	public static String save(MultipartFile multipartFile, String path) throws IOException {
		path = path + "/"
				+ multipartFile.getOriginalFilename();
		File file = new File(SystemConstant.LEGOO_CMS_ROOT + "/" + path);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		write(multipartFile.getInputStream(), file);
		return file.getAbsolutePath();
	}
	
	private static boolean write(InputStream inputStream ,File f){
		boolean ret = false;

		OutputStream outputStream = null;

		try {
			outputStream = new FileOutputStream(f);

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			ret = true;

		} catch (IOException e) {
			logger.error("", e);

		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.error("", e);
				}
			}
			if (outputStream != null) {
				try {
					outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					logger.error("", e);
				}

			}
		}
		return ret;
	}
	/**
	 * 循环指定文件夹获取所有模板文件
	 * @param file
	 * @param files
	 * @return
	 */
	public static List<File> findTplFiles(File file, List<File> files){
		if(file.isDirectory()){
			 File[] fileList = file.listFiles();
			 for(File f : fileList){
				 findTplFiles(f, files);
			 }
		}else{
			if(file.getName().endsWith(".ftl")){
				files.add(file);
			}
		}
		return files;
	}

}
