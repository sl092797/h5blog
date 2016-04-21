package com.victor.h5blog.action.front;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.victor.h5blog.action.manage.ManageBaseAction;
import com.victor.h5blog.entity.Catlog;
import com.victor.h5blog.entity.Photo;
import com.victor.h5blog.entity.vo.CatlogVo;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.service.PhotoService;

@Controller
@RequestMapping("/front/photo")
public class PhotoAction extends ManageBaseAction{
	@Autowired
	private PhotoService photoService;
	
	@ResponseBody
	@RequestMapping(value = "/getGallerys.json", method = RequestMethod.POST)
	public JsonVo<List<CatlogVo>> getGallerys(
			HttpServletRequest request, ModelMap modelMap) {
		JsonVo<List<CatlogVo>> json = new JsonVo<List<CatlogVo>>();
		try {
			List<Catlog> catlogList = catlogService.selectByKey(PHOTO_CATLOG_KEY);
			List<CatlogVo> resultList = new ArrayList<CatlogVo>();
			for(Catlog catlog:catlogList){
				CatlogVo cv = new CatlogVo();
				Long photoId = catlog.getCatlogCoverid();
				BeanUtils.copyProperties(catlog, cv);
				if (photoId!=null){
					Photo p = photoService.selectById(photoId);
					if(p!=null){
						cv.setCoverFilePath(photoService.selectById(photoId).getPhotoPath());
					}
				}
				resultList.add(cv);
			}
			json.setResult(true);
			json.setT(resultList);
		} catch (Exception e) {
			json.setResult(false);
			json.getErrors().put("error", "获取相册列表失败");
			logger.error(e.getMessage());
		}
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getPhotos.json", method = RequestMethod.POST)
	public JsonVo<List<Photo>> getPhotos(@RequestParam(value = "galleryId") Long galleryId,
			HttpServletRequest request, ModelMap modelMap) {
		JsonVo<List<Photo>> json = new JsonVo<List<Photo>>();
		try {
			List<Photo> photoList = photoService.findByGalleryId(galleryId);
			json.setResult(true);
			json.setT(photoList);
		} catch (Exception e) {
			json.setResult(false);
			json.getErrors().put("error", "获取相片列表失败");
			logger.error(e.getMessage());
		}
		return json;
	}
}
