package com.victor.h5blog.action.manage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.victor.h5blog.annotation.SystemControllerLog;
import com.victor.h5blog.constant.SystemConstant;
import com.victor.h5blog.entity.Catlog;
import com.victor.h5blog.entity.PageCom;
import com.victor.h5blog.entity.PageComDef;
import com.victor.h5blog.entity.PageComVal;
import com.victor.h5blog.entity.PageComVar;
import com.victor.h5blog.entity.PageComVarExample;
import com.victor.h5blog.entity.PageDef;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.entity.vo.PageComDefVo;
import com.victor.h5blog.entity.vo.PageComValVo;
import com.victor.h5blog.entity.vo.PageComVo;
import com.victor.h5blog.service.CatlogService;
import com.victor.h5blog.service.PageComService;
import com.victor.h5blog.service.RenderPageService;
import com.victor.h5blog.util.SSUtils;

/**
 * 
 * @author shengli
 * @date 2015年11月18日
 */
@Controller
@RequestMapping("/manage/pagecom")
public class ManagePageComAction extends ManageBaseAction {

	@Autowired
	private PageComService pageComService;
	
	@Autowired
	private RenderPageService renderPageService;
	
	@Autowired
	private CatlogService catlogService;

	/**
	 * list pageComposite define
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.GET)
	public String listPageComDef(HttpServletRequest request, ModelMap modelMap) throws IOException {
		modelMap.put("pageVo", pageComService.findAllPageComDef());
		return "manage/pagecom/list";
	}
	
	@SystemControllerLog(description = "通过目录访问组件列表")
	@ResponseBody
	@RequestMapping(value = "/listPageDefByCatlog.json", method = RequestMethod.POST)
	public List<PageComDefVo> listPageDefByCatlog( HttpServletRequest request,@RequestParam(value = "catlogId") Long catlogId) {

		return pageComService.findPageComDefVoByCatlogId(catlogId);
	}
	
	
	/**
	 * list pageComposite
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/chooseCom.htm", method = RequestMethod.GET)
	public String listPageCom(HttpServletRequest request, ModelMap modelMap) throws IOException {
		modelMap.put("pageCom", pageComService.findAllPageCom());
		return "manage/pagecom/chooseCom";
	}

	/**
	 * add composite define
	 * 
	 * @param pageComId
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addCom.json", method = RequestMethod.POST)
	public JsonVo<PageComVo> addPageCom(PageComVo pcVo,
			HttpServletRequest request) {
		JsonVo<PageComVo> json = new JsonVo<PageComVo>();
		Long pcId = pageComService.addAndUpdatePageCom(pcVo);
		List<String> codeList = pageComService.getCodeList(pcVo.getContext());
		for (String code : codeList) {
			PageComVar pcv = new PageComVar();
			pcv.setCode(code);
			pageComService.addPageComVarByPageComId(pcv, pcId);
		}
		json.setT(pcVo);
		json.setResult(true);
		return json;
	}
	
	/**
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@SystemControllerLog(description = "Component Upload Page")
	@RequestMapping(value = "/upload.htm", method = RequestMethod.GET)
	public String addcom(HttpServletRequest request, ModelMap modelMap) {
		return "manage/pagecom/addcom";
	}
	
	/**
	 * 
	 * @param file
	 * @param name
	 * @param desc
	 * @param request
	 * @return
	 * @throws IOException 
	 */
	@SystemControllerLog(description = "Component Upload")
	@RequestMapping(value = "/upload.json", method = RequestMethod.POST)
	@ResponseBody
	public JsonVo<String> upload(
			@RequestParam(value = "file") MultipartFile file,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "desc") String desc,
			HttpServletRequest request) throws IOException {
		request.setCharacterEncoding(SystemConstant.ENCODEING);
		pageComService.addPageComTpl(file, name, desc);
		JsonVo<String> json = new JsonVo<String>();
		json.setResult(true);
		return json;
	}

	/**
	 * add composite define
	 * 
	 * @param pageComId
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public JsonVo<PageComDefVo> addPageComDef(
			@RequestParam("pageComId") long pageComId,@RequestParam("desc") String desc,
			HttpServletRequest request) {
		PageComDef pcd = pageComService.addPageComDefByPageComId(pageComId,desc,
				this.getAdmin(request).getLoginName());
		PageComDefVo pcdv = new PageComDefVo();
		BeanUtils.copyProperties(pcd, pcdv);
		JsonVo<PageComDefVo> json = new JsonVo<PageComDefVo>();
		json.setT(pcdv);
		json.setResult(true);
		return json;
	}
	
	@SystemControllerLog(description = "pageComDef's catlog changed")
	@RequestMapping(value = "/changeCatlog.json", method = RequestMethod.POST)
	@ResponseBody
	public JsonVo<String> changeCatlog(
			@RequestParam(value = "pid") Long pid,
			@RequestParam(value = "cid") Long cid,
			HttpServletRequest request){
		JsonVo<String> json = new JsonVo<String>();
		pageComService.changePageComDefCatlog(pid, cid);
		json.setResult(true);
		return json;
	}

	

	/**
	 * forward to add composite define page
	 * 
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/add.htm", method = RequestMethod.GET)
	public String addPageComDef(@RequestParam("pageComId") long pageComId,HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("pageCom", pageComService.selectPageComById(pageComId));
		return "manage/pagecom/add";
	}
	
	@SystemControllerLog(description = "update pageComDef")
	@RequestMapping(value = "/updatePageComDef.json", method = RequestMethod.POST)
	@ResponseBody
	public JsonVo<String> updatePageComDef(
			@RequestParam(value = "id") Long id,
			@RequestParam(value = "desc") String desc,
			HttpServletRequest request){
		JsonVo<String> json = new JsonVo<String>();
		PageComDef pageComDef = pageComService.selectPageComDefById(id);
		pageComDef.setChangeDate(new Date());
		pageComDef.setChangeUser(this.getAdmin(request).getLoginName());
		pageComDef.setDesc(desc);
		pageComService.updatePageComDef(pageComDef);
		json.setResult(true);
		return json;
	}

	/**
	 * forward to update composite define page
	 * 
	 * @param pageComDefId
	 * @param request
	 * @param modelMap
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	@RequestMapping(value = "/update.htm", method = RequestMethod.GET)
	public String update(
			@RequestParam("pageComDefId") long pageComDefId,
			HttpServletRequest request, ModelMap modelMap)
			throws ClassNotFoundException, IllegalAccessException,
			InstantiationException {
		modelMap.put("pageComVarList",
				pageComService.findPageComVarByPageComDefId(pageComDefId));
		modelMap.put("pageComDefId", pageComDefId);
		
		return "manage/pagecom/update";
	}
	
	/**
	 * 
	 * @param pageComId
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/updateCom.htm", method = RequestMethod.GET)
	public String updatePageCom(
			@RequestParam("pageComId") long pageComId,
			HttpServletRequest request, ModelMap modelMap){
		PageCom  pc = pageComService.selectPageComById(pageComId);
		PageComVo pcv = new PageComVo();
		BeanUtils.copyProperties(pc, pcv);
		pcv.setContext(SSUtils.toText(pc.getContext()));
		modelMap.put("pageCom", pcv);
		return "manage/pagecom/updateCom";
	}
	
	/**
	 * 
	 * @param vo
	 * @param request
	 * @param modelAndView
	 * @return
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping(value = "/updateCom.json", method = RequestMethod.POST)
	public JsonVo<PageComVo> updateCom(PageComVo pcVo,
			HttpServletRequest request, ModelAndView modelAndView) throws IOException {
		JsonVo<PageComVo> json = new JsonVo<PageComVo>();
		String ftlPath = SystemConstant.LEGOO_CMS_ROOT + "\\static\\"+pcVo.getFtlPath();
		File comftl = new File(ftlPath);
		if (!comftl.exists() || comftl.isDirectory()) {
			logger.error("file is not exists");
		}else{
			FileWriter fw = new FileWriter(comftl);
			fw.write(pcVo.getContext());
			fw.flush();
			fw.close();
		}
		pcVo.setChangeUser(this.getAdmin(request).getLoginName());
		pcVo.setChangeDate(new Date());
		pageComService.addAndUpdatePageCom(pcVo);
		pageComService.addCode(pcVo.getId(), ftlPath);
		json.setResult(true);
		return json;
	}

	/**
	 * update composite value
	 * 
	 * @param vo
	 * @param request
	 * @param modelAndView
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateVal.json", method = RequestMethod.POST)
	public JsonVo<PageComValVo> updateVal(PageComValVo vo,
			@RequestParam("pageComVarName") String pageComVarName,
			@RequestParam("pageComVarDesc") String pageComVarDesc,
			HttpServletRequest request, ModelAndView modelAndView) {
		JsonVo<PageComValVo> json = new JsonVo<PageComValVo>();
		try {
			PageComVal pcv = new PageComVal();
			PageComVar pcvar = pageComService.selectPageComVarById(vo.getPageComVar().getId());
			pcvar.setName(pageComVarName);
			pcvar.setDesc(pageComVarDesc);
			pcvar.setChangeDate(new Date());
			pcvar.setChangeUser(this.getAdmin(request).getLoginName());
			pageComService.updatePageComVar(pcvar);
			BeanUtils.copyProperties(vo, pcv);
			pcv.setChangeUser(this.getAdmin(request).getLoginName());
			pcv.setChangeDate(new Date());
			pcv.setPgComVarId(vo.getPageComVar().getId());
			pageComService.updatePageComVal(pcv);
			json.setT(vo);
			json.setResult(true);
			modelAndView.addObject("pageComDefId", vo.getPgComDefId());
			return json; 
		} catch (Exception e) {
			logger.error(e.getMessage());
			json.setResult(false);
			return json;
		}

	}

	/**
	 * forward to update value Page
	 * 
	 * @param pageComDefId
	 * @param pageComVarId
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/updateVal.htm", method = RequestMethod.GET)
	public String updateValPage(
			@RequestParam("pageComDefId") long pageComDefId,
			@RequestParam("pageComVarId") long pageComVarId,
			HttpServletRequest request, ModelMap modelMap) {
		if (request.getParameter("pageComValId") != null) {
			Long pageComValId = Long.parseLong(request
					.getParameter("pageComValId"));
			modelMap.put("pageComDefId", pageComDefId);
			modelMap.put("pageComVarId", pageComVarId);
			modelMap.put("pageVo",
 pageComService
					.selectPageComValVoByPageComValId(pageComValId));
		} else if (request.getParameter("pageComDefId") != null
				&& request.getParameter("pageComVarId") != null) {
			modelMap.put("pageComDefId", pageComDefId);
			modelMap.put("pageComVarId", pageComVarId);
			PageComValVo pcvv = new PageComValVo();
			pcvv.setPageComVar(pageComService
					.selectPageComVarById(pageComVarId));
			modelMap.put("pageVo", pcvv);
		}
		return "manage/pagecom/updateVal";
	}

	/**
	 * forward to add variable Page
	 * 
	 * @param pageComDefId
	 * @param pageComVarId
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/addVar.htm", method = RequestMethod.GET)
	public String addVarPage(@RequestParam("pageComDefId") long pageComDefId,
			HttpServletRequest request, ModelMap modelMap) {
		modelMap.put("pageComDefId", pageComDefId);
		return "manage/pagecom/addVar";
	}

	/**
	 * 删除目录
	 * 
	 * @return
	 */
	@SystemControllerLog(description = "删除目录")
	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public  JsonVo<Map<String, Long>> deleteCatlog(
			HttpServletRequest request) {
		JsonVo<Map<String, Long>> json = new JsonVo<Map<String, Long>>();
		if (request.getParameter("id")==null||request.getParameter("id").equals("")) {
			json.getErrors().put("delete_id", "请选择要删除的目录");
			json.setResult(false);
			return json;
		}
		
		long id =Long.parseLong(request.getParameter("id"));
		List<Catlog> childrenlist = catlogService.findChildren(id);
		if(childrenlist.size() > 0){
			json.getErrors().put("delete_children", "请先删除该目录下的子目录");
			json.setResult(false);
			return json;
		}
		
		
		List<PageComDefVo> plist = pageComService.findPageComDefVoByCatlogId(id);
		for(PageComDefVo p:plist){
			pageComService.changePageComDefCatlog(p.getId(), null);
		}
		
		catlogService.deletCatlog(id);
	
		Map<String, Long> response = new HashMap<String, Long>();
		json.setResult(true);
		json.setT(response);
		return json;
	}

	/**
	 * convert String to date
	 * 
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-mm-dd hh:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

}
