package com.victor.h5blog.action.manage;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.victor.h5blog.entity.vo.CatlogVo;
import com.victor.h5blog.entity.vo.GalleryVo;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.service.PhotoService;
import com.victor.h5blog.util.MediaUtils;

@Controller
@RequestMapping("/manage/photo")
public class ManagePhotoAction extends ManageBaseAction {
	
	@Autowired
	private PhotoService photoService;

	
	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap modelMap) {
		return "/manage/photo";
	}
	
	@RequestMapping(value = "/photoList.htm", method = RequestMethod.GET)
	public String photoList(@RequestParam(value = "galleryId") Long galleryId,HttpServletRequest request, ModelMap modelMap) {
		GalleryVo gv = new GalleryVo();
		Catlog c = catlogService.selectById(galleryId);
		BeanUtils.copyProperties(c, gv);
		gv.setPhotoList(photoService.findByGalleryId(galleryId));
		modelMap.addAttribute("galleryVo", gv);
		return "/manage/photoList";
	}
	
	@ResponseBody
	@RequestMapping(value = "/deletePhoto.json", method = RequestMethod.POST)
	public JsonVo<Long> deletePhoto(@RequestParam(value = "photoId") Long photoId,
			HttpServletRequest request, ModelMap modelMap) {
		JsonVo<Long> json = new JsonVo<Long>();
		try {
			photoService.deletePhotoById(request,photoId);
			json.setResult(true);
			json.setMsg("删除完毕");
		} catch (Exception e) {
			json.setResult(false);
			json.getErrors().put("error", "删除相册失败");
			logger.error(e.getMessage());
		}
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/deleteGallery.json", method = RequestMethod.POST)
	public JsonVo<Long> deleteGallery(@RequestParam(value = "galleryId") Long galleryId,
			HttpServletRequest request, ModelMap modelMap) {
		JsonVo<Long> json = new JsonVo<Long>();
		try {
			catlogService.deleteById(galleryId);
			photoService.deletePhotosByGalleryId(request,galleryId);
			json.setResult(true);
			json.setMsg("删除完毕");
		} catch (Exception e) {
			json.setResult(false);
			json.getErrors().put("error", "删除相册失败");
			logger.error(e.getMessage());
		}
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/newGallery.json", method = RequestMethod.POST)
	public JsonVo<Long> newGallery(@RequestParam(value = "galleryName") String galleryName,
			@RequestParam(value = "galleryDesc") String galleryDesc,@RequestParam(value = "galleryTag") String galleryTag,
			HttpServletRequest request, ModelMap modelMap) {
		JsonVo<Long> json = new JsonVo<Long>();
		try {
			Catlog catlog = new Catlog();
			catlog.setCatlogKey(PHOTO_CATLOG_KEY);
			catlog.setCatlogName(galleryName);
			catlog.setCatlogDesc(galleryDesc);
			catlog.setCatlogTag(galleryTag);
			catlog.setCreateDate(new Date());
			catlog.setCreateUser(this.getAdmin(request).getName());
			catlogService.insertCatlog(catlog);
			json.setResult(true);
			json.setT(catlog.getCatlogId());
			json.setMsg("新增完毕");
		} catch (Exception e) {
			json.setResult(false);
			json.getErrors().put("error", "新增相册失败");
			logger.error(e.getMessage());
		}
		return json;
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateGallery.json", method = RequestMethod.POST)
	public JsonVo<Long> updateGallery(@RequestParam(value = "galleryId") Long galleryId,@RequestParam(value = "galleryName") String galleryName,
			@RequestParam(value = "galleryDesc") String galleryDesc,@RequestParam(value = "galleryTag") String galleryTag,
			HttpServletRequest request, ModelMap modelMap) {
		JsonVo<Long> json = new JsonVo<Long>();
		try {
			Catlog catlog = catlogService.selectById(galleryId);
			catlog.setCatlogName(galleryName);
			catlog.setCatlogDesc(galleryDesc);
			catlog.setCatlogTag(galleryTag);
			catlog.setChangeDate(new Date());
			catlog.setChangeUser(this.getAdmin(request).getName());
			catlogService.updateById(catlog);
			json.setResult(true);
			json.setT(catlog.getCatlogId());
			json.setMsg("修改完毕");
		} catch (Exception e) {
			json.setResult(false);
			json.getErrors().put("error", "修改相册失败");
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
	            List<Photo> plist = new ArrayList<Photo>();
	            Long galleryId = null;
	            Catlog catlog = null;
	            while(it.hasNext()){
	                FileItem item = (FileItem)it.next();
	                if(item.isFormField()){
	                	if(item.getFieldName().equalsIgnoreCase("galleryId")){
	                		galleryId =Long.parseLong(item.getString());
	                		catlog = catlogService.selectById(galleryId);
	                	}
	                }else{
		                //判断items中的文本信息
		                    if(item.getName()!=null&&!item.getName().equals("")){
		                        System.out.println("所上传的文件名称："+item.getName());
		                        System.out.println("所上传的文件大小："+item.getSize());
		                        System.out.println("所上传的文件类别："+item.getContentType());   
		                        String fileRoot = request.getSession().getServletContext().getRealPath(File.separator);
		                        System.out.println(fileRoot);
		                        String path = MediaUtils.saveImage(item.getInputStream(), 1024, 0, fileRoot,item.getName());
		                        Photo p = new Photo();
		                        p.setPhotoName(item.getName());
		                        p.setPhotoPath(path);
		                        p.setCreateUser(this.getAdmin(request).getName());
		                        p.setCreateDate(new Date());
		                        plist.add(p);
		                    }
	                }//end else 
	            }//end while
	            for(Photo p:plist){
	            	p.setCatlogId(galleryId);
	            	photoService.addPhoto(p);
	            	 if(catlog!=null&&
	            			 (catlog.getCatlogCoverid()==null||
	            			 (catlog.getCatlogCoverid()!=null&&photoService.selectById(catlog.getCatlogCoverid())==null))){
	 	            	catlog.setCatlogCoverid(p.getPhotoId());
	 	            	catlogService.updateById(catlog);
	 	            }
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
