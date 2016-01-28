package com.victor.h5blog.action.manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.victor.h5blog.annotation.SystemControllerLog;
import com.victor.h5blog.constant.SystemConstant;
import com.victor.h5blog.entity.PageDef;
import com.victor.h5blog.entity.PageDefAreaCom;
import com.victor.h5blog.entity.PageTemplate;
import com.victor.h5blog.entity.PageTemplateArea;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.entity.vo.PageComDefVo;
import com.victor.h5blog.service.PageComService;
import com.victor.h5blog.service.PageDefService;
import com.victor.h5blog.service.PageTplService;
import com.victor.h5blog.util.RegexUtils;

@Controller
@RequestMapping("/manage/pagedef")
public class ManagePageDefAction extends ManageBaseAction implements InitializingBean{

	@Autowired
	private PageDefService pageDefService;

	@Autowired
	private PageTplService pageTplService;

	@Autowired
	private PageComService pageComService;

	@SystemControllerLog(description = "页面定义页面访问请求")
	@RequestMapping(value = "/list.htm", method = RequestMethod.GET)
	public String list(ModelMap modelMap, HttpServletRequest request) {

		return "manage/pagedef/list";
	}
	

	/**
	 * 获取网页面定义树结构
	 * 
	 * @return
	 */
	@SystemControllerLog(description = "获取网页面定义树结构")
	@ResponseBody
	@RequestMapping(value = "/getTree.json", method = RequestMethod.POST)
	public PageDef getTree(HttpServletRequest request) {
		List<PageDef> pagelList = pageDefService.getPages();
		Map<Long, PageDef> pageMap = new HashMap<Long, PageDef>();
		List<PageDef> pageTree = new ArrayList<PageDef>();
		for (PageDef page : pagelList) {
			Long pageId = page.getId();
			Long parentId = page.getParentId();
			String url = page.getUrl();
			String pageKey = url.substring(url.lastIndexOf("/")+ 1, url.lastIndexOf("."));

			page.setPageKey(pageKey);
			
			PageDef pageVo = pageMap.get(pageId);
			//判断当前page是否是父节点
			if (pageVo == null) {
				//不是父节点添加空的孩子列表
				List<PageDef> child = new ArrayList<PageDef>();
				page.setChild(child);
			} else {
				//是父节点，将已添加的孩子节点添加到page的孩子列表中
				List<PageDef> child = pageVo.getChild();
				page.setChild(child);
			}

			if (parentId == null || parentId.equals(0L)) {
				pageTree.add(page);
			} else {
				PageDef parentPage = pageMap.get(parentId);
				if (parentPage == null) {
					parentPage = new PageDef();
					List<PageDef> child = new ArrayList<PageDef>();
					child.add(page);
					parentPage.setChild(child);
					pageMap.put(parentId, parentPage);
				} else {
					//page的父节点已经在map中，将当前page放在父节点的孩子列表中
					parentPage.getChild().add(page);
				}
			}
			pageMap.put(pageId, page);
		}
		PageDef page = new PageDef();
		page.setName("网站");
		page.setChild(pageTree);
		page.setId(0l);

		return page;
	}

	/**
	 * @author add page
	 * 
	 */
	@SystemControllerLog(description = " add page")
	@ResponseBody
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public JsonVo<Map<String, Long>> add(@RequestParam(value = "add_name") String name,
			@RequestParam(value = "add_desc") String desc,
			@RequestParam(value = "add_pageKey") String pageKey,
			@RequestParam(value = "parentId") Long parentId) {
		
		JsonVo<Map<String, Long>> json = new JsonVo<Map<String, Long>>();
		if (StringUtils.isBlank(name)) {
			json.getErrors().put("add_name", "页面名称不能为空");
		}
		if (StringUtils.isBlank(pageKey)) {
			json.getErrors().put("add_pageKey", "关键字不能为空");
		} 
		
		if(json.getErrors().size() > 0){
			json.setResult(false);
			return json;
		}
		PageDef page = new PageDef();
		page.setName(name);
		page.setDesc(desc);
		page.setPageKey(pageKey);
		if(parentId != null && parentId != 0){
			PageDef parent = pageDefService.getPageById(parentId);
			String parentUrl = parent.getUrl().substring(0, parent.getUrl().indexOf("."));
			String url = parentUrl + "/" + pageKey + SystemConstant.PAGE_SUFFIX;
			page.setUrl(url);
		}else{
			String url = "/" + pageKey + SystemConstant.PAGE_SUFFIX;
			page.setUrl(url);
		}
		pageDefService.addPage(page);
		
		Map<String, Long> response = new HashMap<String, Long>();
		response.put("id", page.getId());
		json.setResult(true);
		json.setT(response);
		return json;
	}

	/**
	 * @author update page define
	 * 
	 */
	@SystemControllerLog(description = "update page define")
	@ResponseBody
	@RequestMapping(value = "/update.json", method = RequestMethod.POST)
	public JsonVo<String> update(ModelMap modelMap, HttpServletRequest request,
			PageDef page) {
		
		JsonVo<String> json = new JsonVo<String>();
		if (StringUtils.isBlank(page.getName())) {
			json.getErrors().put("name", "页面名称不能为空");
		}
		if (StringUtils.isBlank(page.getDesc())) {
			json.getErrors().put("pageKey", "关键字不能为空");
		} 
		
		if(json.getErrors().size() > 0){
			json.setResult(false);
			return json;
		}
		
		PageDef pageOld = pageDefService.getPageById(page.getId());
		pageOld.setName(page.getName());
		pageOld.setDesc(page.getDesc());
		
		String pageKey = page.getPageKey();
		if(pageOld.getParentId() != null && pageOld.getParentId() != 0){
			PageDef parent = pageDefService.getPageById(pageOld.getParentId());
			String parentUrl = parent.getUrl().substring(0, parent.getUrl().indexOf("."));
			String url = parentUrl + "/" + pageKey + SystemConstant.PAGE_SUFFIX;
			pageOld.setUrl(url);
		}else{
			String url = "/" + pageKey + SystemConstant.PAGE_SUFFIX;
			pageOld.setUrl(url);
		}
		pageDefService.updatePage(pageOld);
		json.setResult(true);
		return json;
	}
	
	/**
	 * @author delete page define
	 * 
	 */
	@SystemControllerLog(description = "delete page define")
	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public JsonVo<String> delete(@RequestParam(value = "id") Long id) {
		pageDefService.deletePageDef(id);
		JsonVo<String> json = new JsonVo<String>();
		json.setResult(true);
		return json;
	}

	/**
	 * @author 选择模板
	 * 
	 */
	@SystemControllerLog(description = "模板选择页面访问请求")
	@RequestMapping(value = "/choosetpl/{pageId}.htm", method = RequestMethod.GET)
	public String chooseTpl(@PathVariable Long pageId, ModelMap modelMap,
			HttpServletRequest request) {
		PageDef page = pageDefService.getPageById(pageId);
		List<PageTemplate> pageTplList = pageTplService.getPageTemplateList();
		modelMap.put("pageId", pageId);
		modelMap.put("pageTplList", pageTplList);
		modelMap.put("pageTplId", page.getTplId());
		return "manage/pagedef/choosetpl";
	}

	/**
	 * @author 选择组件
	 * 
	 */
	@SystemControllerLog(description = "选择组件")
	@RequestMapping(value = "/choosecom/{pageId}/{pageTplId}.htm", method = RequestMethod.GET)
	public String chooseArea(@PathVariable Long pageId,
			@PathVariable Long pageTplId, ModelMap modelMap,
			HttpServletRequest request) {
		PageDef page = pageDefService.getPageById(pageId);
		page.setTplId(pageTplId);
		pageDefService.updatePage(page);
		List<PageTemplateArea> areaList = pageTplService.getAreaListByDefId(
				pageId, pageTplId);

		List<PageComDefVo> comDefs = pageComService.findAllPageComDef();
		modelMap.put("areaList", areaList);
		modelMap.put("pageId", pageId);
		modelMap.put("pageTplId", pageTplId);
		modelMap.put("comDefs", comDefs);
		return "manage/pagedef/choosecom";
	}

	/**
	 * @author 更新页面定义信息
	 * 
	 */
	@SystemControllerLog(description = "更新页面定义信息")
	@ResponseBody
	@RequestMapping(value = "/usecom.json", method = RequestMethod.POST)
	public JsonVo<String> useCom(
			@RequestParam(value = "pageId", defaultValue = "0") long pageId,
			@RequestParam(value = "pageTplId", defaultValue = "0") long pageTplId,
			@RequestParam(value = "areaId", defaultValue = "0") long areaId,
			@RequestParam(value = "comDefId", defaultValue = "0") long comDefId,
			ModelMap modelMap) {
		List<PageDefAreaCom> areaComList = pageDefService.getAreaCom(pageId, areaId);
		PageDefAreaCom areaCom;
		if(areaComList == null || areaComList.size() < 1){
			areaCom = new PageDefAreaCom();
			areaCom.setDefId(pageId);
			areaCom.setTplAreaId(areaId);
			areaCom.setComDefId(comDefId);
			pageDefService.addAeraCom(areaCom);
		}else{
			areaCom = areaComList.get(0);
			areaCom.setComDefId(comDefId);
			pageDefService.updateAreaComDef(areaCom);
		}
		
		JsonVo<String> json = new JsonVo<String>();
		json.setResult(true);
		return json;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @author 选择组件
	 * 
	 */
	@SystemControllerLog(description = "选择组件")
	@RequestMapping(value = "/test.htm", method = RequestMethod.GET)
	public String chooseArea(ModelMap modelMap, HttpServletRequest request) {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("url", "/manage/head.ftl");
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("url", "/manage/pagedef/area.ftl");
		result.add(map1);
		result.add(map2);
		//modelMap.put("PAGE_TPL_AREA1_COM_DEFS", result);
		return "manage/pagedef/test";
	}
}
