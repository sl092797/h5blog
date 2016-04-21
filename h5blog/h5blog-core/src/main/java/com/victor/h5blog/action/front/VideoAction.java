package com.victor.h5blog.action.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.victor.h5blog.action.manage.ManageBaseAction;
import com.victor.h5blog.annotation.SystemControllerLog;
import com.victor.h5blog.entity.Catlog;
import com.victor.h5blog.entity.Video;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.service.PhotoService;
import com.victor.h5blog.service.VideoService;

@Controller
@RequestMapping("/front/video")
public class VideoAction extends ManageBaseAction{
	@Autowired
	private VideoService videoService;
	
	@RequestMapping(value = "/playVideo.htm", method = RequestMethod.GET)
	@SystemControllerLog(description = "进入首页")
	public String playVideo(@RequestParam(value = "video") Long videoId,
			ModelMap modelMap, HttpServletRequest request) {
		Video v = videoService.selectById(videoId);
		modelMap.addAttribute("Video", v);
		return "front/playVideo";
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
}
