package com.victor.h5blog.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.victor.h5blog.constant.SystemConstant;
import com.victor.h5blog.dao.PageComDao;
import com.victor.h5blog.dao.PageComDefDao;
import com.victor.h5blog.dao.PageComValDao;
import com.victor.h5blog.dao.PageDefDao;
import com.victor.h5blog.entity.PageComDef;
import com.victor.h5blog.entity.PageComVal;
import com.victor.h5blog.entity.PageComValExample;
import com.victor.h5blog.entity.PageDef;
import com.victor.h5blog.entity.PageDefAreaCom;
import com.victor.h5blog.entity.PageDefExample;
import com.victor.h5blog.entity.PageTemplate;
import com.victor.h5blog.entity.PageTemplateArea;
import com.victor.h5blog.exception.PageNotFoundExcetption;

/**
 * 
 * @author 立
 *
 */
@Service
public class RenderPageService {

	private String CONTEXT = SystemConstant.LEGOO_CMS_ROOT + "\\static\\";

	@Autowired
	private PageDefService pageDefService;

	@Autowired
	private PageTplService pageTplService;

	@Autowired
	private PageDefDao pageDefDao;

	@Autowired
	private PageComDao pageComDao;

	@Autowired
	private PageComDefDao pageComDefDao;
	
	@Autowired
	private PageComValDao pageComValDao;

	private static Map<String, PageDef> urlToPageDef;

	@PostConstruct
	public void init() {
		if (urlToPageDef == null) {
			urlToPageDef = new HashMap<String, PageDef>();
			List<PageDef> pages = pageDefService.getPages();
			for (PageDef def : pages) {
				urlToPageDef.put(def.getUrl(), def);
			}
		}
	}

	public String combinePage(String pageUrl, ModelMap modelMap) throws PageNotFoundExcetption{
		PageDefExample example = new PageDefExample();
		example.createCriteria().andUrlLike(pageUrl);
		List<PageDef> defList = pageDefDao.selectByExample(example);
		if(defList == null || defList.size() < 1){
			throw new PageNotFoundExcetption("页面定义未找到");
		}
		PageDef pageDef = defList.get(0);
		Long tplId = pageDef.getTplId();
		List<PageTemplateArea> areaList = pageTplService.getAreaListByDefId(pageDef.getId(), tplId);
		for(PageTemplateArea area : areaList){
			List<PageTemplateArea> defs = new ArrayList<PageTemplateArea>();
			defs.add(area);
			modelMap.put(area.getAreaName() + "_COM_DEFS", defs);
			
			PageComValExample valExample = new PageComValExample();
			valExample.createCriteria().andPgComDefIdEqualTo(area.getComDefId());
			List<PageComVal> comValList = pageComValDao.selectByExample(valExample);
			for(PageComVal val : comValList){
				modelMap.put(val.getPgComCode(), val.getPgComValue());
			}
			
		}
		
		PageTemplate pageTpl = pageTplService.getPageTemplateById(tplId);
		return pageTpl.getPath();
		
	}

	public String combinePage(Long pageDefId) throws IOException {

		PageDef pageDef = pageDefService.getPageById(pageDefId);
		PageTemplate pageTpl = pageTplService.getPageTemplateById(pageDef
				.getTplId());
		// 查找出需要替换组件url的map
		Map<String, List<String>> ptacMap = new HashMap<String, List<String>>();
		List<PageTemplateArea> ptalist = pageTplService
				.getAreaListByTplId(pageTpl.getId());
		for (PageTemplateArea pta : ptalist) {
			List<PageDefAreaCom> pdaclist = pageDefService.getAreaCom(
					pageDefId, pta.getPgTplArea());
			List<String> pcUrllist = new ArrayList<String>();
			for (PageDefAreaCom pdac : pdaclist) {
				PageComDef pcd = pageComDefDao.selectByPrimaryKey(pdac
						.getComDefId());
				String pcUrl = pageComDao.selectByPrimaryKey(pcd.getPgComId())
						.getContext();
				pcUrllist.add(pcUrl);
			}
			ptacMap.put(pta.getAreaName(), pcUrllist);
		}

		// 给页面模板添加#include组件ftl
		String tplUrl = CONTEXT + pageTpl.getPath();
		String pageUrl = CONTEXT + "tmp" + pageDef.getUrl();
		File tplftl = new File(tplUrl);
		File pageFtl = new File(pageUrl);
		if (!tplftl.exists() || tplftl.isDirectory()) {
			throw new FileNotFoundException();
		}
		FileReader fr = new FileReader(tplftl);
		FileWriter fw = new FileWriter(pageFtl);
		BufferedReader br = new BufferedReader(fr);
		String readString = null;
		StringBuffer sb = new StringBuffer();
		while ((readString = br.readLine()) != null) {
			sb.append(readString + "\n");
			for (Map.Entry<String, List<String>> ptacEntry : ptacMap.entrySet()) {
				String areaName = ptacEntry.getKey();
				if (readString.contains(areaName)) {
					List<String> pcUrllist = ptacEntry.getValue();
					for (int i = 0; i < pcUrllist.size(); i++) {
						sb.append("<#include \".." + pcUrllist.get(i) + "\">\n");
					}
				}
			}
		}
		br.close();
		fw.write(sb.toString());
		fw.flush();
		fw.close();
		return "/tmp" + pageDef.getUrl();
	}

	public Map<String, PageDef> getUrlToPageDef() {
		return urlToPageDef;
	}

	public static void main(String[] args) {
		System.out.println(RenderPageService.class.getClass().getResource("/")
				.getPath());
	}

}
