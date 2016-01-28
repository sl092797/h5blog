package com.victor.h5blog.action.manage;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.victor.h5blog.annotation.SystemControllerLog;
import com.victor.h5blog.entity.Catlog;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.service.CatlogService;

/**
 * 
 * @author 立
 *
 */
@Controller
@RequestMapping("/manage/catlog")
public class ManageCatlogAction extends ManageBaseAction{
	
	private long PAGE_COM_CATLOG_TYPE = 1L;
	
	@Autowired
	private CatlogService catlogService;
	
	/**
	 * 获取目录类型默认为0
	 * @param type
	 * @return
	 */
	private Long getCatlogType(String type){
		Long catlogType = 0L;
		switch(type){
			case "pagecom":
				catlogType = PAGE_COM_CATLOG_TYPE;
				break;
		}
		return catlogType;
	}
	
	/**
	 * 获取目录树结构
	 * 
	 * @return
	 */
	@SystemControllerLog(description = "获取组件目录树结构")
	@ResponseBody
	@RequestMapping(value = "/getTree.json", method = RequestMethod.POST)
	public Catlog getTree(HttpServletRequest request,@RequestParam(value = "type") String type) {
		Long catlogType = getCatlogType(type);
		List<Catlog> catloglist = catlogService.findCatlogByType(catlogType);
		Map<Long, Catlog> catlogMap = new HashMap<Long, Catlog>();
		List<Catlog> catlogTree = new ArrayList<Catlog>();
		for (Catlog catlog : catloglist) {
			Long catlogId = catlog.getId();
			Long parentId = catlog.getFatherId();
			
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
		catlog.setName("组件列表");
		catlog.setChild(catlogTree);
		catlog.setId(0l);

		return catlog;
	}
	
	/**
	 * 添加目录
	 * 
	 * @return
	 */
	@SystemControllerLog(description = "添加目录")
	@ResponseBody
	@RequestMapping(value = "/addCatlog.json", method = RequestMethod.POST)
	public  JsonVo<Map<String, Long>> addCatlog(HttpServletRequest request,
			@RequestParam(value = "parentId") Long parentId,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "type") String type) {
		JsonVo<Map<String, Long>> json = new JsonVo<Map<String, Long>>();
		if (StringUtils.isBlank(name)) {
			json.getErrors().put("add_name", "目录名称不能为空");
		}
		
		if(json.getErrors().size() > 0){
			json.setResult(false);
			return json;
		}
		
		Long catlogType = getCatlogType(type);
		Catlog catlog = new Catlog();
		catlog.setName(name);
		catlog.setType(catlogType);
		catlog.setFatherId(parentId);
		catlog.setCreateUser(this.getAdmin(request).getLoginName());
		catlog.setCreateDate(new Date());
		catlogService.addCatlog(catlog);
	
		Map<String, Long> response = new HashMap<String, Long>();
		json.setResult(true);
		json.setT(response);
		return json;
	}
	
	/**
	 * 修改目录
	 * 
	 * @return
	 */
	@SystemControllerLog(description = "修改目录")
	@ResponseBody
	@RequestMapping(value = "/updateCatlog.json", method = RequestMethod.POST)
	public  JsonVo<Map<String, Long>> updateCatlog(HttpServletRequest request,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "type") String type) {
		JsonVo<Map<String, Long>> json = new JsonVo<Map<String, Long>>();
		if (request.getParameter("id")==null||request.getParameter("id").equals("")) {
			json.getErrors().put("update_id", "请选择要修改的目录");
		}
		if (StringUtils.isBlank(name)) {
			json.getErrors().put("update_name", "目录名称不能为空");
		}
		
		
		
		if(json.getErrors().size() > 0){
			json.setResult(false);
			return json;
		}
		long id =Long.parseLong(request.getParameter("id"));
		
		Catlog catlog = catlogService.selectCatlogById(id);
		catlog.setName(name);
		catlog.setChangeDate(new Date());
		catlog.setChangeUser(this.getAdmin(request).getLoginName());
		catlogService.updateCatlog(catlog);
	
		Map<String, Long> response = new HashMap<String, Long>();
		json.setResult(true);
		json.setT(response);
		return json;
	}
	
	
}
