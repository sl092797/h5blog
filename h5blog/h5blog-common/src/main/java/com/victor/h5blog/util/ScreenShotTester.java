/*
 * Creation : Feb 17, 2016
 */
package com.victor.h5blog.util;

import java.util.ArrayList;
import java.util.List;

public class ScreenShotTester {
	public static String toolPath="D:\\h5blog\\h5blog\\h5blog-web\\src\\main\\webapp\\ffmpeg\\ffmpegx86\\ffmpeg.exe";
	public static String oldPath="D:\\h5blog\\h5blog\\h5blog-web\\src\\main\\webapp\\upload\\video\\test2.mp4";
	public static String newPath="D:\\h5blog\\h5blog\\h5blog-web\\src\\main\\webapp\\upload\\video\\compressed\\test2.mp4";
	public static String jpegPath="D:\\h5blog\\h5blog\\h5blog-web\\src\\main\\webapp\\upload\\video\\compressed\\test2.jpg";
	public static void main(String[] args) {
		VideoCompressGenerator.compressVideo(toolPath, oldPath, newPath, "800", "600");
		VideoCompressGenerator.generateSnapShot(toolPath, oldPath, jpegPath);
	}
}
