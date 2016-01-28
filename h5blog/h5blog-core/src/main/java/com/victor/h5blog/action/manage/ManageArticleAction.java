/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package com.victor.h5blog.action.manage;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.BeanProperty;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.victor.h5blog.action.ArticleAction;
import com.victor.h5blog.constant.ArticleConstant;
import com.victor.h5blog.constant.MediaConstant;
import com.victor.h5blog.entity.Article;
import com.victor.h5blog.entity.Media;
import com.victor.h5blog.entity.PageComDef;
import com.victor.h5blog.entity.PageComVal;
import com.victor.h5blog.entity.vo.ArticleVo;
import com.victor.h5blog.entity.vo.FolderVo;
import com.victor.h5blog.entity.vo.JsonVo;
import com.victor.h5blog.entity.vo.PageComDefVo;
import com.victor.h5blog.entity.vo.PageComValVo;
import com.victor.h5blog.entity.vo.PageComVarVo;
import com.victor.h5blog.entity.vo.PageVo;
import com.victor.h5blog.entity.vo.UserVo;
import com.victor.h5blog.exception.ArticleNotFoundException;
import com.victor.h5blog.exception.FolderNotFoundException;
import com.victor.h5blog.exception.UploadException;
import com.victor.h5blog.service.PageComService;
import com.victor.h5blog.util.SSUtils;

/**
 * @author 文件action
 * 
 */
@Controller
@RequestMapping("/manage/article")
public class ManageArticleAction extends ManageBaseAction {

	@Autowired
	private ArticleAction articleAction;
	
	@Autowired
	private PageComService pageComService;
	
	private static Long ARTICLE_COM_ID = 2L;
	
	private static String ARTICLE_TITLE = "article_title";
	private static String ARTICLE_SUMMARY = "article_summary";
	private static String ARTICLE_PUBLISHTIME = "article_publishtime";
	private static String ARTICLE_CONTENT = "article_content";
	

	@RequestMapping(value = "/add.htm", method = RequestMethod.GET)
	public String add(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap,
			@RequestParam(value = "folderId", defaultValue = "0") long folderId)
			throws FolderNotFoundException {
		UserVo userVo = this.getAdmin(request);
		modelMap.put("folderAll",
				folderService.getAllFolderList(userVo.getUserId()));
		modelMap.put("folderId", folderId);
		return "manage/article/add";
	}

	@ResponseBody
	@RequestMapping(value = "/add.json", method = RequestMethod.POST)
	public JsonVo<PageComDef> add(
			@RequestParam("title") String title,
			@RequestParam(value = "summary", required = false) String summary,
			@RequestParam("content") String content,
			@RequestParam(value = "publishTime", required = false) String publishTime,
			HttpServletRequest request, ModelMap modelMap)
			throws UploadException, ParseException {
		JsonVo<PageComDef> json = new JsonVo<PageComDef>();
		PageComDef pcd = pageComService.addPageComDefByPageComId(ARTICLE_COM_ID, title,this.getAdmin(request).getLoginName());
		
		Long pageComDefId = pcd.getId();
		List<PageComVarVo> pageComVarVoList = pageComService.findPageComVarByPageComDefId(pageComDefId);
		for(PageComVarVo pageComVarVo:pageComVarVoList){
			PageComVal pageComVal = new PageComVal();
			pageComVal.setPgComVarId(pageComVarVo.getId());
			pageComVal.setPgComDefId(pageComDefId);
			pageComVal.setPgComCode(pageComVarVo.getCode());
			if(pageComVarVo.getCode().equalsIgnoreCase(ARTICLE_TITLE)){
				pageComVal.setPgComValue(title);
			}else if(pageComVarVo.getCode().equalsIgnoreCase(ARTICLE_SUMMARY)){
				pageComVal.setPgComValue(summary);
			}else if(pageComVarVo.getCode().equalsIgnoreCase(ARTICLE_PUBLISHTIME)){
				pageComVal.setPgComValue(publishTime);
			}else if(pageComVarVo.getCode().equalsIgnoreCase(ARTICLE_CONTENT)){
				pageComVal.setPgComValue(content);
			}
			pageComVal.setCreateUser(this.getAdmin(request).getLoginName());
			pageComVal.setCreateDate(new Date());
			pageComService.addPageComVal(pageComVal);
		}
		json.setT(pcd);
		json.setResult(true);
		return json;
	}

	/**
	 * @author 进入某种文章的列表分页的首页
	 * @throws FolderNotFoundException
	 * 
	 */
	@RequestMapping(value = "/list.htm", method = RequestMethod.GET)
	public String list(
			HttpServletRequest request, ModelMap modelMap)
			throws FolderNotFoundException {
		List<PageComDefVo> pcdvList = pageComService.findAllPageComDef();
		List<PageComDefVo> resultList = new ArrayList<PageComDefVo>();
		for(PageComDefVo pcdv:pcdvList){
			if(pcdv.getPgComId()==ARTICLE_COM_ID){
				resultList.add(pcdv);
			}
		}
		modelMap.put("pageVo", resultList);
		return "manage/article/list";
	}

	/**
	 * @author 进入修改文章页面
	 * @throws Exception
	 * 
	 */
	@RequestMapping(value = "/update.htm", method = RequestMethod.GET)
	public String update(
			@RequestParam(value = "articleId") long pageComDefId,
			ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<PageComVal> pcvlist = pageComService.findAllPageComValByPageComDefId(pageComDefId);
		for(PageComVal pcv:pcvlist){
			if(pcv.getPgComCode().equalsIgnoreCase(ARTICLE_TITLE)){
				modelMap.put("title", pcv.getPgComValue());
			}else if(pcv.getPgComCode().equalsIgnoreCase(ARTICLE_SUMMARY)){
				modelMap.put("summary", pcv.getPgComValue());
			}else if(pcv.getPgComCode().equalsIgnoreCase(ARTICLE_PUBLISHTIME)){
				modelMap.put("publishtime", pcv.getPgComValue());
			}else if(pcv.getPgComCode().equalsIgnoreCase(ARTICLE_CONTENT)){
				modelMap.put("content", pcv.getPgComValue());
			}
		}
		modelMap.put("articleId", pageComDefId);
		return "manage/article/update";
	}

	/**
	 * @author 修改文章资料
	 * @param fileId
	 * @param folderId
	 * @param name
	 * @param titile
	 * @param content
	 * @param description
	 * @param status
	 * @param request
	 * @param modelMap
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping(value = "/update.json", method = RequestMethod.POST)
	public JsonVo<PageComDef> update(
			@RequestParam("articleId") long pageComDefId,
			@RequestParam("title") String title,
			@RequestParam("summary") String summary,
			@RequestParam(value = "publishtime", required = false) String publishTime,
			@RequestParam("content") String content,
			HttpServletRequest request, ModelMap modelMap)
			throws ParseException {
		JsonVo<PageComDef> json = new JsonVo<PageComDef>();
			PageComDef pcd = pageComService.selectPageComDefById(pageComDefId);
			
			List<PageComVarVo> pageComVarVoList = pageComService.findPageComVarByPageComDefId(pageComDefId);
			for(PageComVarVo pageComVarVo:pageComVarVoList){
				PageComVal pageComVal = pageComService.selectPageComValByPageComDefAndPageComVar(pageComDefId, pageComVarVo.getId());
				pageComVal.setPgComVarId(pageComVarVo.getId());
				pageComVal.setPgComDefId(pageComDefId);
				pageComVal.setPgComCode(pageComVarVo.getCode());
				if(pageComVarVo.getCode().equalsIgnoreCase(ARTICLE_TITLE)){
					pageComVal.setPgComValue(title);
				}else if(pageComVarVo.getCode().equalsIgnoreCase(ARTICLE_SUMMARY)){
					pageComVal.setPgComValue(summary);
				}else if(pageComVarVo.getCode().equalsIgnoreCase(ARTICLE_PUBLISHTIME)){
					pageComVal.setPgComValue(publishTime);
				}else if(pageComVarVo.getCode().equalsIgnoreCase(ARTICLE_CONTENT)){
					pageComVal.setPgComValue(content);
				}
				pageComVal.setChangeUser(this.getAdmin(request).getLoginName());
				pageComVal.setChangeDate(new Date());
				pageComService.updatePageComVal(pageComVal);
			}
			json.setT(pcd);
			json.setResult(true);
			return json;
	
	}

	/**
	 * @author 彻底删除文件
	 * @throws ArticleNotFoundException
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/delete.json", method = RequestMethod.POST)
	public JsonVo<String> deleteFile(
			@RequestParam(value = "articleId") long pageComDefComId)
			throws ArticleNotFoundException {
		JsonVo<String> json = new JsonVo<String>();
		pageComService.deletePageComDefAndValById(pageComDefComId);
		json.setResult(true);
		return json;
	}

	/**
	 * @author 修改文件审核状态
	 * @throws ArticleNotFoundException
	 * 
	 */
	@ResponseBody
	@RequestMapping(value = "/check.json", method = RequestMethod.POST)
	public JsonVo<String> check(
			@RequestParam(value = "articleId") long articleId,
			@RequestParam(value = "check") ArticleConstant.check check,
			HttpServletRequest request) throws ArticleNotFoundException {
		JsonVo<String> json = new JsonVo<String>();
		UserVo userVo = this.getAdmin(request);
		if (!userVo.getIsAdmin()) {
			json.setResult(false);
			json.setMsg("您不是超级管理员，无权该审核文件！");
		} else {
			articleService.updateCheck(articleId, check);
			json.setResult(true);
		}
		return json;
	}

	// @RequestMapping(value = "/preview.htm", method = RequestMethod.GET)
	// public String preview(@RequestParam(value = "articleId") long articleId,
	// @RequestParam(value = "p", defaultValue = "0") int p,
	// ModelMap modelMap, HttpServletRequest request) {
	// return articleAction.folder(articleId, p, modelMap);
	// }

	@RequestMapping(value = "/preview.htm", method = RequestMethod.GET)
	public String preview(@RequestParam(value = "articleId") long articleId,
			@RequestParam(value = "p", defaultValue = "0") int p,
			ModelMap modelMap, HttpServletRequest request) {
		return articleAction.article(articleId, p, modelMap);
	}
}
