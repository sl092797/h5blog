package com.victor.h5blog.action.manage;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

import com.victor.h5blog.annotation.SystemControllerLog;
import com.victor.h5blog.entity.Catlog;
import com.victor.h5blog.entity.Photo;
import com.victor.h5blog.entity.vo.CatlogVo;
import com.victor.h5blog.entity.vo.GalleryVo;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.service.FileService;
import com.victor.h5blog.service.PhotoService;
import com.victor.h5blog.util.MediaUtils;

@Controller
@RequestMapping("/manage/file")
public class ManageFileAction extends ManageBaseAction {
	
	@Autowired
	private FileService fileService;

	
	@RequestMapping(value = "/index.htm", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap modelMap) {
		return "/manage/file";
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
	            List<com.victor.h5blog.entity.File> flist = new ArrayList<com.victor.h5blog.entity.File>();
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
		                		String path = MediaUtils.UPLOAD_FILE_PATH + formater.format(new Date()) + "/"
		                				+ item.getName();
		                		String filePath = fileRoot+ "/" + path;
		                		File file = new File(filePath);
		                		if (!file.getParentFile().exists()) {
		                			file.getParentFile().mkdirs();
		                		}
		                		item.write(file);
		                        com.victor.h5blog.entity.File f = new com.victor.h5blog.entity.File();
		                        f.setFileName(item.getName());
		                        f.setFilePath(path);
		                        long size = item.getSize();
		                        float sizef = (float)size/(1024*1024);
		                        f.setFileSize(sizef);
		                        f.setCreateUser(this.getAdmin(request).getName());
		                        f.setCreateDate(new Date());
		                        flist.add(f);
		                    }
	                }//end else 
	            }//end while
	            for(com.victor.h5blog.entity.File f:flist){
	            	f.setCatlogId(catlogId);
	            	fileService.addFile(f);
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
	
	/**
	 * 获取目录树结构
	 * 
	 * @return
	 */
	@SystemControllerLog(description = "获取组件目录树结构")
	@ResponseBody
	@RequestMapping(value = "/getTree.json", method = RequestMethod.POST)
	public Catlog getTree(HttpServletRequest request) {
		List<Catlog> catlogList = catlogService.selectByKey(FILE_CATLOG_KEY);
		Map<Long, Catlog> catlogMap = new HashMap<Long, Catlog>();
		List<Catlog> catlogTree = new ArrayList<Catlog>();
		for (Catlog catlog : catlogList) {
			Long catlogId = catlog.getCatlogId();
			Long parentId = catlog.getCatlogFatherId();
			
			Catlog catlogVo = catlogMap.get(catlogId);
			//判断当前catlog是否是父节点
			if (catlogVo == null) {
				//不是父节点添加空的孩子列表
				List<Catlog> child = new ArrayList<Catlog>();
				catlog.setChild(child);
			} else {
				//是父节点，将已添加的孩子节点添加到page的孩子列表中
				List<Catlog> child = catlogVo.getChild();
				catlog.setChild(child);
			}

			if (parentId == null || parentId.equals(0L)) {
				catlogTree.add(catlog);
			} else {
				Catlog parentPage = catlogMap.get(parentId);
				if (parentPage == null) {
					parentPage = new Catlog();
					List<Catlog> child = new ArrayList<Catlog>();
					child.add(catlog);
					parentPage.setChild(child);
					catlogMap.put(parentId, parentPage);
				} else {
					//page的父节点已经在map中，将当前page放在父节点的孩子列表中
					parentPage.getChild().add(catlog);
				}
			}
			catlogMap.put(catlogId, catlog);
		}
		Catlog catlog = new Catlog();
		catlog.setCatlogName("文件类别");
		catlog.setChild(catlogTree);
		catlog.setCatlogId(0l);

		return catlog;
	}
	
	@SystemControllerLog(description = "修改文件目录")
	@ResponseBody
	@RequestMapping(value = "/updateCatlog.json", method = RequestMethod.POST)
	public JsonVo<String> updateCatlog(HttpServletRequest request,
			@RequestParam(value = "ucatlogId") Long ucatlogId,
			@RequestParam(value = "ucatlogName") String ucatlogName,
			@RequestParam(value = "ucatlogDesc") String ucatlogDesc) {
		JsonVo<String> json = new JsonVo<String>();
		Catlog catlog = catlogService.selectById(ucatlogId);
		catlog.setCatlogName(ucatlogName);
		catlog.setCatlogDesc(ucatlogDesc);
		catlog.setChangeDate(new Date());
		catlog.setChangeUser(this.getAdmin(request).getName());
		catlogService.updateById(catlog);
		json.setResult(true);
		 json.setMsg( "修改文件目录成功！");
		return json;
	}
	
	@SystemControllerLog(description = "修改文件")
	@ResponseBody
	@RequestMapping(value = "/updateFile.json", method = RequestMethod.POST)
	public JsonVo<String> updateFile(HttpServletRequest request,
			@RequestParam(value = "ufileId") Long ufileId,
			@RequestParam(value = "ufileDesc") String ufileDesc) {
		JsonVo<String> json = new JsonVo<String>();
		com.victor.h5blog.entity.File file = fileService.selectById(ufileId);
		file.setFileDesc(ufileDesc);
		fileService.updateFile(file);
		json.setResult(true);
		 json.setMsg( "修改文件成功！");
		return json;
	}
	
	@SystemControllerLog(description = "修改文件目录")
	@ResponseBody
	@RequestMapping(value = "/changeFileCatlog.json", method = RequestMethod.POST)
	public JsonVo<String> updateFileCatlog(HttpServletRequest request,
			@RequestParam(value = "fid") Long fid,
			@RequestParam(value = "cid") Long cid) {
		JsonVo<String> json = new JsonVo<String>();
		com.victor.h5blog.entity.File file = fileService.selectById(fid);
		file.setCatlogId(cid);
		fileService.updateFile(file);
		json.setResult(true);
		 json.setMsg( "修改文件目录成功！");
		return json;
	}
	
	
	@SystemControllerLog(description = "新增文件目录")
	@ResponseBody
	@RequestMapping(value = "/newCatlog.json", method = RequestMethod.POST)
	public JsonVo<String> newCatlog(HttpServletRequest request,
			@RequestParam(value = "parentId") Long parentId,
			@RequestParam(value = "catlogName") String catlogName,
			@RequestParam(value = "catlogDesc") String catlogDesc) {
		JsonVo<String> json = new JsonVo<String>();
		Catlog catlog = new Catlog();
		catlog.setCatlogFatherId(parentId);
		catlog.setCatlogName(catlogName);
		catlog.setCatlogDesc(catlogDesc);
		catlog.setCatlogKey(FILE_CATLOG_KEY);
		catlog.setCreateDate(new Date());
		catlog.setCreateUser(this.getAdmin(request).getName());
		catlogService.insertCatlog(catlog);
		json.setResult(true);
		 json.setMsg( "新增目录成功！");
		return json;
	}
	
	@SystemControllerLog(description = "删除文件")
	@ResponseBody
	@RequestMapping(value = "/deleteFile.json", method = RequestMethod.POST)
	public JsonVo<String> deleteFile(HttpServletRequest request,
			@RequestParam(value = "fileId") Long fileId) {
		JsonVo<String> json = new JsonVo<String>();
		fileService.deleteFileById(request, fileId);
		json.setResult(true);
		 json.setMsg( "删除文件目录成功！");
		return json;
	}
	
	@SystemControllerLog(description = "删除文件目录")
	@ResponseBody
	@RequestMapping(value = "/deleteCatlog.json", method = RequestMethod.POST)
	public JsonVo<String> deleteCatlog(HttpServletRequest request,
			@RequestParam(value = "catlogId") Long catlogId) {
		JsonVo<String> json = new JsonVo<String>();
		List<com.victor.h5blog.entity.File> fileList = fileService.findByCatlogId(catlogId);
		if (catlogId == null) {
			json.getErrors().put("delete_id", "请选择要删除的目录");
			json.setResult(false);
			return json;
		}
		
		List<Catlog> childrenlist = catlogService.findByFatherId(catlogId);
		if(childrenlist.size() > 0){
			json.getErrors().put("delete_children", "请先删除该目录下的子目录");
			json.setResult(false);
			return json;
		}
		
		if(fileList!=null){
			for(com.victor.h5blog.entity.File file:fileList){
				file.setCatlogId(null);
				fileService.updateFile(file);
			}
		}
		
		catlogService.deleteById(catlogId);
		json.setResult(true);
		 json.setMsg( "删除目录成功！");
		return json;
	}
	
	@SystemControllerLog(description = "根据目录查询文件列表")
	@ResponseBody
	@RequestMapping(value = "/listFileByCatlog.json", method = RequestMethod.POST)
	public JsonVo<List<com.victor.h5blog.entity.File>> listFileByCatlog(HttpServletRequest request,
			@RequestParam(value = "catlogId") Long catlogId) {
		JsonVo<List<com.victor.h5blog.entity.File>> json = new JsonVo<List<com.victor.h5blog.entity.File>>();
		List<com.victor.h5blog.entity.File> fileList = fileService.findByCatlogId(catlogId);
		json.setResult(true);
		json.setT(fileList);
		return json;
	}
	
}
