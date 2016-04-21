/*
 * Creation : Jan 29, 2016
 */
package com.victor.h5blog.util;

import java.util.ArrayList;
import java.util.List;


/**
 * generate screen shot by ffmpeg
 * 
 * @see http://ffmpeg.org
 */
public class VideoCompressGenerator {

	public final static String TOOL_PATH="ffmpeg\\ffmpegx86\\ffmpeg.exe";
	
    public static boolean generateSnapShot(String toolPath,String videoPath, String jpegPath) {
        List<String> commend = new ArrayList<String>();
        commend.add(toolPath);// 视频提取工具的位置
        commend.add("-i");
        commend.add(videoPath);
        commend.add("-y");
        commend.add("-f");
        commend.add("image2");
        commend.add("-ss");
        commend.add("10");
        commend.add("-t");
        commend.add("0.001");
        commend.add("-s");
        commend.add("360x240");
        commend.add(jpegPath);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            builder.start();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean compressVideo(String toolPath,String oldPath, String newPath,String width,String height){
    	List<String> commend = new ArrayList<String>();
    	commend.add(toolPath);
    	commend.add("-i");
    	commend.add(oldPath);
    	commend.add("-s");
    	commend.add(width+"x"+height);
    	commend.add(newPath);
//    	commend.add(toolPath);
//    	commend.add("-i");
//    	commend.add(oldPath);
//    	commend.add("-s");
//    	commend.add(width+"x"+height);
//    	commend.add("-r");
//    	commend.add("29.97");
//    	commend.add("-b");
//    	commend.add("1500");
//    	commend.add("-acodec");
//    	commend.add("aac");
//    	commend.add("-ac");
//    	commend.add("2");
//    	commend.add("-ar");
//    	commend.add("24000");
//    	commend.add("-ab");
//    	commend.add("128");
//    	commend.add(newPath);
		try {
			Process videoProcess = new ProcessBuilder(commend).start();
            
			new PrintStream(videoProcess.getErrorStream()).start();
			            
			new PrintStream(videoProcess.getInputStream()).start();
			            
			videoProcess.waitFor();
			            
			return true;
			// return true;
		} catch (Exception e) {
			e.printStackTrace();
			 return false;
		}
    }
    
}
