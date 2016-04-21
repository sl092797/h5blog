package com.victor.h5blog.action.manage;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.victor.h5blog.entity.Catlog;
import com.victor.h5blog.entity.Photo;
import com.victor.h5blog.entity.Video;
import com.victor.h5blog.entity.vo.CatlogVo;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.service.PhotoService;
import com.victor.h5blog.service.VideoService;
import com.victor.h5blog.util.MediaUtils;
import com.victor.h5blog.util.VideoCompressGenerator;

@Controller
@RequestMapping("/manage/video")
public class ManageVideoAction extends ManageBaseAction {
		@Autowired
		private VideoService videoService;
		
		@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
		public String index(HttpServletRequest request, ModelMap modelMap) {
			List<Catlog> catlogList = catlogService.selectByKey(VIDEO_CATLOG_KEY);
			List<Video> videos = new ArrayList<Video>();
			if(catlogList.size()>0){
				videos = videoService.findByCatlogId(catlogList.get(0).getCatlogId());
			}
			modelMap.addAttribute("VideoList", catlogList);
			modelMap.addAttribute("Videos", videos);
			return "/manage/video";
		}
		
		@ResponseBody
		@RequestMapping(value = "/newVideoList.json", method = RequestMethod.POST)
		public JsonVo<Long> newVideoList(@RequestParam(value = "catlogName") String catlogName,
				@RequestParam(value = "catlogDesc") String catlogDesc,
				HttpServletRequest request, ModelMap modelMap) {
			JsonVo<Long> json = new JsonVo<Long>();
			try {
				Catlog catlog = new Catlog();
				catlog.setCatlogKey(VIDEO_CATLOG_KEY);
				catlog.setCatlogName(catlogName);
				catlog.setCatlogDesc(catlogDesc);
				catlog.setCreateDate(new Date());
				catlog.setCreateUser(this.getAdmin(request).getName());
				catlogService.insertCatlog(catlog);
				json.setResult(true);
				json.setT(catlog.getCatlogId());
				json.setMsg("新增视频分类完毕");
			} catch (Exception e) {
				json.setResult(false);
				json.getErrors().put("error", "新增视频分类失败");
				logger.error(e.getMessage());
			}
			return json;
		}
		
		@ResponseBody
		@RequestMapping(value = "/updateVideoList.json", method = RequestMethod.POST)
		public JsonVo<Long> updateVideoList(@RequestParam(value = "update_catlogId") Long catlogId,
				@RequestParam(value = "update_catlogName") String catlogName,@RequestParam(value = "update_catlogDesc") String catlogDesc,
				HttpServletRequest request, ModelMap modelMap) {
			JsonVo<Long> json = new JsonVo<Long>();
			try {
				Catlog catlog = new Catlog();
				catlog.setCatlogId(catlogId);
				catlog.setCatlogKey(VIDEO_CATLOG_KEY);
				catlog.setCatlogName(catlogName);
				catlog.setCatlogDesc(catlogDesc);
				catlog.setChangeUser(this.getAdmin(request).getName());
				catlogService.updateById(catlog);
				json.setResult(true);
				json.setT(catlog.getCatlogId());
				json.setMsg("修改视频分类完毕");
			} catch (Exception e) {
				json.setResult(false);
				json.getErrors().put("error", "修改视频分类失败");
				logger.error(e.getMessage());
			}
			return json;
		}
		
		//获取视频分类列表
		@ResponseBody
		@RequestMapping(value = "/getVideoList.json", method = RequestMethod.POST)
		public JsonVo<List<Catlog>> getVideoList(
				HttpServletRequest request, ModelMap modelMap) {
			JsonVo<List<Catlog>> json = new JsonVo<List<Catlog>>();
			try {
				List<Catlog> catlogList = catlogService.selectByKey(VIDEO_CATLOG_KEY);
				json.setResult(true);
				json.setT(catlogList);
			} catch (Exception e) {
				json.setResult(false);
				json.getErrors().put("error", "获取视频列表失败");
				logger.error(e.getMessage());
			}
			return json;
		}
		
		//获取视频分类下的所有视频
				@ResponseBody
				@RequestMapping(value = "/getVideos.json", method = RequestMethod.POST)
				public JsonVo<List<Video>> getVideos(@RequestParam(value = "catlogId") Long catlogId,
						HttpServletRequest request, ModelMap modelMap) {
					JsonVo<List<Video>> json = new JsonVo<List<Video>>();
					try {
						List<Video> vlist = videoService.findByCatlogId(catlogId);
						json.setResult(true);
						json.setT(vlist);
					} catch (Exception e) {
						json.setResult(false);
						json.getErrors().put("error", "获取视频失败");
						logger.error(e.getMessage());
					}
					return json;
				}
				
			@ResponseBody
			@RequestMapping(value = "/deleteVideo.json", method = RequestMethod.POST)
			public JsonVo<Long> deletePhoto(@RequestParam(value = "videoId") Long videoId,
					HttpServletRequest request, ModelMap modelMap) {
				JsonVo<Long> json = new JsonVo<Long>();
				try {
					videoService.deleteVideoById(request,videoId);
					json.setResult(true);
					json.setMsg("删除完毕");
				} catch (Exception e) {
					json.setResult(false);
					json.getErrors().put("error", "删除视频失败");
					logger.error(e.getMessage());
				}
				return json;
			}
		
		
		@ResponseBody
		@RequestMapping(value = "/upload.json", method = RequestMethod.POST)
		public JsonVo<String> upload(
				HttpServletRequest request, ModelMap modelMap) throws UnsupportedEncodingException {
			JsonVo<String> json = new JsonVo<String>();
			//设置编码格式
			request.setCharacterEncoding("utf-8");
			//使用FileItemFactory创建新的文件项目 
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//FileUpload用来解析request文件上传请求
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
		            //获取请求的信息存入列表list中
		            List<FileItem> tempList = upload.parseRequest(request);
		            Iterator<FileItem> it = tempList.iterator();
		            List<Video> vlist = new ArrayList<Video>();
		            Long catlogId = null;
		            Catlog catlog = null;
		            while(it.hasNext()){
		                FileItem item = (FileItem)it.next();
		                if(item.isFormField()){
		                	if(item.getFieldName().equalsIgnoreCase("catlogId")){
		                		catlogId =Long.parseLong(item.getString());
		                		catlog = catlogService.selectById(catlogId);
		                	}
		                }else{
			                //判断items中的文本信息
			                    if(item.getName()!=null&&!item.getName().equals("")){
			                        System.out.println("所上传的文件名称："+item.getName());
			                        System.out.println("所上传的文件大小："+item.getSize());
			                        System.out.println("所上传的文件类别："+item.getContentType());   
			                        String fileRoot = request.getSession().getServletContext().getRealPath(File.separator);
			                        System.out.println(fileRoot);
			                        SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
			                		String oldPath = MediaUtils.UPLOAD_VIDEO_PATH + formater.format(new Date()) + "/"
			                				+ item.getName();
			                		File file = new File(fileRoot+ "/" + oldPath);
			                        String toolPath = fileRoot+"/"+VideoCompressGenerator.TOOL_PATH;
			                        String newPath = oldPath.substring(0, oldPath.lastIndexOf('/'))+"/compressed/"+item.getName().substring(0,item.getName().lastIndexOf("."))+".mp4";
			                        String jpegPath = oldPath.substring(0, oldPath.lastIndexOf('/'))+"/compressed/"+item.getName().substring(0,item.getName().lastIndexOf("."))+".jpg";
			                        File newFile = new File(fileRoot+ "/" + newPath);
			                        File newJpeg = new File(fileRoot+ "/" + jpegPath);
			                        if (!file.getParentFile().exists()) {
			                			file.getParentFile().mkdirs();
			                		}
			                        if (!newFile.getParentFile().exists()) {
			                        	newFile.getParentFile().mkdirs();
			                		}
			                        if (!newJpeg.getParentFile().exists()) {
			                        	newJpeg.getParentFile().mkdirs();
			                		}
			                        item.write(file);
			                        VideoCompressGenerator.compressVideo(toolPath, fileRoot+ "/" + oldPath, fileRoot+ "/" + newPath, "960", "540");
			                		VideoCompressGenerator.generateSnapShot(toolPath, fileRoot+ "/" + oldPath, fileRoot+ "/" + jpegPath);
			                        Video v = new Video();
			                        v.setVideoName(item.getName());
			                        v.setVideoOriginalpath(oldPath);
			                        v.setVideoPosterpath(jpegPath);
			                        v.setVideoCompressedpath(newPath);
			                        v.setCreateUser(this.getAdmin(request).getName());
			                        v.setCreateDate(new Date());
			                        vlist.add(v);
			                    }
		                }//end else 
		            }//end while
		            for(Video v:vlist){
		            	v.setCatlogId(catlogId);
		            	videoService.addVideo(v);
		            }
		        	json.setResult(true);
		            json.setMsg( "上传文件成功！");
			} catch (Exception e) {
				json.setResult(false);
				json.getErrors().put("error", "上传文件失败");
				logger.error(e.getMessage());
			}
			return json;
		}
}
