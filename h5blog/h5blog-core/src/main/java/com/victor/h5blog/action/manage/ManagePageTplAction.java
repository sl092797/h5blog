package com.victor.h5blog.action.manage;

import java.io.UnsupportedEncodingException;
import java.util.List;

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
import com.victor.h5blog.entity.PageTemplate;
import com.victor.h5blog.entity.PageTemplateArea;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.service.PageTplService;

@Controller
@RequestMapping("/manage/pagetpl")
public class ManagePageTplAction extends ManageBaseAction implements InitializingBean{

	@Autowired
	private PageTplService pageTplService;

	@SystemControllerLog(description = "template list page")
	@RequestMapping(value = "/list.htm", method = RequestMethod.GET)
	public String list(ModelMap modelMap, HttpServletRequest request) {
		List<PageTemplate> pageTplList = pageTplService.getPageTemplateList();
		modelMap.put("pageTplList", pageTplList);
		modelMap.put("header", "/manage/head.ftl");
		return "manage/pagetpl/list";
	}

	@SystemControllerLog(description = "Template add page")
	@RequestMapping(value = "/add.htm", method = RequestMethod.GET)
	public String add(ModelMap modelMap, HttpServletRequest request) {
		return "manage/pagetpl/add";
	}

	@SystemControllerLog(description = "Template add request")
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	@ResponseBody
	public JsonVo<String> upload(
			@RequestParam(value = "file") MultipartFile file,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "desc") String desc,
			HttpServletRequest request) throws UnsupportedEncodingException {
		JsonVo<String> json = new JsonVo<String>();
		if (StringUtils.isBlank(name)) {
			json.getErrors().put("name", "页面名称不能为空");
		}
		
		if(json.getErrors().size() > 0){
			json.setResult(false);
			return json;
		}
		
		request.setCharacterEncoding(SystemConstant.ENCODEING);
		pageTplService.addPageTemplate(file, name, desc);
		json.setResult(true);
		return json;
	}

	@SystemControllerLog(description = "template preview")
	@RequestMapping(value = "/preview/{pagTplId}.htm", method = RequestMethod.GET)
	public String preview(@PathVariable long pagTplId, ModelMap modelMap,
			HttpServletRequest request) {
		PageTemplate pageTpl = pageTplService.getPageTemplateById(pagTplId);
		List<PageTemplateArea> areaList = pageTplService
				.getAreaListByTplId(pagTplId);
		if (areaList != null) {
			for (PageTemplateArea area : areaList) {
				modelMap.put(area.getAreaName(),
						"/template/area/" + area.getAreaName() + ".ftl");
			}
		}
		modelMap.put("pageTpl", pageTpl);
		return pageTpl.getPath();
	}

	@SystemControllerLog(description = "template update page")
	@RequestMapping(value = "/update/{pagTplId}.htm", method = RequestMethod.GET)
	public String update(@PathVariable long pagTplId, ModelMap modelMap,
			HttpServletRequest request) {
		PageTemplate pageTpl = pageTplService.getPageTemplateById(pagTplId);
		modelMap.put("pageTpl", pageTpl);
		return "manage/pagetpl/update";
	}

	@SystemControllerLog(description = "template update request")
	@RequestMapping(value = "/update/{pagTplId}.json", method = RequestMethod.POST)
	@ResponseBody
	public JsonVo<String> updateTpl(@PathVariable long pagTplId,  ModelMap modelMap,
			HttpServletRequest request, PageTemplate pageTpl) {
		JsonVo<String> json = new JsonVo<String>();
		if (StringUtils.isBlank(pageTpl.getName())) {
			json.getErrors().put("name", "页面名称不能为空");
		}
		
		if(json.getErrors().size() > 0){
			json.setResult(false);
			return json;
		}
		
		PageTemplate pageTpl2 = pageTplService.getPageTemplateById(pagTplId);
		pageTpl2.setName(pageTpl.getName());
		pageTpl2.setDesc(pageTpl.getDesc());
		pageTplService.updatePageTpl(pageTpl);
		
		json.setResult(true);
		return json;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		pageTplService.initPageTpl();
		
	}

}
